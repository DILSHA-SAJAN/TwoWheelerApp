package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCustomerRequest {
    @SerializedName("flag")
    @Expose
    private String flag;

    @SerializedName("cust_name")
    @Expose
    private String cust_name;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("pincode")
    @Expose
    private String pincode;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("profession")
    @Expose
    private String profession;

    @SerializedName("product_name")
    @Expose
    private String product_name;

    @SerializedName("quotation")
    @Expose
    private String quotation;

    @SerializedName("tenure")
    @Expose
    private String tenure;

    @SerializedName("mob")
    @Expose
    private String mob;

    @SerializedName("emi_status")
    @Expose
    private String emi_status;

    @SerializedName("uploaded_by")
    @Expose
    private String uploaded_by;

    @SerializedName("loc")
    @Expose
    private String loc;

    @SerializedName("h_name")
    @Expose
    private String h_name;

    @SerializedName("job_typ")
    @Expose
    private String job_typ;
    @SerializedName("dist_id")
    @Expose
    private String dist_id;
    @SerializedName("stat_id")
    @Expose
    private String stat_id;
    @SerializedName("post")
    @Expose
    private String post;
    @SerializedName("Branchid")
    @Expose
    private String Branchid;
    @SerializedName("cibil_score")
    @Expose
    private String cibil_score;
    @SerializedName("Loan_amt")
    @Expose
    private String loan_amount;


    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getCibil_score() {
        return cibil_score;
    }

    public void setCibil_score(String cibil_score) {
        this.cibil_score = cibil_score;
    }

    public String getBranchid() {
        return Branchid;
    }

    public void setBranchid(String branchid) {
        Branchid = branchid;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getJob_typ() {
        return job_typ;
    }

    public void setJob_typ(String job_typ) {
        this.job_typ = job_typ;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
    }

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmi_status() {
        return emi_status;
    }

    public void setEmi_status(String emi_status) {
        this.emi_status = emi_status;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
