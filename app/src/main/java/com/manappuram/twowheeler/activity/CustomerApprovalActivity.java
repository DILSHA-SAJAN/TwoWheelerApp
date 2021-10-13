package com.manappuram.twowheeler.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.ViewCustomerItemAdapter;
import com.manappuram.twowheeler.databinding.ActivityCustomerApprovalBinding;
import com.manappuram.twowheeler.request.BaseRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.response.ViewCustomerListResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;

public class CustomerApprovalActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    public String postId = "";
    public String selectedProduct = "";
    ActivityCustomerApprovalBinding binding;
    LoginViewModel viewModel;
    ViewCustomerItemAdapter adapter;
    ArrayList<ViewCustomerListResponse.custList> cust_approve_list = new ArrayList<>();
    TextView navUserName, navEmpCode, navEmpPost;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        postId = sharedPreferences.getString("postId", "");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_customer_approval);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        adapter = new ViewCustomerItemAdapter(this, cust_approve_list);

        binding.recycleCustomer.setLayoutManager(new LinearLayoutManager(this));
        navigationView = binding.navigationView;
        View headerView = navigationView.getHeaderView(0);
        navUserName = headerView.findViewById(R.id.drawer_username);
        navEmpCode = headerView.findViewById(R.id.drawer_empcode);
        navEmpPost = headerView.findViewById(R.id.drawer_emppost);
        drawerLayout = binding.myDrawerLayout;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navUserName.setText("" + sharedPreferences.getString("name", ""));
        navEmpCode.setText(sharedPreferences.getString("empCode", ""));
        if (sharedPreferences.contains("designation"))
            navEmpPost.setText(sharedPreferences.getString("designation", ""));
        binding.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent i;
                switch (id) {
                    case R.id.nav_view_customer:
                        i = new Intent(getApplicationContext(), ViewCustomerActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_add_customer:
                        i = new Intent(getApplicationContext(), AddCustomerActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_add_dealer:
                        i = new Intent(getApplicationContext(), AddDealerActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_view_dealer:
                        i = new Intent(getApplicationContext(), ViewDealerActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_cibil_score:
                        i = new Intent(getApplicationContext(), CibilScoreActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_questionnaire:
                        i = new Intent(getApplicationContext(), InternalScoreCardActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_cust_approval:
                        i = new Intent(getApplicationContext(), CustomerApprovalActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_edit_customer:
                        i = new Intent(getApplicationContext(), CustomerApprovalActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_mis_report:
                        i = new Intent(CustomerApprovalActivity.this, MisReportActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_logout:


                        logOut();

                }
                return false;
            }
        });

        checkEmpPermission();
        getCustomers();
        searchFunction();

    }

    private void searchFunction() {
        // below line is to call set on query text listener method.
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });

    }
    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<ViewCustomerListResponse.custList> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (ViewCustomerListResponse.custList item : cust_approve_list) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getCust_name().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }
    private void logOut() {
        BaseRequest request = new BaseRequest();
        request.setSessionId(sessionId);
        viewModel.sessionOut(request);
        editor.clear();
        editor.apply();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void checkEmpPermission() {
        Menu nav_Menu = navigationView.getMenu();
        switch (postId) {
            case "636": //SO
            case "-129": //SO
                //   case "683": //Jr Asst

                nav_Menu.findItem(R.id.nav_add_dealer).setVisible(true);
                nav_Menu.findItem(R.id.nav_view_dealer).setVisible(true);
                nav_Menu.findItem(R.id.nav_edit_customer).setVisible(true);
                break;
            case "-354": //Credit Head
                nav_Menu.findItem(R.id.nav_cust_approval).setVisible(true);
                break;

            case "dealer":
              //  nav_Menu.findItem(R.id.nav_edit_customer).setVisible(true);
                break;

            default:
//                Toast.makeText(this, "Not Sales Officer " +postId, Toast.LENGTH_SHORT).show();
                break;


        }
    }

    private void getCustomers() {

        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GETCUST_LEAD");
        request.setEmpcode(empCode);
        request.setSessionId(sessionId);

        viewModel.getCustomerApproval(request);
        Utility.setProgressbar(this);

        viewModel.getViewCustomerListResponseMutableLiveData().observe(this, customerListResponse1 -> {
            Utility.cancelProgressbar();
            if (customerListResponse1 != null) {
                if (customerListResponse1.getCustList().size() > 0) {
                    cust_approve_list.addAll(customerListResponse1.getCustList());
                    binding.recycleCustomer.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {
            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });

        adapter.listener = new ViewCustomerActivity.CustIDSelectListener() {
            Intent intent;

            @Override
            public void onitemClick(String cust_id) {
                String a = cust_id;
                switch (postId) {
                    case "636": //SO
                    case "-129": //SO

                        intent = new Intent(getApplicationContext(), SalesManagerCustDetailsActivity.class);
                        intent.putExtra("cust_id", cust_id);
                        startActivity(intent);
                        finish();
                        break;

                    case "-354": //Credit Head
                        intent = new Intent(getApplicationContext(), CreditManagerCustDetailsActivity.class);
                        intent.putExtra("cust_id", cust_id);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

            }
        };


    }
}