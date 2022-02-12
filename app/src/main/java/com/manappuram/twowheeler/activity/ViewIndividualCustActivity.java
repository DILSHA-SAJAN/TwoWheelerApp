package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityViewCustomerBinding;
import com.manappuram.twowheeler.databinding.ActivityViewIndividualCustBinding;
import com.manappuram.twowheeler.request.DocViewRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

public class ViewIndividualCustActivity extends AppCompatActivity {

    ActivityViewIndividualCustBinding binding;
    String cust_id = "";
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    public String postId = "";
    LoginViewModel viewModel;
    String uploaded_by = "";
    String panCard = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        postId = sharedPreferences.getString("postId", "");
        name = sharedPreferences.getString("name", "");


        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_individual_cust);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        cust_id = getIntent().getStringExtra("cust_id");


        //  binding.etIdNum.setText(cust_id);


        getLeadDetails(cust_id);

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
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        observeViewDocument();
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
                        binding.etDealerNumber.setText(empCode);
                        binding.etDealerName.setText(name);
                        binding.etGender.setText(customerListResponse1.getCustList().get(i).getGender());
                        binding.etIdName.setText("PAN CARD");
                        binding.etIdNum.setText(customerListResponse1.getCustList().get(i).getPan_no());
                        binding.etState.setText(customerListResponse1.getCustList().get(i).getState());
                        binding.etDistrict.setText(customerListResponse1.getCustList().get(i).getDistrict());
                        binding.etPostName.setText(customerListResponse1.getCustList().get(i).getPost_office());
                        binding.etPinCode.setText(customerListResponse1.getCustList().get(i).getPin_code());
                        binding.etLocation.setText(customerListResponse1.getCustList().get(i).getLocation());
                        binding.etMobNumber.setText(customerListResponse1.getCustList().get(i).getMobile());
                        binding.tvProductList.setText(customerListResponse1.getCustList().get(i).getProduct_name());
                        binding.etReqAmount.setText(customerListResponse1.getCustList().get(i).getQuotation());
                        binding.etLoanAmount.setText(customerListResponse1.getCustList().get(i).getLoan_amt());
                        binding.etIdNum.setText(customerListResponse1.getCustList().get(i).getPan_no());
                        binding.etLeadStatus.setText(customerListResponse1.getCustList().get(i).getRemarks());
                        binding.etEligible.setText(customerListResponse1.getCustList().get(i).getEligible_sts());
                        binding.etRating.setText(customerListResponse1.getCustList().get(i).getRating());
                        uploaded_by = customerListResponse1.getCustList().get(i).getUploaded_by();
                        binding.etCibilScore.setText(customerListResponse1.getCustList().get(i).getCibil_score());
                        binding.etInternalScore.setText(customerListResponse1.getCustList().get(i).getTot_int_score());
                        binding.etDownPayment.setText(customerListResponse1.getCustList().get(i).getDown_payment());
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

    private void viewDocument(String doc_type) {
        DocViewRequest request = new DocViewRequest();
        request.setFlag("VIEW_CUSTDOCS");
        request.setEmpcode(cust_id);
        request.setDoc_name(doc_type);
        request.setSessionId(sessionId);

        viewModel.viewCustomerDoc(request);
        Utility.setProgressbar(this);

    }
    private void observeViewDocument() {
        viewModel.getDocViewResponseMutableLiveData().observe(this, docViewResponse -> {
            Utility.cancelProgressbar();
            if (docViewResponse != null) {
                if (docViewResponse.getStatus().equals("111")) {
                    if (!docViewResponse.getFilename().equals("")) {
                        //    Toast.makeText(this, "" + docViewResponse.getResult() + ":" + docViewResponse.getFilename(), Toast.LENGTH_SHORT).show();
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


}