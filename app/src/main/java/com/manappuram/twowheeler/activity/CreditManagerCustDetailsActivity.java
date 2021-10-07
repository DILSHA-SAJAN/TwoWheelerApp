package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityCreditManagerCustDetailsBinding;
import com.manappuram.twowheeler.request.DocViewRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.request.RejectCustomerRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

public class CreditManagerCustDetailsActivity extends AppCompatActivity {
    ActivityCreditManagerCustDetailsBinding binding;
    LoginViewModel viewModel;
    final Context context = this;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    public String postId = "";

    public String reject_remarks = "";

    String cust_id = "";
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        postId = sharedPreferences.getString("postId", "");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_credit_manager_cust_details);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        cust_id = getIntent().getStringExtra("cust_id");

        binding.btnPanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Pan_card");
            }
        });
        binding.btnViewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Questionnaire");
            }
        });
        binding.btnViewBankStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Bank_statement");
            }
        });
        binding.btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approveCustomerRetrofit();
            }
        });
        binding.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRemarks();
              //  rejectCustomerRetrofit();
//
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getLeadDetails(cust_id);

        observeViewDocument();
    }


    private void viewDocument(String doc_type) {
        DocViewRequest request = new DocViewRequest();
        request.setFlag("VIEW_CUSTDOCS");
        request.setEmpcode(cust_id);
        request.setDoc_name(doc_type);
        request.setSessionId(sessionId);

        viewModel.viewCustomerDoc(request);


    }

    private void openRemarks() {

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.remarks, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        ImageView btnClose = promptsView.findViewById(R.id.btnCloseRemarks);
        TextView btnSubmit = promptsView.findViewById(R.id.submit_remarks);
        EditText etRejectRemarks = promptsView.findViewById(R.id.et_reject_remarks);


        alertDialogBuilder.setView(promptsView);


        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reject_remarks = etRejectRemarks.getText().toString();
                rejectCustomerRetrofit();

            }
        });

    }

    private void approveCustomerRetrofit() {
        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("CUST_APPROVAL");
        request.setEmpcode(cust_id); // pass customer id
        request.setSessionId(sessionId);
        viewModel.approveCDLCustomer(request);
        Utility.setProgressbar(this);
        viewModel.getApproveCustomerMutableLiveData().observe(this, approveCustResponse -> {
            Utility.cancelProgressbar();
            if (approveCustResponse != null) {
                if (approveCustResponse.getStatus().equals("111")) {
                    Toast.makeText(context, "" + approveCustResponse.getResult(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "" + approveCustResponse.getResult(), Toast.LENGTH_SHORT).show();
                }
                clearFields();
                Intent intent = new Intent(this, CustomerApprovalActivity.class);
                startActivity(intent);
                finish();
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void rejectCustomerRetrofit() {
        RejectCustomerRequest request = new RejectCustomerRequest();
        request.setFlag("CUST_REJECTION");
        request.setEmpcode(cust_id); // pass customer id
        request.setSessionId(sessionId);
        request.setRemarks(reject_remarks);
        viewModel.rejectCDLCustomer(request);

        viewModel.getRejectCustomerMutableLiveData().observe(this, rejectCustResponse -> {

            if (rejectCustResponse != null) {
                if (rejectCustResponse.getStatus().equals("111")) {

                    alertDialog.dismiss();
                    Toast.makeText(context, "" + rejectCustResponse.getResult(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, CustomerApprovalActivity.class);
                    startActivity(intent);
                    finish();

                    clearFields();



                } else {
                    Toast.makeText(context, "" + rejectCustResponse.getResult(), Toast.LENGTH_SHORT).show();
                    clearFields();
                    Intent intent = new Intent(this, CustomerApprovalActivity.class);
                    startActivity(intent);
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
                        binding.etDOB.setText(customerListResponse1.getCustList().get(i).getDob());
                        binding.etProfession.setText(customerListResponse1.getCustList().get(i).getProfession());
                        binding.etAddress.setText(customerListResponse1.getCustList().get(i).getAddress());
                        binding.etPin.setText(customerListResponse1.getCustList().get(i).getPin_code());
                        binding.etMobNumber.setText(customerListResponse1.getCustList().get(i).getMobile());
                        binding.etProductName.setText(customerListResponse1.getCustList().get(i).getProduct_name());
                        binding.etQuotAmount.setText(customerListResponse1.getCustList().get(i).getQuotation());
                        binding.etLoanAmount.setText(customerListResponse1.getCustList().get(i).getLoan_amt());
                        binding.etPan.setText(customerListResponse1.getCustList().get(i).getPan_no());
                        binding.etCibil.setText(customerListResponse1.getCustList().get(i).getCibil_score());
                        binding.etInternalScore.setText(customerListResponse1.getCustList().get(i).getTot_int_score());
                        binding.etTenure.setText(customerListResponse1.getCustList().get(i).getTenure());
                        binding.etEligibility.setText(customerListResponse1.getCustList().get(i).getEligible_sts());
                        binding.etRating.setText(customerListResponse1.getCustList().get(i).getRating());
                        binding.etDownPayment.setText(customerListResponse1.getCustList().get(i).getDown_payment());


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

    private void clearFields() {
        binding.etCustName.setText("");
        binding.etDOB.setText("");
        binding.etProfession.setText("");
        binding.etAddress.setText("");
        binding.etPin.setText("");
        binding.etMobNumber.setText("");
        binding.etProductName.setText("");
        binding.etTenure.setText("");
        binding.etQuotAmount.setText("");
        binding.etCibil.setText("");
        binding.etInternalScore.setText("");

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


    public void onBackPressed() {
      finish();
    }
}