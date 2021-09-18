package com.manappuram.twowheeler.adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.manappuram.twowheeler.R;
import com.manappuram.twowheeler.model.QuestionnaireItem;

import java.util.ArrayList;
import java.util.List;


public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.QuestionnaireViewHolder> {
    private ArrayList<QuestionnaireItem> mExampleList;

    private OnItemClickListener mListener;
//    private OnItemSelectedListener mListenerSelect;

    public interface OnItemClickListener {
        void onOptionOneClick(int position);

        void onOptionTwoClick(int position);

        void onSpinnerSelect(int position, int sposition);

    }

//    private interface OnItemSelectedListener{
//        void onSpinnerSelect(int position, int sposition);
//    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

//    public void setOnItemSelectListener(OnItemSelectedListener listener) {
//        mListenerSelect = listener;
//    }


    private static final int VIEW_TYPE_QUESTION = 1;
    private static final int VIEW_TYPE_ANSWER = 2;
    private static final int VIEW_TYPE_ANSWER_SPINNER = 3;
    private static final int VIEW_TYPE_END = 4;
    private static final int HIDDEN = 5;

    public static class QuestionnaireViewHolder extends RecyclerView.ViewHolder {

        public TextView questionText;
        public TextView answerText;
        public TextView optionOne;
        public TextView optionTwo;
        public Spinner optionSpinner;


        public QuestionnaireViewHolder(View itemView, int type, final OnItemClickListener listener) {
            super(itemView);
            if(type == VIEW_TYPE_QUESTION){
                questionText = itemView.findViewById(R.id.text_question);
                optionOne = itemView.findViewById(R.id.option_first);
                optionTwo = itemView.findViewById(R.id.option_second);

                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(listener!=null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {

                                optionOne.setBackgroundResource(R.drawable.curved_black_button);
                                optionOne.setTextColor(Color.WHITE);
                                optionTwo.setBackgroundResource(R.drawable.view_black_border);
                                optionTwo.setTextColor(Color.BLACK);

                                listener.onOptionOneClick(position);
                            }
                        }
                    }
                });

                optionTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(listener!=null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {

                                optionTwo.setBackgroundResource(R.drawable.curved_black_button);
                                optionTwo.setTextColor(Color.WHITE);
                                optionOne.setBackgroundResource(R.drawable.view_black_border);
                                optionOne.setTextColor(Color.BLACK);

                                listener.onOptionTwoClick(position);
                            }
                        }
                    }
                });

            }
            else if(type == VIEW_TYPE_ANSWER){
                answerText = itemView.findViewById(R.id.text_answer);
            }
            else if(type == VIEW_TYPE_ANSWER_SPINNER){
                questionText = itemView.findViewById(R.id.text_question_spinner);
                optionSpinner = itemView.findViewById(R.id.spinner_option);
                optionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int sposition, long id) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION && sposition>0) {
                            listener.onSpinnerSelect(position, sposition);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }
    }

    public QuestionnaireAdapter(ArrayList<QuestionnaireItem> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public int getItemViewType(int position) {
        QuestionnaireItem message = (QuestionnaireItem) mExampleList.get(position);
        if(message.getType()==0&&message.option.size()<3)
        {
            return VIEW_TYPE_QUESTION;
        }
        else if (message.getType()==0) {
            // If the current user is the sender of the message
            return VIEW_TYPE_ANSWER_SPINNER;
        }
        else if (message.getType()==1) {
            // If the current user is the sender of the message
            return VIEW_TYPE_ANSWER;
        }
        else if (message.getType()==2) {
            // If the current user is the sender of the message
            return VIEW_TYPE_END;
        }
        else {
            // If some other user sent the message
            return HIDDEN;
        }
    }

    @Override
    public QuestionnaireViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if(viewType == VIEW_TYPE_ANSWER_SPINNER){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_spinner, parent, false);
            return new QuestionnaireViewHolder(view,VIEW_TYPE_ANSWER_SPINNER, mListener);
        }
        else if(viewType == VIEW_TYPE_QUESTION){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_other, parent, false);
            return new QuestionnaireViewHolder(view,VIEW_TYPE_QUESTION, mListener);
        }
        else if(viewType == VIEW_TYPE_ANSWER){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_me, parent, false);
            return new QuestionnaireViewHolder(view,VIEW_TYPE_ANSWER, mListener);
        }
        else if(viewType == VIEW_TYPE_END){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_end, parent, false);
            return new QuestionnaireViewHolder(view,VIEW_TYPE_END, mListener);
        }
        else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.empty_view, parent, false);
            return new QuestionnaireViewHolder(view,HIDDEN, mListener);
        }

    }

    @Override
    public void onBindViewHolder(QuestionnaireViewHolder holder, int position) {
        QuestionnaireItem currentItem = mExampleList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_ANSWER:
                holder.answerText.setText(currentItem.question);
                break;
            case VIEW_TYPE_QUESTION:
                holder.questionText.setText(currentItem.question);
                holder.optionOne.setText(currentItem.getOption().get(0));
                holder.optionTwo.setText(currentItem.getOption().get(1));
                break;
            case VIEW_TYPE_ANSWER_SPINNER:
                holder.questionText.setText(currentItem.question);
                List<String> options = new ArrayList<>();
                options.add("Please Select");
                options.addAll(currentItem.getOption());
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        holder.itemView.getContext(), android.R.layout.simple_spinner_item, options){
                    @Override
                    public boolean isEnabled(int sposition){
                        if(sposition == 0)
                            return false;
                        else
                            return true;
                    }
                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if(position == 0)
                            tv.setTextColor(Color.GRAY);
                        else
                            tv.setTextColor(Color.BLACK);

                        final TextView finalItem = tv;
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                finalItem.setSingleLine(false);
                            }
                        });

                        return view;
                    }
                };

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                holder.optionSpinner.setAdapter(arrayAdapter);
                break;
            case HIDDEN: break;
        }

    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}