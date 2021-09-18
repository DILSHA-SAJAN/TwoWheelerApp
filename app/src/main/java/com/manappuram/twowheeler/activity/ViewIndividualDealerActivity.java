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
import com.manappuram.twowheeler.databinding.ActivityViewIndividualCustBinding;
import com.manappuram.twowheeler.databinding.ActivityViewIndividualDealerBinding;
import com.manappuram.twowheeler.request.DocViewRequest;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

public class ViewIndividualDealerActivity extends AppCompatActivity {

    ActivityViewIndividualDealerBinding binding;
    String dealer_id = "";
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    public String postId = "";
    LoginViewModel viewModel;

    String pan_docname = "";
    String quest_docname = "";
    String aadhar_docname = "";
    String bank_docname = "";
    String agree_docname = "";
    String pledge_docname = "";


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


        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_individual_dealer);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        dealer_id = getIntent().getStringExtra("dealer_id");

        getDealerDetails(dealer_id);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
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
        binding.tvAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Aadhar_card");
            }
        });
        binding.tvAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Agreement");
            }
        });
        binding.tvPledgedoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDocument("Goldpledgeform");
            }
        });
        observeViewDocument();
    }

    private void getDealerDetails(String dealer_id) {

        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GET_DEALER");
        request.setEmpcode(dealer_id);
        request.setSessionId(sessionId);

        viewModel.getIndividualDealer(request);
        Utility.setProgressbar(this);

        viewModel.getIndividualDealerResponsseMutableLiveData().observe(this, dealerListResponse1 -> {

            Utility.cancelProgressbar();
            if (dealerListResponse1 != null) {
                if (dealerListResponse1.getStatus().equals("111")) {

                    if (dealerListResponse1.getDealerList().size() > 0) {
                        for (int i = 0; i < dealerListResponse1.getDealerList().size(); i++) {

                            binding.etDealerName.setText(dealerListResponse1.getDealerList().get(i).getOWNER_NAME());
                            binding.etOwnerName.setText(dealerListResponse1.getDealerList().get(i).getOWNER_NAME());
                            binding.etShopname.setText(dealerListResponse1.getDealerList().get(i).getSHOP_NAME());
                            binding.etDealerID.setText(dealerListResponse1.getDealerList().get(i).getDEALER_ID());
                            binding.etState.setText(dealerListResponse1.getDealerList().get(i).getSTATE());
                            binding.etDistrict.setText(dealerListResponse1.getDealerList().get(i).getDISTRICT());
                            binding.etShopGST.setText(dealerListResponse1.getDealerList().get(i).getSHOP_GST());
                            binding.etPinCode.setText(dealerListResponse1.getDealerList().get(i).getPIN());
                            binding.etMobNumber.setText(dealerListResponse1.getDealerList().get(i).getMOB());
                            binding.etPanNum.setText(dealerListResponse1.getDealerList().get(i).getPAN_NO());
                            binding.etLocation.setText(dealerListResponse1.getDealerList().get(i).getLOC_NAME());
                            pan_docname = dealerListResponse1.getDealerList().get(i).getPan_docname();
                            quest_docname = dealerListResponse1.getDealerList().get(i).getQuest_docname();
                            aadhar_docname = dealerListResponse1.getDealerList().get(i).getAadhar_docname();
                            bank_docname = dealerListResponse1.getDealerList().get(i).getBank_docname();
                            agree_docname = dealerListResponse1.getDealerList().get(i).getAgree_docname();
                            pledge_docname = dealerListResponse1.getDealerList().get(i).getPledge_docname();

                        }
                    }

                }
                else {
                    Toast.makeText(this, "" + dealerListResponse1.getResult(), Toast.LENGTH_SHORT).show();
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
        request.setFlag("VIEW_DEALERDOCS");
        request.setEmpcode(dealer_id);
        request.setDoc_name(doc_type);
        request.setSessionId(sessionId);

        viewModel.viewDealerDoc(request);
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