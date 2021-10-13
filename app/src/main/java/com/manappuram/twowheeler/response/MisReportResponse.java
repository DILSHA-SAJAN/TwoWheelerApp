package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MisReportResponse extends BaseResponse {
    @SerializedName("MISReportList")
    @Expose
    public ArrayList<MISReportList> MISReportList = null;

    public ArrayList<MisReportResponse.MISReportList> getMISReportList() {
        return MISReportList;
    }

    public void setMISReportList(ArrayList<MisReportResponse.MISReportList> MISReportList) {
        this.MISReportList = MISReportList;
    }

    public  class MISReportList implements Serializable {
        @SerializedName("cust_name")
        public String cust_name;

        @SerializedName("cust_id")
        public String cust_id;

        @SerializedName("uploaded_by")
        public String uploaded_by;

        @SerializedName("Dealer_name")
        public String Dealer_name;

        @SerializedName("state")
        public String state;

        @SerializedName("BRANCH_NAME")
        public String BRANCH_NAME;

        @SerializedName("tot_int_score")
        public String tot_int_score;

        public String getCust_name() {
            return cust_name;
        }

        public void setCust_name(String cust_name) {
            this.cust_name = cust_name;
        }

        public String getCust_id() {
            return cust_id;
        }

        public void setCust_id(String cust_id) {
            this.cust_id = cust_id;
        }

        public String getUploaded_by() {
            return uploaded_by;
        }

        public void setUploaded_by(String uploaded_by) {
            this.uploaded_by = uploaded_by;
        }

        public String getDealer_name() {
            return Dealer_name;
        }

        public void setDealer_name(String dealer_name) {
            Dealer_name = dealer_name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getBRANCH_NAME() {
            return BRANCH_NAME;
        }

        public void setBRANCH_NAME(String BRANCH_NAME) {
            this.BRANCH_NAME = BRANCH_NAME;
        }

        public String getTot_int_score() {
            return tot_int_score;
        }

        public void setTot_int_score(String tot_int_score) {
            this.tot_int_score = tot_int_score;
        }
    }
}
