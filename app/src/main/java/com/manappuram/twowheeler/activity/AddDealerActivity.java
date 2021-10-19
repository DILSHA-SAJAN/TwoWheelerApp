package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityAddDealerBinding;
import com.manappuram.twowheeler.request.AddDealerRequest;
import com.manappuram.twowheeler.request.StateFromPinRequest;
import com.manappuram.twowheeler.response.DistrictResponse;
import com.manappuram.twowheeler.response.PostOfficeResponse;
import com.manappuram.twowheeler.response.StateResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDealerActivity extends AppCompatActivity {

    ActivityAddDealerBinding binding;
    LoginViewModel viewModel;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";

    String[] id_type = {"--ID TYPE--", "AADHAR", "VOTER ID"};
    public String selected_id_type = "";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+";

    ArrayList<String> state_list_name = new ArrayList<String>();
    ArrayList<String> state_list_id = new ArrayList<String>();
    ArrayList<String> district_list_name = new ArrayList<String>();
    ArrayAdapter<String> districtAdapter;


    StateResponse stateResponse = new StateResponse();
    DistrictResponse districtResponse = new DistrictResponse();
    public String selectedState = "";
    public String selectedDist = "";
    public String selectedPostOffice = "";
    ArrayAdapter<String> postOfficeAdapter;
    PostOfficeResponse poResponse = new PostOfficeResponse();
    ArrayList<String> po_name = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_dealer);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    addDealerRetrofit();
                }
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getItemTypeSpinner();

        pincodeChange();

    }



    // Function to validate the AADHAR number.
    public static boolean isValidAadhar(String aadharNo) {
        String regex = "[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}";

        Pattern p = Pattern.compile(regex);
        if (aadharNo == null) {
            return false;
        }
        Matcher m = p.matcher(aadharNo);
        return m.matches();
    }

    // Function to validate the Voters ID.
    public static boolean isValidVoterID(String voterID) {
        String regex = "[a-zA-Z]{3}[0-9]{7}";
//        ^([a-zA-Z]){3}([0-9]){7}?$

        Pattern p = Pattern.compile(regex);
        if (voterID == null) {
            return false;
        }
        Matcher m = p.matcher(voterID);
        return m.matches();
    }

    private void clearFields() {
        binding.rlState.setVisibility(View.GONE);
        binding.rlDistrict.setVisibility(View.GONE);
        binding.rlPostOffice.setVisibility(View.GONE);
        selectedState = "";
        selectedDist = "";
        selectedPostOffice = "";
        binding.etPinState.setText("");
        binding.etDistrict.setText("");
    }

    private void pincodeChange() {
        binding.etPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearFields();

                if (binding.etPin.getText().toString().length() == 6) {
                    getStateFromPin();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void getItemTypeSpinner() {

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, id_type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spIdtype.setAdapter(aa);
        binding.spIdtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                InputFilter[] filters = new InputFilter[1];
                switch (position) {
                    case 0:
                        selected_id_type = "";
                        break;
                    case 1: //AADHAR
                        binding.etIdnumber.setText("");
                        selected_id_type = "AADHAR";
                        binding.etIdnumber.setInputType(InputType.TYPE_CLASS_NUMBER);
                        filters[0] = new InputFilter.LengthFilter(12); //Filter to 12 characters
                        binding.etIdnumber.setFilters(filters);
                        break;
                    case 2: //VOTERID
                        binding.etIdnumber.setText("");
                        selected_id_type = "VOTER ID";
                        filters[0] = new InputFilter.LengthFilter(20); //Filter to 12 characters
                        binding.etIdnumber.setFilters(filters);
                        binding.etIdnumber.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }

                // Toast.makeText(getApplicationContext(), "Selected ID: " +id_type[position], Toast.LENGTH_LONG).show();
                //   Toast.makeText(getApplicationContext(), "Selected ID: " + selected_id_type, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }


    private void getStateFromPin() {
        StateFromPinRequest request = new StateFromPinRequest();
        request.setFlag("GET_PIN_STATE_DIST");
        request.setPin(binding.etPin.getText().toString());
        request.setSessionId(sessionId);
        viewModel.getStateFromPin(request);
        Utility.setProgressbar(this);
        viewModel.getStateResponseMutableLiveData().observe(this, stateResponse1 -> {
            Utility.cancelProgressbar();

            if (stateResponse1 != null) {
                if (stateResponse1.getStatus().equals("111")) {
                    if (stateResponse1.getStateList().size() > 0) {
                        for (int i = 0; i < stateResponse1.getStateList().size(); i++) {
                            selectedState = stateResponse1.getStateList().get(i).getStateId();
                            selectedDist = stateResponse1.getStateList().get(i).getDistrict_name();
                            binding.etPinState.setText(stateResponse1.getStateList().get(i).getStateName());
                            binding.etDistrict.setText(stateResponse1.getStateList().get(i).getDistrict_name());
                            binding.rlState.setVisibility(View.VISIBLE);
                            binding.rlDistrict.setVisibility(View.VISIBLE);
                            getPOValues();

                        }

                    }
                } else if (stateResponse1.getStatus().equals("222") && !binding.etPinState.getText().toString().equals("")) {
                    Toast.makeText(this, "Enter Valid Pin", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    clearFields();
                }

            }
        });

    }


    private void getPOValues() {


        postOfficeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, po_name);
        postOfficeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StateFromPinRequest request = new StateFromPinRequest();
        request.setFlag("GET_PIN_POST");
        request.setPin(binding.etPin.getText().toString());
        request.setSessionId(sessionId);
        viewModel.getPostOffice(request);

        viewModel.getPostOfficeResponseMutableLiveData().observe(this, poResponse1 -> {
            poResponse = poResponse1;
            if (poResponse.getPostList() != null) {

                if (poResponse.getStatus().equals("111") && !selectedDist.equals("") && !selectedState.equals("")) {

                    if (poResponse.getPostList().size() > 0) {

                        binding.rlPostOffice.setVisibility(View.VISIBLE);
                        po_name.clear();
                        po_name.add("Select Post Office");
                        for (int i = 0; i < poResponse.getPostList().size(); i++) {
                            po_name.add(poResponse.getPostList().get(i).getPost_office());

                        }
                        binding.postOfficeSpinner.setAdapter(postOfficeAdapter);
                        postOfficeAdapter.notifyDataSetChanged();
                    }

                } else {
                    Toast.makeText(this, "Enter Valid Pin", Toast.LENGTH_SHORT).show();
                    clearFields();
                }
            }


        });
        binding.postOfficeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0) {

                    selectedPostOffice = poResponse.getPostList().get(position - 1).getPost_office();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
            if (error.getContent() != null) {
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addDealerRetrofit() {
        AddDealerRequest request = new AddDealerRequest();
        request.setFlag("ADD_DEALER");
        request.setShop_name(binding.etShopname.getText().toString());
        request.setOwner_name(binding.etOwner.getText().toString());
        request.setShop_gst(binding.etGst.getText().toString());
        request.setPan_no(binding.etPan.getText().toString());
        request.setId_no(binding.etIdnumber.getText().toString());
        request.setId_type(selected_id_type);
        request.setLoc_name(binding.etLocation.getText().toString());
        request.setPost_office(selectedPostOffice);
        request.setDistrict(selectedDist);
        request.setState(selectedState);
        request.setPin(binding.etPin.getText().toString());
        request.setMob(binding.etMobnumber.getText().toString());
        request.setEmail(binding.etEmail.getText().toString());
        request.setUpload_by(empCode);
        request.setSessionId(sessionId);

        viewModel.addDealer(request);
        Utility.setProgressbar(this);

        viewModel.getAddDealerResponseMutableLiveData().observe(this, addDealerResponse -> {
            Utility.cancelProgressbar();
            if (addDealerResponse != null) {

                if (addDealerResponse.getStatus().equals("111")) {
                    Toast.makeText(this, addDealerResponse.getResult(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, AddDealerDocumentActivity.class);
                    intent.putExtra("owner_name", addDealerResponse.getOwner_name());
                    intent.putExtra("MOB", addDealerResponse.getMOB());
                    intent.putExtra("doc_sequence", addDealerResponse.getDoc_sequence());
                    intent.putExtra("id_no",addDealerResponse.getID_NO());
                    startActivity(intent);



                } else {
                    Toast.makeText(this, addDealerResponse.getResult(), Toast.LENGTH_LONG).show();
                }
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


                if (error.getContent() != null) {

                    Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    // Function to validate the PAN Card number.
    public static boolean isValidPanCardNo(String panCardNo) {
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        // If the PAN Card number is empty return false
        if (panCardNo == null) {
            return false;
        }
        Matcher m = p.matcher(panCardNo);
        return m.matches();
    }

    private boolean isValid() {
        if (binding.etShopname.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Shop Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.etOwner.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Owner Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etGst.getText().toString().equals("") || binding.etGst.getText().length()!=15) {
            Toast.makeText(this, "GST Number not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etPan.getText().toString().equals("") || !isValidPanCardNo(binding.etPan.getText().toString())) {
            Toast.makeText(this, "PAN Card not Valid", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (selected_id_type.equals("")) {
            Toast.makeText(this, "Select ID Type", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (selected_id_type.equals("AADHAR") && !isValidAadhar(binding.etIdnumber.getText().toString())) {
            Toast.makeText(this, "Aadhar Number not valid", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (selected_id_type.equals("VOTER ID") && !isValidVoterID(binding.etIdnumber.getText().toString())) {
            Toast.makeText(this, "Voter ID not valid", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (binding.etIdnumber.getText().toString().equals("")) {
            Toast.makeText(this, "Enter ID card number", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (binding.etLocation.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Location Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (selectedPostOffice.equals("")) {
            Toast.makeText(this, "Post Office cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etPin.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Pin Code", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etEmail.getText().toString().equals("") || !binding.etEmail.getText().toString().trim().matches(emailPattern)) {

            Toast.makeText(this, "Email ID not valid", Toast.LENGTH_SHORT).show();
            return false;


        }
        if ((binding.etMobnumber.getText().toString().length() != 10) || ((!binding.etMobnumber.getText().toString().startsWith("9")) && (!binding.etMobnumber.getText().toString().startsWith("8")) && (!binding.etMobnumber.getText().toString().startsWith("7")) && (!binding.etMobnumber.getText().toString().startsWith("6")))) {
            Toast.makeText(this, "Mobile Number not Valid", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.etPinState.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "State cannot be blank",
                    Toast.LENGTH_LONG).show();
            return false;
        }

        if (binding.etDistrict.getText().equals("")) {
            Toast.makeText(getApplicationContext(), "District cannot be blank",
                    Toast.LENGTH_LONG).show();
            return false;
        }


        return true;
    }


}