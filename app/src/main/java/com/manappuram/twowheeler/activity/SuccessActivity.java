package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.manappuram.twowheeler.R;

public class SuccessActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Intent intent= getIntent();
//        score = intent.getStringExtra("score");
//        txt_score.setText("your score is " +score);
    }
}