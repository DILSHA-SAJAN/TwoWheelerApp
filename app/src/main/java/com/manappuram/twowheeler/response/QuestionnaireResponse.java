package com.manappuram.twowheeler.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionnaireResponse extends BaseResponse {

    @SerializedName("QuestionnaireList")
    public ArrayList<QuestionnaireList> questionnaireList;

    public ArrayList<QuestionnaireList> getQuestionnaireList() {
        return questionnaireList;
    }

    public void setQuestionnaireList(ArrayList<QuestionnaireList> questionnaireList) {
        this.questionnaireList = questionnaireList;
    }

    public class QuestionnaireList implements Serializable {
        @SerializedName("CategoryList")
        public ArrayList<CategoryList> categoryList;
        @SerializedName("cr_id")
        public String cr_id;
        @SerializedName("cr_name")
        public String cr_name;

        public ArrayList<CategoryList> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(ArrayList<CategoryList> categoryList) {
            this.categoryList = categoryList;
        }

        public String getCr_id() {
            return cr_id;
        }

        public void setCr_id(String cr_id) {
            this.cr_id = cr_id;
        }

        public String getCr_name() {
            return cr_name;
        }

        public void setCr_name(String cr_name) {
            this.cr_name = cr_name;
        }
    }
    public class CategoryList implements Serializable {
        @SerializedName("cat_id")
        public String cat_id;
        @SerializedName("cat_name")
        public String cat_name;
        @SerializedName("mark_app")
        public String mark_app;

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public String getMark_app() {
            return mark_app;
        }

        public void setMark_app(String mark_app) {
            this.mark_app = mark_app;
        }
    }
}
