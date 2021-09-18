package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.SelectedProductListAdapter;
import com.manappuram.twowheeler.databinding.ActivityAddCustomerBinding;
import com.manappuram.twowheeler.request.AddCustomerRequest;
import com.manappuram.twowheeler.request.CIBILRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.request.StateFromPinRequest;
import com.manappuram.twowheeler.response.OtherVerticalsResponse;
import com.manappuram.twowheeler.response.PostOfficeResponse;
import com.manappuram.twowheeler.response.ProductListResponse;
import com.manappuram.twowheeler.response.TenureResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomerActivity extends AppCompatActivity {

    ActivityAddCustomerBinding binding;
    final Calendar myCalendar = Calendar.getInstance();
    Calendar minDate = Calendar.getInstance();
    String age = "";
    LoginViewModel viewModel;
    ArrayList<String> verticalList = new ArrayList<String>();
    ArrayList<String> new_list = new ArrayList<String>();
    ArrayList<String> tenureList = new ArrayList<String>();
    OtherVerticalsResponse otherVerticalsResponse;
    TenureResponse tenureResponse;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    public String brId = "";
    public String selectedProduct = "";
    public String prodid = "";
    public String selectedTenure = "";
    ArrayList<String> po_name = new ArrayList<String>();

    Integer ageInt;
    private String tab_position = "no cost emi"; // To identify emi tabs

    public String[] productConcat;
    SelectedProductListAdapter productListAdapter;

    ArrayList<ProductListResponse> selectedprlist = new ArrayList<ProductListResponse>();

    PostOfficeResponse poResponse = new PostOfficeResponse();


    StringBuilder productStringBuilder;
    public String selectedState = "";
    public String selectedDist = "";

    public String selectedStateID = "";
    public String selectedDistID = "";

    public String cibilStateCode = "";

    public String selectedPostOffice = "";
    ArrayAdapter<String> postOfficeAdapter;
    String[] job_type = {"Select Job Type", "Salaried", "Self Employed", "Business"};
    String selected_job_type = "";

    public String firstName = "";
    public String lastName = "";
    public String cibilDate = "";

    public String cibilSelectedGender = "2"; // default male

    public String cibilAddress1 = "";
    public String cibilAddress2 = "";
    public String cibilAddress3 = "";

    String score = ""; //cibil score

    public String gender = "Male";
    String pancardNo = "";
  //  String othersString = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_customer);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        brId = sharedPreferences.getString("brId", "");

        binding.tvDate.setOnClickListener(v -> {
            showDateDialog(binding.tvDate);
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGender();
                getNames();
                // getAddress();

                if (isCIBILValid() && isValid()) {

                    getCIBILRetrofit();


                }
            }

        });
        binding.tvAge.setEnabled(false);


        productListAdapter = new SelectedProductListAdapter(AddCustomerActivity.this, selectedprlist);
        listener();
        binding.selectedprecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));
        binding.selectedprecycler.setAdapter(productListAdapter);
        binding.btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMore();
            }
        });

        getJobTypeSpinner();
        getProductsList();
        getTenure();
        emiTabSelect();
        pincodeChange();
        disableAutofill();
        getGender();


//        binding.tvCheckcibil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //splitName();
//                getGender();
//                getNames();
//                getAddress();
//                if (isCIBILValid()) {
//                    getCIBILRetrofit();
//                }
//            }
//        });

    }

    private void getAddress() {
        Log.v("thudangi", "thudangi");
        String[] address = binding.etAddress.getText().toString().split("\\r?\\n");


        cibilAddress1 = address[0];
        cibilAddress2 = address[1];
        cibilAddress3 = address[2];
        Log.v("kettu", "kettu");


        Toast.makeText(this, "Address part " + cibilAddress1 + "" + cibilAddress2 + "" + cibilAddress3, Toast.LENGTH_SHORT).show();

    }

    private void getNames() {
        if (binding.etFullName.getText().toString().split("\\w+").length > 1) {

            lastName = binding.etFullName.getText().toString().substring(binding.etFullName.getText().toString().lastIndexOf(" ") + 1);
            firstName = binding.etFullName.getText().toString().substring(0, binding.etFullName.getText().toString().lastIndexOf(' '));
        } else {
            firstName = binding.etFullName.getText().toString();
        }
    }

    private void getGender() {
        binding.radioSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);
                if (rb.getText().toString().equalsIgnoreCase("Male")) {
                    cibilSelectedGender = "2";
                    gender = "Male";
                } else {
                    cibilSelectedGender = "1";
                    gender = "Female";
                }
             //   Toast.makeText(AddCustomerActivity.this, ""+gender, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getCIBILRetrofit() {
        CIBILRequest request = new CIBILRequest();
        request.setApplicantType("N01");
        request.setApplicantFirstName(firstName);
        request.setApplicantLastName(lastName);
        request.setDateOfBirth(cibilDate);
        request.setGender(cibilSelectedGender);
        pancardNo = binding.etPanCard.getText().toString();
        request.setIdNumber(binding.etPanCard.getText().toString());
        request.setIdType("01");
        request.setTelephoneNumber(binding.etMobNumber.getText().toString());
        request.setTelephoneType("01");
        String[] address = binding.etAddress.getText().toString().split("\\r?\\n");
        cibilAddress1 = address[0];
        cibilAddress2 = address[1];
        request.setAddressLine1(binding.etHouseName.getText().toString());
        request.setAddressLine2(cibilAddress1);
        request.setAddressLine3(cibilAddress2);
        request.setCity(binding.etLocation.getText().toString());
        request.setPinCode(binding.etPincode.getText().toString());
        request.setResidenceType("01");
        request.setStateCode(cibilStateCode);
        request.setPurpose("06"); //consumer loan
        request.setAmount(binding.etQuotAmount.getText().toString());
        request.setScoreType("01");
        request.setGstStateCode(cibilStateCode);
        request.setCibilBureauFlag("False");
        request.setIdVerificationFlag("True");
        viewModel.getCIBILScore(request);

        Utility.setProgressbar(this);


        viewModel.getCibilResponseMutableLiveData().observe(this, cibilScoreOutput -> {

            if (cibilScoreOutput != null) {

                if (cibilScoreOutput.getStatus().equals("SUCCESS")) {
                    if (cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getIsSucess().equals("True")) {

                        score = cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getBureauResponseXml().getCreditReport().getScoreSegment().getScore();
                        Utility.cancelProgressbar();

                        if (score == null) {
                            score = "000-1";
                        }

                        Toast.makeText(this, "CIBIL score is " + score, Toast.LENGTH_SHORT).show();
                        addCustomer();


                    } else {
                        Utility.cancelProgressbar();
                        Toast.makeText(this, "CIBIL score Calculation Error! Please retry!", Toast.LENGTH_SHORT).show();
                        // Toast.makeText(this, "" + cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getIsSucess(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, cibilScoreOutput.getApiStatus() + " : " + cibilScoreOutput.getResponseMsg(), Toast.LENGTH_SHORT).show();
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

    private void disableAutofill() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.etFullName.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO);
            binding.etHouseName.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO);


        }
    }

    private void clearFields() {

        selectedState = "";
        selectedDist = "";
        selectedPostOffice = "";
        selectedDistID = "";
        selectedStateID = "";
        cibilStateCode = "";

        binding.rlState.setVisibility(View.GONE);
        binding.rlDistrict.setVisibility(View.GONE);
        binding.rlPostOffice.setVisibility(View.GONE);
        binding.etState.setText("");
        binding.etDistrict.setText("");
    }

    private void getJobTypeSpinner() {

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, job_type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.jobTypeSpinner.setAdapter(aa);
        binding.jobTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selected_job_type = "";
                        break;
                    case 1: //Salaried
                        selected_job_type = "Salaried";
                        break;
                    case 2: //Self Employed
                        selected_job_type = "Self Employed";
                        break;
                    case 3: //Business
                        selected_job_type = "Business";
                        break;
                }

                // Toast.makeText(getApplicationContext(), "Selected ID: " +id_type[position], Toast.LENGTH_LONG).show();
//                  Toast.makeText(getApplicationContext(), "Selected ID: " + selected_job_type, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }

    private void pincodeChange() {
        binding.etPincode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                clearFields();


                if (binding.etPincode.getText().toString().length() == 6) {
                    getStateFromPin();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getStateFromPin() {


        StateFromPinRequest request = new StateFromPinRequest();
        request.setFlag("GET_PIN_STATE_DIST");
        request.setPin(binding.etPincode.getText().toString());
        request.setSessionId(sessionId);
        viewModel.getStateFromPin(request);
        Utility.setProgressbar(this);
        viewModel.getStateResponseMutableLiveData().observe(this, stateResponse1 -> {
            Utility.cancelProgressbar();

            if (stateResponse1 != null) {
                if (stateResponse1.getStatus().equals("111")) {
                    if (stateResponse1.getStateList().size() > 0) {
                        for (int i = 0; i < stateResponse1.getStateList().size(); i++) {
                            selectedState = stateResponse1.getStateList().get(i).getStateName();
                            selectedDist = stateResponse1.getStateList().get(i).getDistrict_name();

                            selectedStateID = stateResponse1.getStateList().get(i).getStateId();
                            selectedDistID = stateResponse1.getStateList().get(i).getDistrict_id();
                            cibilStateCode = stateResponse1.getStateList().get(i).getCibil_state();
                            //   Toast.makeText(this, "Cibil state code is " + cibilStateCode, Toast.LENGTH_SHORT).show();
                            binding.etState.setText(stateResponse1.getStateList().get(i).getStateName());
                            binding.etDistrict.setText(stateResponse1.getStateList().get(i).getDistrict_name());
                            binding.rlState.setVisibility(View.VISIBLE);
                            binding.rlDistrict.setVisibility(View.VISIBLE);

                        }

                        getPOValues();

                    }

                }
            } else if (stateResponse1.getStatus().equals("222") && !binding.etState.getText().toString().equals("")) {
                Toast.makeText(this, "Enter Valid Pin", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                clearFields();
            }


        });

    }

    private void getPOValues() {


        postOfficeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, po_name);
        postOfficeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StateFromPinRequest request = new StateFromPinRequest();
        request.setFlag("GET_PIN_POST");
        request.setPin(binding.etPincode.getText().toString());
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

    public void emiTabSelect() {
        binding.tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) { // NO cost EMI
                    tab_position = "no cost emi";


                } else { // Normal EMI
                    tab_position = "normal emi";

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

    private void addCustomer() {
        AddCustomerRequest request = new AddCustomerRequest();
        request.setFlag("ADD_CUSTOMER");
        request.setCust_name(binding.etFullName.getText().toString());
        request.setGender(gender);
        request.setDob(binding.tvDate.getText().toString());
        request.setAddress(binding.etAddress.getText().toString());
        request.setPincode(binding.etPincode.getText().toString());
        request.setState(selectedState);
        request.setDistrict(selectedDist);
        request.setProfession(binding.etProfession.getText().toString());
        request.setQuotation(binding.etQuotAmount.getText().toString());
        request.setLoan_amount(binding.etLoanAmount.getText().toString());

        productStringBuilder = new StringBuilder();
        if (selectedprlist.size() == 0) {

                request.setProduct_name(selectedProduct);

        } else if (selectedprlist.size() > 0) {
            for (int i = 0; i < selectedprlist.size(); i++) {

                if (i < selectedprlist.size() - 1) {
                    productStringBuilder.append(selectedprlist.get(i).productName + ",");
                } else {
                    productStringBuilder.append(selectedprlist.get(i).productName);
                }
//                productStringBuilder.append(selectedprlist.get(i).productName);
//               productStringBuilder.append(",");
            }

            request.setProduct_name(productStringBuilder.toString().trim());
            Log.e("TAG", "buttononclick: " + productStringBuilder.toString().trim());
        } else {
            Log.e("TAG", "buttononclick: " + "No selection");
        }

        request.setQuotation(binding.etQuotAmount.getText().toString());
        request.setTenure(selectedTenure);
        request.setMob(binding.etMobNumber.getText().toString());
        request.setUploaded_by(empCode);


        request.setLoc(binding.etLocation.getText().toString());
        request.setH_name(binding.etHouseName.getText().toString());
        request.setJob_typ(selected_job_type);
        request.setDist_id(selectedDistID);
        request.setStat_id(selectedStateID);
        request.setPost(selectedPostOffice);
        request.setBranchid(brId);
        if(score.equals("")|| score == null){
            score = "000-1";
        }

        request.setCibil_score(score);
        request.setSessionId(sessionId);
        request.setEmi_status(tab_position);
        viewModel.addCustomer(request);

        viewModel.getAddCustomerResponseMutableLiveData().observe(this, addCustomerResponse -> {

            if (addCustomerResponse != null) {
                if (addCustomerResponse.getStatus().equals("111")) {
                    Toast.makeText(this, addCustomerResponse.getResult(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AddCustDocumentActivity.class);
//                    intent.putExtra("name", binding.etFullName.getText().toString());
//                    intent.putExtra("dob", binding.tvDate.getText().toString());
//                    intent.putExtra("age", binding.tvAge.getText().toString());
//                    intent.putExtra("profession", binding.etProfession.getText().toString());
//                    intent.putExtra("address", binding.etAddress.getText().toString());
//                    intent.putExtra("pincode", binding.etPincode.getText().toString());
//                    intent.putExtra("quot_amount", binding.etQuotAmount.getText().toString());
                    intent.putExtra("pancardNo", binding.etPanCard.getText().toString());
                    intent.putExtra("cust_name", addCustomerResponse.getCust_name());
                    intent.putExtra("cust_mob", addCustomerResponse.getMobile());
                    intent.putExtra("doc_seq", addCustomerResponse.getDoc_sequence());
                    intent.putExtra("cibil_score", score);

                    startActivity(intent);
                    // finish();
                } else {
                    Toast.makeText(this, addCustomerResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
            }

            viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


                if (error.getContent() != null) {
                    //    Utility.cancelProgressbar();
                    Toast.makeText(AddCustomerActivity.this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
                }
            });

        });
    }

    private void listener() {
        productListAdapter.prodClickListener = new OnSelectedProdClickListener() {
            @Override
            public void ondeleteClick(int position) {
                selectedprlist.remove(position);
                productListAdapter.notifyDataSetChanged();
            }
        };
    }

    private void showDateDialog(TextView date) {
        final Calendar calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(Utility.getDate(dayOfMonth, month, year));

                age = getAge(year, month, dayOfMonth);
                cibilDate = Utility.getCIBILDate(dayOfMonth, month, year);

                if (!age.equals("")) {
                    binding.rlAge.setVisibility(View.VISIBLE);
                    binding.tvAge.setText(age);
                } else {
                    binding.rlAge.setVisibility(View.GONE);
                    binding.tvDate.setText("");
                }
            }
        };

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpDialog = new DatePickerDialog(AddCustomerActivity.this, dateSetListener, mYear, mMonth, mDay);
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
        if (binding.etFullName.getText().toString().equals("")) {
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
        if (binding.etPincode.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Pin Code", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.etState.getText().toString().equals("")) {
            Toast.makeText(this, "State cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etDistrict.getText().equals("")) {
            Toast.makeText(getApplicationContext(), "District cannot be blank",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        if (ageInt < 23 || ageInt > 65) {

            Toast.makeText(this, "Age Should be between 23 and 65", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.etPincode.getText().toString().length() < 6) {
            Toast.makeText(this, "Pin Code not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etQuotAmount.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Quotation amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etMobNumber.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((binding.etMobNumber.getText().toString().length() != 10) || ((!binding.etMobNumber.getText().toString().startsWith("9")) && (!binding.etMobNumber.getText().toString().startsWith("8")) && (!binding.etMobNumber.getText().toString().startsWith("7")) && (!binding.etMobNumber.getText().toString().startsWith("6")))) {
            Toast.makeText(this, "Mobile Number not Valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((binding.etLoanAmount.getText().toString().equals(""))) {
            Toast.makeText(this, "Enter Loan Amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.parseInt(binding.etQuotAmount.getText().toString()) < Integer.parseInt(binding.etLoanAmount.getText().toString())) {
            Toast.makeText(this, "Loan amount should be less than quotation amount", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    private boolean isCIBILValid() {
        if (firstName.equals("") || lastName.equals("")) {
            Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cibilDate.equals("")) {
            Toast.makeText(this, "Select DOB", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isValidPanCardNo(binding.etPanCard.getText().toString())) {
            Toast.makeText(this, "Enter Valid Pan Number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.etAddress.getText().toString().split("\\r?\\n").length < 2) {
            Toast.makeText(this, "Enter Complete address in 2 lines!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etPincode.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Pin Code", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cibilStateCode.equals("")) {
            Toast.makeText(this, "State cannot be blank", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (binding.etPincode.getText().toString().length() < 6) {
            Toast.makeText(this, "Pin Code not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etQuotAmount.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Quotation amount", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (binding.etMobNumber.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((binding.etMobNumber.getText().toString().length() != 10) || ((!binding.etMobNumber.getText().toString().startsWith("9")) && (!binding.etMobNumber.getText().toString().startsWith("8")) && (!binding.etMobNumber.getText().toString().startsWith("7")) && (!binding.etMobNumber.getText().toString().startsWith("6")))) {
            Toast.makeText(this, "Mobile Number not Valid", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    private void getProductsList() {
        ArrayAdapter<String> productAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, verticalList);
        productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GET_PRODUCTS");
        request.setSessionId(sessionId);
        viewModel.getVerticalsList(request);
        Utility.setProgressbar(AddCustomerActivity.this);

        viewModel.getOtherVerticalsResponseMutableLiveData().observe(this, otherVerticalsResponse1 -> {

            otherVerticalsResponse = otherVerticalsResponse1;
            if (otherVerticalsResponse.getProductList() != null) {
                Utility.cancelProgressbar();
                if (otherVerticalsResponse.getProductList().size() > 0) {
                    verticalList.clear();
                    verticalList.add("Select Product Type");
                    for (int i = 0; i < otherVerticalsResponse.getProductList().size(); i++) {
                        verticalList.add(otherVerticalsResponse.getProductList().get(i).getProductName());
                    }
                    binding.productSpinner.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();
                    selectedProduct = binding.productSpinner.getSelectedItem().toString();


                }
            }
        });
        binding.productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position > 0) {



                        binding.rlOthersType.setVisibility(View.GONE);
                        binding.btnAddMore.setVisibility(View.VISIBLE);
                        binding.llSelectedLprList.setVisibility(View.VISIBLE);

                        prodid = otherVerticalsResponse.getProductList().get(position - 1).getProductId();
                        for (int i = 0; i < selectedprlist.size(); i++) {
                            if (prodid.equals(selectedprlist.get(i).getProductId())) {
                                Toast.makeText(AddCustomerActivity.this, "Already selected", Toast.LENGTH_SHORT).show();

                                prodid = "";
                            }
                        }


                        selectedProduct = otherVerticalsResponse.getProductList().get(position - 1).getProductName();

                    }
                }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(AddCustomerActivity.this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void getTenure() {
        ArrayAdapter<String> tenureAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tenureList);
        tenureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GET_TENURE");
        request.setSessionId(sessionId);
        viewModel.getTenureList(request);
        //     Utility.setProgressbar(AddCustomerActivity.this);

        viewModel.getTenureResponseMutableLiveData().observe(this, tenureResponse1 -> {

            tenureResponse = tenureResponse1;
            if (tenureResponse.getTenureList() != null) {
                //         Utility.cancelProgressbar();
                if (tenureResponse.getTenureList().size() > 0) {
                    tenureList.clear();
                    tenureList.add("Select Tenure in Months");
                    for (int i = 0; i < tenureResponse.getTenureList().size(); i++) {
                        tenureList.add(tenureResponse.getTenureList().get(i).getTenure());
                    }
                    binding.spTenure.setAdapter(tenureAdapter);
                    tenureAdapter.notifyDataSetChanged();
                    selectedProduct = binding.productSpinner.getSelectedItem().toString();


                }
            }
        });
        binding.spTenure.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position > 0) {

                    selectedTenure = tenureResponse.getTenureList().get(position - 1).getTenure();

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                //    Utility.cancelProgressbar();
                Toast.makeText(AddCustomerActivity.this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addMore() {

        for (int i = 0; i < selectedprlist.size(); i++) {
            if (prodid.equals(selectedprlist.get(i).getProductId())) {
                Log.v("finishint","finishint");
                Toast.makeText(AddCustomerActivity.this, "Sorry! Product Already Selected!", Toast.LENGTH_SHORT).show();
                prodid = "";
            }
        }
         if (!prodid.equals("")) {
            selectedprlist.add(new ProductListResponse(prodid, selectedProduct));
            productListAdapter.notifyDataSetChanged();
        }

    }

    public interface OnSelectedProdClickListener {
        void ondeleteClick(int position);
    }

}
