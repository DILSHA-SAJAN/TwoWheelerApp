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
