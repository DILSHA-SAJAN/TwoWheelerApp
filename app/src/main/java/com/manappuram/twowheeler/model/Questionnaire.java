package com.manappuram.twowheeler.model;

public class Questionnaire {
    String cat_id;
    String mark_app;

    public Questionnaire(String cat_id, String mark_app) {
        this.cat_id = cat_id;
        this.mark_app = mark_app;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getMark_app() {
        return mark_app;
    }

    public void setMark_app(String mark_app) {
        this.mark_app = mark_app;
    }
}
