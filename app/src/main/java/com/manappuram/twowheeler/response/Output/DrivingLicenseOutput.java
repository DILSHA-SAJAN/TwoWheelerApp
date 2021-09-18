package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class DrivingLicenseOutput {

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
    private DrivingLicenseData data;
    @SerializedName("errorList")
    @Expose
    private List<ErrorList> errorList = null;

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

    public DrivingLicenseData getData() {
        return data;
    }

    public void setData(DrivingLicenseData data) {
        this.data = data;
    }

    public List<ErrorList> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorList> errorList) {
        this.errorList = errorList;
    }

}