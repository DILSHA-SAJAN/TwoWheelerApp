package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.manappuram.twowheeler.adapter.QuestionnaireAdapter;
import com.manappuram.twowheeler.databinding.ActivityInternalScoreCardBinding;
import com.manappuram.twowheeler.databinding.ActivityViewQuestionnaireAnswerBinding;
import com.manappuram.twowheeler.model.QuestionnaireItem;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;

public class ViewQuestionnaireAnswerActivity extends AppCompatActivity {

    ActivityViewQuestionnaireAnswerBinding binding;
    LoginViewModel viewModel;

    private ArrayList<QuestionnaireItem> mDisplayList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private QuestionnaireAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}