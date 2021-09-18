package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankVerifyOutput  {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("apiStatus")
    @Expose
    private String apiStatus;
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;
    @SerializedName("data")
    @Expose
    private BankVerify data;
    @SerializedName("errorList")
    @Expose
    private Object errorList;

    /**
     * No args constructor for use in serialization
     *
     */
    public BankVerifyOutput() {
    }

    /**
     *
     * @param apiStatus
     * @param status
     * @param data
     * @param errorList
     * @param responseMsg
     */
    public BankVerifyOutput(String status, String apiStatus, String responseMsg, BankVerify data, Object errorList) {
        super();
        this.status = status;
        this.apiStatus = apiStatus;
        this.responseMsg = responseMsg;
        this.data = data;
        this.errorList = errorList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public BankVerify getData() {
        return data;
    }

    public void setData(BankVerify data) {
        this.data = data;
    }

    public Object getErrorList() {
        return errorList;
    }

    public void setErrorList(Object errorList) {
        this.errorList = errorList;
    }

}
