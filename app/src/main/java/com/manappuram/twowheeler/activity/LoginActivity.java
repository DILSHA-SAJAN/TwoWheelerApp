package com.manappuram.twowheeler.activity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityLoginBinding;
import com.manappuram.twowheeler.request.DealerLoginRequest;
import com.manappuram.twowheeler.request.LoginRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;
    LoginViewModel viewModel;
    private int tab_position = 0; // To identify Dealer and Employee
    private String post_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);


//test
        tabSelect();
        showVersion();
        login();
        ObserveEmpLoginResponse();
        ObserveDealerLoginResponse();


    }

    private void checkEmpPermission() {

    }


    private void login() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Utility.isOnline(getApplicationContext())) {
                    dismissKeyboard();
                    if (tab_position == 0 && isValid()) {
                        callLoginDealer();
                    } else if (tab_position == 1 && isValid()) {
                        callLoginEmployee();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please check network connection",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValid() {
        if (binding.usernameInput.getText().toString().equals("") || binding.passwordInput.getText().toString().equals("")) {
            Toast.makeText(this, "UserName and Password cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void callLoginEmployee() {


        LoginRequest request = new LoginRequest();
        request.setEmpCode(binding.usernameInput.getText().toString());
        request.setPwd(Utility.encodeString(binding.passwordInput.getText().toString()));
        viewModel.login(request);
        Utility.setProgressbar(this);


    }

    private void ObserveEmpLoginResponse() {

        viewModel.getLoginResponseMutable().observe(this, loginResponse -> {
            //Log.d("loginResponse", loginResponse.toString());
            Utility.cancelProgressbar();


            if (loginResponse.getStatus().equals("111")) {
                if (loginResponse.empDetails.sessionId != null) {
                    editor.putString("empCode", loginResponse.empDetails.empCode);
                    editor.putString("postId", loginResponse.empDetails.postId);
                    editor.putString("sessionId", loginResponse.empDetails.sessionId);
                    editor.putString("name", loginResponse.empDetails.name);
                    editor.putString("brId", loginResponse.empDetails.branchId);
                    editor.putString("departId", loginResponse.empDetails.deptId);
                    editor.putString("areaId", loginResponse.empDetails.areaId);
                    editor.putString("regionId", loginResponse.empDetails.regionId);
                    editor.putString("zoneId", loginResponse.empDetails.zoneId);
                    editor.putString("designation", loginResponse.empDetails.designation);
                    editor.putBoolean("login", true);
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Welcome " + loginResponse.empDetails.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewCustomerActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(this, "Session Id not available", Toast.LENGTH_SHORT).show();
                }
            } else if (loginResponse.getStatus().equals("222")) {
                Toast.makeText(this, "Incorrect Username/Password", Toast.LENGTH_SHORT).show();
                // viewModel.setLoginResponseMutable(null);
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
                Utility.cancelProgressbar();
                Toast.makeText(this, "Incorrect Empcode or password", Toast.LENGTH_SHORT).show();
                if (error.getContentIfNotHandled() != null && error.getContent() != null) {
                }
            });


        });


    }

    private void ObserveDealerLoginResponse() {
        viewModel.getDealerLoginResponseMutableLiveData().observe(this, dealerLoginResponse -> {

            Utility.cancelProgressbar();
            if (dealerLoginResponse != null) {

                if (dealerLoginResponse.getStatus().equals("111")) {
                    editor.putString("empCode", dealerLoginResponse.dealerDetails.dealerCode);
                    editor.putString("sessionId", dealerLoginResponse.dealerDetails.sessionid);
                    editor.putString("name", dealerLoginResponse.dealerDetails.ownername);
                    editor.putString("postId", "dealer");
                    //   editor.putString("departId", dealerLoginResponse.dealerDetails.deptId);
                    //   editor.putString("areaId", dealerLoginResponse.dealerDetails.areaId);
                    //   editor.putString("regionId", dealerLoginResponse.dealerDetails.regionId);
                    //   editor.putString("zoneId", dealerLoginResponse.dealerDetails.zoneId);
                    editor.putBoolean("login", true);
                    editor.apply();

                    Toast.makeText(LoginActivity.this, "Welcome " + dealerLoginResponse.dealerDetails.getOwnername(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewCustomerActivity.class);
                    startActivity(intent);
                } else if (dealerLoginResponse.getStatus().equals("222")) {

                    Toast.makeText(LoginActivity.this, "Incorrect Dealer code  or Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void tabSelect() {
        binding.tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            InputFilter[] filters = new InputFilter[1];

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) { // Dealer
                    binding.usernameInput.setText("");
                    binding.passwordInput.setText("");
                    tab_position = tab.getPosition();
                    binding.username.setHint("Dealer Code");
                    binding.usernameInput.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                    binding.usernameInput.setInputType(InputType.TYPE_CLASS_TEXT);
                    filters[0] = new InputFilter.LengthFilter(12); //Filter to 11 characters
                    binding.usernameInput.setFilters(filters);


                } else { // Employee
                    binding.usernameInput.setText("");
                    binding.passwordInput.setText("");
                    tab_position = tab.getPosition();
                    binding.username.setHint("Employee Code");
                    binding.usernameInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                    filters[0] = new InputFilter.LengthFilter(6); //Filter to 6 characters
                    binding.usernameInput.setFilters(filters);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void callLoginDealer() {
        DealerLoginRequest request = new DealerLoginRequest();
        request.setDealerCode(binding.usernameInput.getText().toString());
        request.setPwd(binding.passwordInput.getText().toString());
        viewModel.dealerLogin(request);
        Utility.setProgressbar(this);
    }

    public void showVersion() {
        PackageInfo pInfo;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            int endIndex = version.lastIndexOf(" ");
            if (endIndex != -1) {
                version = version.substring(0, endIndex);
            }
            binding.tvVersion.setText("Version: " + version);
        } catch (PackageManager.NameNotFoundException e) {
            // e.printStackTrace();
        }

    }

    private void dismissKeyboard() {

        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}