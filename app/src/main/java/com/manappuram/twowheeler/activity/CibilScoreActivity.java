package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.databinding.ActivityCibilScoreBinding;
import com.manappuram.twowheeler.databinding.ActivityViewDealerBinding;
import com.manappuram.twowheeler.request.CIBILRequest;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

public class CibilScoreActivity extends AppCompatActivity {
    ActivityCibilScoreBinding binding;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String sessionId = "";
    public String empCode = "";
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cibil_score);

        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        empCode = sharedPreferences.getString("empCode", "");
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cibil_score);

        binding.checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCIBILRetrofit();
            }
        });


    }

    private void getCIBILRetrofit() {
        CIBILRequest request = new CIBILRequest();
        request.setApplicantType(binding.edtapplicantType.getText().toString());
        request.setApplicantFirstName(binding.applicantfirstname.getText().toString());
        request.setApplicantLastName(binding.applicantlastname.getText().toString());
        request.setDateOfBirth(binding.dateofbirth.getText().toString());
        request.setGender(binding.gender.getText().toString());
        request.setIdNumber(binding.idNumber.getText().toString());
        request.setIdType(binding.idType.getText().toString());
        request.setTelephoneNumber(binding.telephoneNumber.getText().toString());
        request.setTelephoneType(binding.telephoneType.getText().toString());
        request.setAddressLine1(binding.addressLine1.getText().toString());
        request.setAddressLine2(binding.addressLine2.getText().toString());
        request.setAddressLine3(binding.addressLine3.getText().toString());
        request.setAddressLine3(binding.addressLine3.getText().toString());
        request.setCity(binding.city.getText().toString());
        request.setPinCode(binding.pinCode.getText().toString());
        request.setResidenceType(binding.residenceType.getText().toString());
        request.setStateCode(binding.stateCode.getText().toString());
        request.setPurpose(binding.purpose.getText().toString());
        request.setAmount(binding.amount.getText().toString());
        request.setScoreType(binding.scoretype.getText().toString());
        request.setGstStateCode(binding.gstStateCode.getText().toString());
        request.setCibilBureauFlag("False");
        request.setIdVerificationFlag("True");
        viewModel.getCIBILScore(request);

        Utility.setProgressbar(this);


        viewModel.getCibilResponseMutableLiveData().observe(this, cibilScoreOutput -> {

            if (cibilScoreOutput != null) {

                if (cibilScoreOutput.getStatus().equals("SUCCESS")) {
                    if (cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getIsSucess().equals("True")) {

                        String score = cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getBureauResponseXml().getCreditReport().getScoreSegment().getScore();
                        Utility.cancelProgressbar();
                        Toast.makeText(this, "CIBIL score is " + score, Toast.LENGTH_SHORT).show();

                    } else {
                        Utility.cancelProgressbar();
                        Toast.makeText(this, "" + cibilScoreOutput.getData().getCibilApplicationNoResponse().getData().getEnvelope().getBody().getExecuteXMLStringResponse().getExecuteXMLStringResult().getDcResponse().getContextData().getField().get(0).getApplicants().getApplicant().getDsCibilBureau().getResponse().getCibilBureauResponse().getIsSucess(), Toast.LENGTH_SHORT).show();
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
}