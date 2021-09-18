package com.manappuram.twowheeler.response;

import com.google.gson.annotations.SerializedName;

public class AddCustomerResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private String result;

    @SerializedName("cust_name")
    private String cust_name;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("doc_sequence")
    private String doc_sequence;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDoc_sequence() {
        return doc_sequence;
    }

    public void setDoc_sequence(String doc_sequence) {
        this.doc_sequence = doc_sequence;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
