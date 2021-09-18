package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewCustomerListResponse extends BaseResponse {
    @SerializedName("custList")
    @Expose
    public ArrayList<custList> custList = null;
    public class custList implements Serializable {

        @SerializedName("cust_id")
        @Expose
        public String cust_id;

        @SerializedName("cust_name")
        @Expose
        public String cust_name;

        @SerializedName("dob")
        @Expose
        public String dob;

        @SerializedName("address")
        @Expose
        public String address;

        @SerializedName("pin_code")
        @Expose
        public String pin_code;

        @SerializedName("profession")
        @Expose
        public String profession;

        @SerializedName("product_name")
        @Expose
        public String product_name;

        @SerializedName("quotation")
        @Expose
        public String quotation;

        @SerializedName("mobile")
        @Expose
        public String mobile;

        @SerializedName("pan_no")
        @Expose
        public String pan_no;

        @SerializedName("remarks")
        @Expose
        public String remarks;

        @SerializedName("cibil_score")
        @Expose
        public String cibil_score;

        @SerializedName("tot_int_score")
        @Expose
        public String tot_int_score;

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getCibil_score() {
            return cibil_score;
        }

        public void setCibil_score(String cibil_score) {
            this.cibil_score = cibil_score;
        }

        public String getTot_int_score() {
            return tot_int_score;
        }

        public void setTot_int_score(String tot_int_score) {
            this.tot_int_score = tot_int_score;
        }

        public String getCust_id() {
            return cust_id;
        }

        public void setCust_id(String cust_id) {
            this.cust_id = cust_id;
        }

        public String getCust_name() {
            return cust_name;
        }

        public void setCust_name(String cust_name) {
            this.cust_name = cust_name;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPin_code() {
            return pin_code;
        }

        public void setPin_code(String pin_code) {
            this.pin_code = pin_code;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getQuotation() {
            return quotation;
        }

        public void setQuotation(String quotation) {
            this.quotation = quotation;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPan_no() {
            return pan_no;
        }

        public void setPan_no(String pan_no) {
            this.pan_no = pan_no;
        }
    }

    public ArrayList<ViewCustomerListResponse.custList> getCustList() {
        return custList;
    }

    public void setCustList(ArrayList<ViewCustomerListResponse.custList> custList) {
        this.custList = custList;
    }

}
