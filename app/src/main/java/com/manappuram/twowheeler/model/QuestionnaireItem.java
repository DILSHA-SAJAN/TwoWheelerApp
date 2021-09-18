package com.manappuram.twowheeler.model;


import java.util.ArrayList;
import java.util.List;

public class QuestionnaireItem {
    public String question;

    public List<String> option = new ArrayList<>();

    public int type;

    public QuestionnaireItem(String question, List<String> option, int type) {
        this.question = question;
        this.option = option;
        this.type = type;
    }

    public QuestionnaireItem(String question, List<String> option ) {
        this.question = question;
        this.option = option;
        this.type = 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}