package com.manappuram.twowheeler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.adapter.QuestionnaireAdapter;
import com.manappuram.twowheeler.databinding.ActivityInternalScoreCardBinding;
import com.manappuram.twowheeler.model.Questionnaire;
import com.manappuram.twowheeler.model.QuestionnaireItem;
import com.manappuram.twowheeler.request.BaseRequest;
import com.manappuram.twowheeler.request.ScoreCardRequest;
import com.manappuram.twowheeler.response.QuestionnaireResponse;
import com.manappuram.twowheeler.utils.Utility;
import com.manappuram.twowheeler.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalScoreCardActivity extends AppCompatActivity {

    ActivityInternalScoreCardBinding binding;
    LoginViewModel viewModel;

    private ArrayList<QuestionnaireItem> mExampleList;

    private ArrayList<QuestionnaireItem> mDisplayList = new ArrayList<>();


    private RecyclerView mRecyclerView;
    private QuestionnaireAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private int answerCount = 0;


    private LinearLayout completedButton;

    public SharedPreferences sharedPreferences;

    String sessionId;
    String cust_id = "", cibil_score = "";

    ArrayList<QuestionnaireResponse.QuestionnaireList> questionnaireList;

    Map<String, Questionnaire> map = new HashMap<>();

    int total_mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_internal_score_card);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        sharedPreferences = getSharedPreferences("ess-app", Context.MODE_PRIVATE);

        sessionId = sharedPreferences.getString("sessionId", "");
        cust_id = getIntent().getStringExtra("cust_id");
        cibil_score = getIntent().getStringExtra("cibil_score");


        getQuestionnaire();

        binding.btnBack.setOnClickListener(v -> finish());

        binding.tvContinue.setOnClickListener(v -> {
            binding.tvContinue.setEnabled(false);

            String result = "";
            for (Map.Entry<String, Questionnaire> entry : map.entrySet()) {
                result += entry.getKey() + "~" + entry.getValue().getCat_id() + "~" + entry.getValue().getMark_app() + "^";
            }
            if (cibil_score != null) {
                //attach cibil score with result
                if (cibil_score.equals(("000-1"))) {
                    cibil_score = "-1";
                    total_mark += 5;
                } else if (Integer.parseInt(cibil_score) > 700) {
                    total_mark += 10;
                } else if (Integer.parseInt(cibil_score) < 550) {
                    total_mark += 5;
                } else if ((Integer.parseInt(cibil_score) > 550) && (Integer.parseInt(cibil_score) < 700)) {
                    total_mark += 8;
                } else {
                    total_mark += 0;
                }
            }

            if (result != null && result.length() > 0 && result.charAt(result.length() - 1) == '^') {
                result = result.substring(0, result.length() - 1)+'^';
            }

            Log.e("Result", result);
            sendInternalScore(result);

        });


    }


    public void sendInternalScore(String score_string) {
        Utility.setProgressbar(this);
        ScoreCardRequest request = new ScoreCardRequest();
        request.setFlag("GET_SCORECARD");
        request.setCustid(cust_id);
        request.setScore_string(score_string);
        request.setTotal_score(String.valueOf(total_mark));
        request.setSessionId(sessionId);

        viewModel.sendInternalScore(request);
        viewModel.getBaseResponseMutableLiveData().observe(this, scoreCardResponse -> {

            if (scoreCardResponse != null) {
                Utility.cancelProgressbar();

                if (scoreCardResponse.getStatus().equals("111")) {

                    Toast.makeText(this, "" + scoreCardResponse.getResult(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ViewCustomerActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    binding.tvContinue.setEnabled(true);
                    Toast.makeText(this, "" + scoreCardResponse.getResult(), Toast.LENGTH_SHORT).show();

                }

            }
        });

        viewModel.getLoginRepository().getErrorsMutable().observe(this, error -> {

            if (error.getContent() != null) {
                Utility.cancelProgressbar();
                binding.tvContinue.setEnabled(true);
                Toast.makeText(this, error.getContent().getResult(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void selectOption(int position, int index) {

        if (position + 1 < mDisplayList.size()) {

            mDisplayList.set(position + 1, new QuestionnaireItem(mExampleList.get(position / 2).option.get(index), null, 1));
            mAdapter.notifyItemChanged(position + 1);

        } else {

            mDisplayList.add(position + 1, new QuestionnaireItem(mExampleList.get(answerCount).option.get(index), null, 1));
            mAdapter.notifyItemInserted(position + 1);
            answerCount++;
            if (mExampleList.size() > answerCount) {
                mDisplayList.add(mExampleList.get(answerCount));
                mAdapter.notifyItemInserted(position + 2);
            } else {
                // Questions ended
                mDisplayList.add(new QuestionnaireItem(null, null, 2));
                mAdapter.notifyItemInserted(position + 2);
                completedButton.setVisibility(View.VISIBLE);
            }
            mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
            Log.e("Position", String.valueOf(position));
            Log.e("Ans Count", String.valueOf(answerCount));
        }
    }

    public void selectSpinnerOption(int position, int index) {
        //Log.e("Selected", mExampleList.get(position / 2).option.get(index - 1));
        if (position + 1 < mDisplayList.size()) {

            mDisplayList.set(position + 1, new QuestionnaireItem(mExampleList.get(position / 2).option.get(index - 1), null, 5));

            Toast.makeText(this, mExampleList.get(position / 2).option.get(index - 1), Toast.LENGTH_SHORT).show();

            String cat_id = questionnaireList.get(position / 2).categoryList.get(index - 1).cat_id;
            String mark_app = questionnaireList.get(position / 2).categoryList.get(index - 1).mark_app;
            String cr_id = questionnaireList.get(position / 2).cr_id;

            Questionnaire questionnaire = new Questionnaire(cat_id, mark_app);

            map.put(cr_id, questionnaire);

        } else {

            mDisplayList.add(position + 1, new QuestionnaireItem(mExampleList.get(answerCount).option.get(index - 1), null, 5));
            Toast.makeText(this, mExampleList.get(answerCount).option.get(index - 1), Toast.LENGTH_SHORT).show();

            String cat_id = questionnaireList.get(position / 2).categoryList.get(index - 1).cat_id;
            String mark_app = questionnaireList.get(position / 2).categoryList.get(index - 1).mark_app;
            String cr_id = questionnaireList.get(position / 2).cr_id;

            Questionnaire questionnaire = new Questionnaire(cat_id, mark_app);
            map.put(cr_id, questionnaire);


            answerCount++;


            if (mExampleList.size() > answerCount) {
                mDisplayList.add(mExampleList.get(answerCount));
                mAdapter.notifyItemInserted(position + 2);
            } else {
                // Questions ended
                mDisplayList.add(new QuestionnaireItem(null, null, 2));
                mAdapter.notifyItemInserted(position + 2);
                completedButton.setVisibility(View.VISIBLE);


            }
            mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
        }

        total_mark = 0;
        for (Questionnaire value : map.values()) {
            total_mark += Integer.parseInt(value.getMark_app());
        }
        Log.e("Total, " + map.size(), String.valueOf(total_mark));

    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        //getQuestionnaire();
        if (questionnaireList != null) {
            for (QuestionnaireResponse.QuestionnaireList q : questionnaireList) {
                List<String> options = new ArrayList<>();
                for (int i = 0; i < q.getCategoryList().size(); i++) {
                    options.add(q.getCategoryList().get(i).cat_name);
                }
                mExampleList.add(new QuestionnaireItem(q.cr_name, options, 0));
                Log.e(q.cr_id, q.cr_name);
            }

            buildRecyclerView();

        } else
            Toast.makeText(InternalScoreCardActivity.this, "Unable to get questionnaire list", Toast.LENGTH_SHORT).show();

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);

        completedButton = findViewById(R.id.layout_questionnaire_button);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

     //   Log.i("mExampleList[0]", "<==" + mExampleList.get(0));

        mDisplayList.add(mExampleList.get(0));

        mAdapter = new QuestionnaireAdapter(mDisplayList);

        mRecyclerView.setLayoutManager(mLayoutManager);

        // Nivin code set cache
        mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, (mExampleList.size()*2)+3);
        mRecyclerView.setItemViewCacheSize((mExampleList.size()*2)+3);

        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new QuestionnaireAdapter.OnItemClickListener() {
            @Override
            public void onOptionOneClick(int position) {
                selectOption(position, 0);
                //  Log.d("poooos", String.valueOf(position));
            }

            @Override
            public void onOptionTwoClick(int position) {
                selectOption(position, 1);
                // Log.d("poooos1", String.valueOf(position));
            }

            @Override
            public void onSpinnerSelect(int position, int sposition) {
                Log.i("SpinnerClkPstActvty","<=="+position+", "+sposition);
                selectSpinnerOption(position, sposition);
                Log.d("position", String.valueOf(position));
                Log.d("sposition", String.valueOf(sposition));


            }
        });
    }


    private void getQuestionnaire() {
        BaseRequest request = new BaseRequest();
        request.setSessionId(sessionId);
        viewModel.getQuestionnaire(request);
        Utility.setProgressbar(this);
        viewModel.getQuestionnaireResponseMutableLiveData().observe(this, questionnaireResponse -> {
            Utility.cancelProgressbar();

            if (questionnaireResponse != null) {
                if (questionnaireResponse.getStatus().equals("111")) {
                    if (questionnaireResponse.getQuestionnaireList().size() > 0) {

                        questionnaireList = questionnaireResponse.getQuestionnaireList();
                        createExampleList();

                    }
                } else if (questionnaireResponse.getStatus().equals("222")) {
                    Toast.makeText(this, "Failed to load questionnaire", Toast.LENGTH_SHORT).show();
                } else if (questionnaireResponse.getStatus().equals("333")) {
                    Toast.makeText(this, "Session Expired", Toast.LENGTH_SHORT).show();
                }
            } else
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        });
    }

//    private void submitQuestionnaire(List<QuestionnaireSubmit> Cr_List) {
//        ScoreCardRequest request = new ScoreCardRequest();
//        request.setSessionId(sessionId);
//        request.setCr_List(Cr_List);
//        request.setCustid(cust_id);
//
//        viewModel.sendInternalScore(request);
//        Utility.setProgressbar(this);
//        viewModel.getBaseResponseMutableLiveData().observe(this, baseResponse -> {
//
//            Utility.cancelProgressbar();
//            if (baseResponse != null) {
//                if (baseResponse.getStatus().equals("111")) {
//
//                    Intent intent = new Intent(this, ViewCustomerActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                } else if (baseResponse.getStatus().equals("222")) {
//                    Toast.makeText(this, "Failed to submit score", Toast.LENGTH_SHORT).show();
//                } else if (baseResponse.getStatus().equals("333")) {
//                    Toast.makeText(this, "Session Expired", Toast.LENGTH_SHORT).show();
//                }
//            } else
//                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
//        });
//    }


}