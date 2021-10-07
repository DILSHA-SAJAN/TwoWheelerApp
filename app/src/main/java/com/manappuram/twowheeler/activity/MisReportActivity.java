package com.manappuram.twowheeler.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.MisDataAdapter;
import com.manappuram.twowheeler.adapter.ViewDealerItemAdapter;
import com.manappuram.twowheeler.databinding.ActivityMisReportBinding;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.response.MisReportResponse;
import com.manappuram.twowheeler.response.ViewDealerListResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;


import java.util.ArrayList;


public class MisReportActivity extends AppCompatActivity {

    ActivityMisReportBinding binding;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    LoginViewModel viewModel;
    MisDataAdapter adapter;
    public String sessionId = "";

    ArrayList<MisReportResponse.MISReportList> mis_list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mis_report);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        adapter = new MisDataAdapter(MisReportActivity.this, mis_list);


        OtherVerticalsRequest request = new OtherVerticalsRequest();
        request.setFlag("GET_MIS_REPORT");
        request.setSessionId(sessionId);
        viewModel.viewMISData(request);
        Utility.setProgressbar(this);
        viewModel.getMisReportResponseMutableLiveData().observe(this, misReportResponse1 -> {

            Utility.cancelProgressbar();
            if (misReportResponse1 != null) {
                if (misReportResponse1.getStatus().equals("111")) {
                    if (misReportResponse1.getMISReportList().size() > 0) {

                        mis_list.addAll(misReportResponse1.getMISReportList());
                        binding.reportRecycler.setLayoutManager(new LinearLayoutManager(this));
                        binding.reportRecycler.setAdapter(adapter);
                        adapter.notifyDataSetChanged();


                    }

                } else {

                    Toast.makeText(this, "" + misReportResponse1.getResult(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {


            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    generatePDF();

            }
        });


    }




    public interface misSelectListener {

        void onitemClick(String dealer_id);
    }







   }