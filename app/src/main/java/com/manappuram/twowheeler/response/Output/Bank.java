package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bank {
    @SerializedName("ifsccode")
    @Expose
    private String ifsccode;
    @SerializedName("bankid")
    @Expose
    private Integer bankid;
    @SerializedName("bankname")
    @Expose
    private String bankname;

    /**
     * No args constructor for use in serialization
     *
     */
    public Bank() {
    }

    /**
     *
     * @param bankname
     * @param bankid
     * @param ifsccode
     */
    public Bank(String ifsccode, Integer bankid, String bankname) {
        super();
        this.ifsccode = ifsccode;
        this.bankid = bankid;
        this.bankname = bankname;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Override
    public String toString() {
        return getBankname();
    }

}
