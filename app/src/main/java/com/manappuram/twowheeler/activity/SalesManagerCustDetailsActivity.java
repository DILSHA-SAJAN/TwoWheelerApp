package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.SelectedProductListAdapter;
import com.manappuram.twowheeler.databinding.ActivitySalesManagerCustDetailsBinding;
import com.manappuram.twowheeler.request.DocViewRequest;
import com.manappuram.twowheeler.request.EditCustomerRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.response.ProductListResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesManagerCustDetailsActivity extends AppCompatActivity {

    ActivitySalesManagerCustDetailsBinding binding;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    SelectedProductListAdapter productListAdapter;

    ArrayList<String> verticalList = new ArrayList<String>();

    public String sessionId = "";
    public String empCode = "";
    public String postId = "";
    String cust_id = "";
    LoginViewModel viewModel;
    String uploaded_by = "";
    String panCard ="";
    public String prodid = "";
    String age = "";
    public String selectedProduct = "";
    Integer ageInt;

    ArrayList<ProductListResponse> selectedprlist = new ArrayList<ProductListResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        postId = sharedPreferences.getString("postId", "");


        binding = DataBindingUtil.setContentView(this, R.layout.activity_sales_manager_cust_details);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        cust_id = getIntent().getStringExtra("cust_id");


        //  binding.etIdNum.setText(cust_id);



        getLeadDetails(cust_id);
       // checkEmpPermission();

        binding.tvDate.setOnClickListener(v -> {
            showDateDialog(binding.tvDate);
        });

        binding.tvPanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Pan_card");
            }
        });
        binding.tvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Questionnaire");
            }
        });
        binding.tvBankStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Bank_statement");
            }
        });
        binding.tvEditCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(isValid())  {

                  editCustomerRetrofit();
              }

            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        observeViewDocument();

    }

    private void observeViewDocument() {
        viewModel.getDocViewResponseMutableLiveData().observe(this, docViewResponse -> {
            Utility.cancelProgressbar();
            if (docViewResponse != null) {
                if (docViewResponse.getStatus().equals("111")) {
                    if (!docViewResponse.getFilename().equals("")) {
                        Toast.makeText(this, "" + docViewResponse.getResult() + ":" + docViewResponse.getFilename(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, DocWebViewActivity.class);
                        intent.putExtra("doc_name", docViewResponse.getFilename());
                        startActivity(intent);
                        //   finish();
                    } else {
                        Toast.makeText(this, "Document not available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "" + docViewResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getLeadDetails(String cust_id) {
        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GET_CUSTOMER");
        request.setEmpcode(cust_id);
        request.setSessionId(sessionId);

        viewModel.getIndividualCust(request);
        Utility.setProgressbar(this);
        viewModel.getIndividualCustResponseMutableLiveData().observe(this, customerListResponse1 -> {
            Utility.cancelProgressbar();
            if (customerListResponse1 != null) {
                if (customerListResponse1.getCustList().size() > 0) {
                    for (int i = 0; i < customerListResponse1.getCustList().size(); i++) {
                        binding.etCustName.setText(customerListResponse1.getCustList().get(i).getCust_name());
                        binding.tvDate.setText(customerListResponse1.getCustList().get(i).getDob());
                        binding.etProfession.setText(customerListResponse1.getCustList().get(i).getProfession());
                        binding.etAddress.setText(customerListResponse1.getCustList().get(i).getAddress());
                        binding.etPinCode.setText(customerListResponse1.getCustList().get(i).getPin_code());
                        binding.etMobilenumber.setText(customerListResponse1.getCustList().get(i).getMobile());
                        binding.etQuotAmount.setText(customerListResponse1.getCustList().get(i).getQuotation());
                        binding.etLoanAmount.setText(customerListResponse1.getCustList().get(i).getLoan_amt());
                        binding.etProductName.setText(customerListResponse1.getCustList().get(i).getProduct_name());
                        binding.etTenure.setText(customerListResponse1.getCustList().get(i).getTenure());
                        binding.etPanCard.setText(customerListResponse1.getCustList().get(i).getPan_no());
                        binding.etInternalScore.setText(customerListResponse1.getCustList().get(i).getTot_int_score());
                        binding.etCibilScore.setText(customerListResponse1.getCustList().get(i).getCibil_score());
                        uploaded_by = customerListResponse1.getCustList().get(i).getUploaded_by();
                        panCard = customerListResponse1.getCustList().get(i).getPan_no();
                    }

                }
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showDateDialog(TextView date) {
        final Calendar calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(Utility.getDate(dayOfMonth, month, year));

                age = getAge(year, month, dayOfMonth);


            }
        };

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpDialog = new DatePickerDialog(this, dateSetListener, mYear, mMonth, mDay);
        dpDialog.getDatePicker().setMaxDate(new Date().getTime());
        dpDialog.show();
    }
    private String getAge(int year, int month, int day) {

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        ageInt = new Integer(age);

        return String.valueOf(ageInt);
    }

    private boolean isValid() {
        if (binding.etCustName.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.tvDate.getText().toString().equals("")) {
            Toast.makeText(this, "Select DOB", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etProfession.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Profession", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etAddress.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etPinCode.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Pin Code", Toast.LENGTH_SHORT).show();
            return false;
        }


//        if (ageInt < 23 || ageInt > 65) {
//
//            Toast.makeText(this, "Age Should be between 23 and 65", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        if (binding.etPinCode.getText().toString().length() < 6) {
            Toast.makeText(this, "Pin Code not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etQuotAmount.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Quotation amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etMobilenumber.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((binding.etMobilenumber.getText().toString().length() != 10) || ((!binding.etMobilenumber.getText().toString().startsWith("9")) && (!binding.etMobilenumber.getText().toString().startsWith("8")) && (!binding.etMobilenumber.getText().toString().startsWith("7")) && (!binding.etMobilenumber.getText().toString().startsWith("6")))) {
            Toast.makeText(this, "Mobile Number not Valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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


    private void editCustomerRetrofit() {
        EditCustomerRequest request = new EditCustomerRequest();
        request.setFlag("EDIT_CUSTOMER");
        request.setCust_name(binding.etCustName.getText().toString());
        request.setCust_id(cust_id);
        request.setDob(binding.tvDate.getText().toString());
        request.setAddress(binding.etAddress.getText().toString());
        request.setPincode(binding.etPinCode.getText().toString());
        request.setProfession(binding.etProfession.getText().toString());
        request.setMob(binding.etMobilenumber.getText().toString());
        request.setSessionId(sessionId);
        viewModel.editCustomerDetails(request);

        viewModel.getAddCustomerResponseMutableLiveData().observe(this, editCustResponse -> {
            Toast.makeText(this, "Call Edit Customer", Toast.LENGTH_SHORT).show();

            if (editCustResponse != null) {
                if (editCustResponse.getStatus().equals("111")) {
                    Toast.makeText(this, "" + editCustResponse.getResult(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CustomerApprovalActivity.class);
                    startActivity(intent);
                    //finish();

                } else {
                    Toast.makeText(this, "" + editCustResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {

                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void viewDocument(String doc_type) {
        DocViewRequest request = new DocViewRequest();
        request.setFlag("VIEW_CUSTDOCS");
        request.setEmpcode(cust_id);
        request.setDoc_name(doc_type);
        request.setSessionId(sessionId);

        viewModel.viewCustomerDoc(request);
        Utility.setProgressbar(this);


    }
}