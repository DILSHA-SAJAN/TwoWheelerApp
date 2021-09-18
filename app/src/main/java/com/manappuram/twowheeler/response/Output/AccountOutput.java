package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountOutput {
    @SerializedName("accountTypeList")
    @Expose
    private List<Account> accountTypeList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public AccountOutput() {
    }

    /**
     *
     * @param status
     * @param accountTypeList
     */
    public AccountOutput(List<Account> accountTypeList, ResponseStatus status) {
        super();
        this.accountTypeList = accountTypeList;
        this.status = status;
    }

    public List<Account> getAccountTypeList() {
        return accountTypeList;
    }

    public void setAccountTypeList(List<Account> accountTypeList) {
        this.accountTypeList = accountTypeList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
