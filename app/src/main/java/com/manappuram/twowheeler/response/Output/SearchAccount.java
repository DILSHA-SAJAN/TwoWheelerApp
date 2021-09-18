package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchAccount {

    @SerializedName("ifscCode")
    @Expose
    private String ifscCode;
    @SerializedName("bankName")
    @Expose
    private String bankName;
    @SerializedName("bankBranch")
    @Expose
    private String bankBranch;
    @SerializedName("bankAccount")
    @Expose
    private String bankAccount;
    @SerializedName("accountName")
    @Expose
    private String accountName;
    @SerializedName("bankID")
    @Expose
    private Integer bankID;
    @SerializedName("custID")
    @Expose
    private String custID;
    @SerializedName("serialNO")
    @Expose
    private Integer serialNO;
    @SerializedName("accStatus")
    @Expose
    private String accStatus;
    @SerializedName("custName")
    @Expose
    private String custName;
    @SerializedName("stateID")
    @Expose
    private Integer stateID;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("districtID")
    @Expose
    private Integer districtID;
    @SerializedName("districtName")
    @Expose
    private String districtName;
    @SerializedName("accountType")
    @Expose
    private Integer accountType;

    /**
     * No args constructor for use in serialization
     *
     */
    public SearchAccount() {
    }

    /**
     *
     * @param custID
     * @param bankName
     * @param ifscCode
     * @param bankID
     * @param districtName
     * @param accountName
     * @param accStatus
     * @param districtID
     * @param serialNO
     * @param stateName
     * @param accountType
     * @param stateID
     * @param custName
     * @param bankBranch
     * @param bankAccount
     */
    public SearchAccount(String ifscCode, String bankName, String bankBranch, String bankAccount, String accountName, Integer bankID, String custID, Integer serialNO, String accStatus, String custName, Integer stateID, String stateName, Integer districtID, String districtName, Integer accountType) {
        super();
        this.ifscCode = ifscCode;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.bankAccount = bankAccount;
        this.accountName = accountName;
        this.bankID = bankID;
        this.custID = custID;
        this.serialNO = serialNO;
        this.accStatus = accStatus;
        this.custName = custName;
        this.stateID = stateID;
        this.stateName = stateName;
        this.districtID = districtID;
        this.districtName = districtName;
        this.accountType = accountType;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getBankID() {
        return bankID;
    }

    public void setBankID(Integer bankID) {
        this.bankID = bankID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public Integer getSerialNO() {
        return serialNO;
    }

    public void setSerialNO(Integer serialNO) {
        this.serialNO = serialNO;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

}