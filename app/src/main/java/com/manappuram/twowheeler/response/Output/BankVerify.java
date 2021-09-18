package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankVerify {

    @SerializedName("beneName")
    @Expose
    private String beneName;
    @SerializedName("bankRef")
    @Expose
    private String bankRef;
    @SerializedName("account")
    @Expose
    private Object account;
    @SerializedName("ifsc")
    @Expose
    private Object ifsc;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("remark")
    @Expose
    private String remark;

    /**
     * No args constructor for use in serialization
     *
     */
    public BankVerify() {
    }

    /**
     *
     * @param remark
     * @param status
     * @param account
     * @param beneName
     * @param bankRef
     * @param ifsc
     */
    public BankVerify(String beneName, String bankRef, Object account, Object ifsc, String status, String remark) {
        super();
        this.beneName = beneName;
        this.bankRef = bankRef;
        this.account = account;
        this.ifsc = ifsc;
        this.status = status;
        this.remark = remark;
    }

    public String getBeneName() {
        return beneName;
    }

    public void setBeneName(String beneName) {
        this.beneName = beneName;
    }

    public String getBankRef() {
        return bankRef;
    }

    public void setBankRef(String bankRef) {
        this.bankRef = bankRef;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getIfsc() {
        return ifsc;
    }

    public void setIfsc(Object ifsc) {
        this.ifsc = ifsc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}