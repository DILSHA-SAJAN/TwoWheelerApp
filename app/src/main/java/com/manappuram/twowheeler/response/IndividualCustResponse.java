package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class IndividualCustResponse extends BaseResponse {
    @SerializedName("custList")
    @Expose
    public ArrayList<custList> custList = null;

    public ArrayList<custList> getCustList() {
        return custList;
    }

    public void setCustList(ArrayList<custList> custList) {
        this.custList = custList;
    }

    public class custList implements Serializable {

        @SerializedName("cust_id")
        @Expose
        public String cust_id;
        @SerializedName("cust_name")
        @Expose
        public String cust_name;

        @SerializedName("gender")
        @Expose
        public String gender;

        @SerializedName("dob")
        @Expose
        public String dob;
        @SerializedName("address")
        @Expose
        public String address;
        @SerializedName("pin_code")
        @Expose
        public String pin_code;

        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("district")
        @Expose
        public String district;
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
        @SerializedName("emi_status")
        @Expose
        public String emi_status;

        @SerializedName("location")
        @Expose
        public String location;
        @SerializedName("house_name")
        @Expose
        public String house_name;
        @SerializedName("job_type")
        @Expose
        public String job_type;
        @SerializedName("post_office")
        @Expose
        public String post_office;
        @SerializedName("pan_no")
        @Expose
        public String pan_no;
        @SerializedName("uploaded_by")
        @Expose
        public String uploaded_by;

        @SerializedName("cibil_score")
        @Expose
        public String cibil_score;
        @SerializedName("tot_int_score")
        @Expose
        public String tot_int_score;

        @SerializedName("remarks")
        @Expose
        public String remarks;

        @SerializedName("LOAN_AMOUNT")
        @Expose
        public String Loan_amt;

        @SerializedName("tenure")
        @Expose
        public String tenure;

        @SerializedName("eligible_sts")
        @Expose
        public String eligible_sts;

        @SerializedName("rating")
        @Expose
        public String rating;
        @SerializedName("down_payment")
        @Expose
        public String down_payment;

        public String getDown_payment() {
            return down_payment;
        }

        public void setDown_payment(String down_payment) {
            this.down_payment = down_payment;
        }

        public String getEligible_sts() {
            return eligible_sts;
        }

        public void setEligible_sts(String eligible_sts) {
            this.eligible_sts = eligible_sts;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getTenure() {
            return tenure;
        }

        public void setTenure(String tenure) {
            this.tenure = tenure;
        }

        public String getLoan_amt() {
            return Loan_amt;
        }

        public void setLoan_amt(String loan_amt) {
            Loan_amt = loan_amt;
        }

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

        public String getPan_no() {
            return pan_no;
        }

        public void setPan_no(String pan_no) {
            this.pan_no = pan_no;
        }

        public String getUploaded_by() {
            return uploaded_by;
        }

        public void setUploaded_by(String uploaded_by) {
            this.uploaded_by = uploaded_by;
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

        public String getEmi_status() {
            return emi_status;
        }

        public void setEmi_status(String emi_status) {
            this.emi_status = emi_status;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getHouse_name() {
            return house_name;
        }

        public void setHouse_name(String house_name) {
            this.house_name = house_name;
        }

        public String getJob_type() {
            return job_type;
        }

        public void setJob_type(String job_type) {
            this.job_type = job_type;
        }

        public String getPost_office() {
            return post_office;
        }

        public void setPost_office(String post_office) {
            this.post_office = post_office;
        }
    }

}
