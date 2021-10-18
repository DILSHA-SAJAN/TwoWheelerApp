package com.manappuram.twowheeler.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.MisDataAdapter;
import com.manappuram.twowheeler.databinding.ActivityMisReportBinding;
import com.manappuram.twowheeler.request.OtherVerticalsRequest;
import com.manappuram.twowheeler.response.MisReportResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class MisReportActivity extends AppCompatActivity {

    ActivityMisReportBinding binding;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    LoginViewModel viewModel;
    MisDataAdapter adapter;
    public String sessionId = "";
    private ProgressDialog loadingbar;
    ArrayList<MisReportResponse.MISReportList> mis_list = new ArrayList<>();

    //excel declaration begin
    private String csv;
    private WritableWorkbook workbook;

//excel declaration begin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sessionId = sharedPreferences.getString("sessionId", "");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mis_report);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        adapter = new MisDataAdapter(MisReportActivity.this, mis_list);
        csv = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyCsvFile.csv"); // Here csv file name is MyCsvFile.csv
        loadingbar=new ProgressDialog(this);
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    //your code
                    loadingbar.setTitle("please wait");
                    loadingbar.setMessage("downloading the table into excel format");
                    loadingbar.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            createExcelSheet();
                        }
                    },2210);



                }

            }
        });


    }

    private void createExcelSheet() {
        //File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

        String csvFile = "Report.xls";
        java.io.File futureStudioIconFile = new java.io.File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + csvFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        try {
            workbook = Workbook.createWorkbook(futureStudioIconFile, wbSettings);
            createFirstSheet(mis_list);
            workbook.write();
            workbook.close();
            loadingbar.dismiss();
            Toast.makeText(MisReportActivity.this,"Download success",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void createFirstSheet(ArrayList<MisReportResponse.MISReportList> mis_list) {
        try {

            WritableSheet sheet = workbook.createSheet("Report", 0);
            // column and row title

            sheet.setColumnView(0, (15 * 400));

            sheet.addCell(new Label(0, 0, "Customer Name"));
            sheet.addCell(new Label(1, 0, "Cust ID"));
            sheet.addCell(new Label(2, 0, "Dealer ID"));
            sheet.addCell(new Label(3, 0, "Dealer Name"));
            sheet.addCell(new Label(4,0,"State"));
            sheet.addCell(new Label(5,0,"Branch Name"));
            sheet.addCell(new Label(6,0,"Internal Score"));
            for (int i = 0; i < mis_list.size(); i++) {
                sheet.addCell(new Label(0, i + 1, mis_list.get(i).getCust_name()));
                sheet.addCell(new Label(1, i + 1, mis_list.get(i).getCust_id()));
                sheet.addCell(new Label(2, i + 1, mis_list.get(i).getUploaded_by()));
                sheet.addCell(new Label(3, i + 1, mis_list.get(i).getDealer_name()));
                sheet.addCell(new Label(4, i + 1, mis_list.get(i).getState()));
                sheet.addCell(new Label(5, i +  1, mis_list.get(i).getBRANCH_NAME()));
                sheet.addCell(new Label(6, i +  1,  mis_list.get(i).getTot_int_score()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public interface misSelectListener {

        void onitemClick(String dealer_id);
    }








}