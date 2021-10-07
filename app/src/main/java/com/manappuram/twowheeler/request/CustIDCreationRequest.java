package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustIDCreationRequest extends BaseRequest{


    @SerializedName("cust_name")
    @Expose
    private String cust_name;
    @SerializedName("cust_mob")
    @Expose
    private String cust_mob;
    @SerializedName("doc_seq")
    @Expose
    private String doc_seq;

    @SerializedName("state_id")
    @Expose
    private String state_id;

    @SerializedName("district_id")
    @Expose
    private String district_id;
    @SerializedName("loan_amt")
    @Expose
    private String loan_amt;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("updated_by")
    @Expose
    private String updated_by;
    @SerializedName("branch_id")
    @Expose
    private String branch_id;
    @SerializedName("dob")
    @Expose
    private String dob;

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getLoan_amt() {
        return loan_amt;
    }

    public void setLoan_amt(String loan_amt) {
        this.loan_amt = loan_amt;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_mob() {
        return cust_mob;
    }

    public void setCust_mob(String cust_mob) {
        this.cust_mob = cust_mob;
    }

    public String getDoc_seq() {
        return doc_seq;
    }

    public void setDoc_seq(String doc_seq) {
        this.doc_seq = doc_seq;
    }
}
