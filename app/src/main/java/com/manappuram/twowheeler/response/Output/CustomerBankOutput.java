package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerBankOutput {

    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("districtId")
    @Expose
    private Integer districtId;
    @SerializedName("districtName")
    @Expose
    private String districtName;
    @SerializedName("ifscCode")
    @Expose
    private String ifscCode;
    @SerializedName("bankId")
    @Expose
    private Integer bankId;
    @SerializedName("bankName")
    @Expose
    private String bankName;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public CustomerBankOutput() {
    }

    /**
     *
     * @param districtName
     * @param districtId
     * @param status
     * @param stateId
     * @param stateName
     * @param bankName
     * @param ifscCode
     * @param bankId
     */
    public CustomerBankOutput(Integer stateId, String stateName, Integer districtId, String districtName, String ifscCode, Integer bankId, String bankName, ResponseStatus status) {
        super();
        this.stateId = stateId;
        this.stateName = stateName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.ifscCode = ifscCode;
        this.bankId = bankId;
        this.bankName = bankName;
        this.status = status;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
