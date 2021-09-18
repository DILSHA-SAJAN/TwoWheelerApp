package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification {

    @SerializedName("panNo")
    @Expose
    private String panNo;
    @SerializedName("passportNumber")
    @Expose
    private String passportNumber;
    @SerializedName("dlNo")
    @Expose
    private String dlNo;
    @SerializedName("voterId")
    @Expose
    private String voterId;
    @SerializedName("uId")
    @Expose
    private String uId;
    @SerializedName("rationCardNo")
    @Expose
    private String rationCardNo;
    @SerializedName("additionalID1")
    @Expose
    private String additionalID1;
    @SerializedName("additionalID2")
    @Expose
    private String additionalID2;

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getRationCardNo() {
        return rationCardNo;
    }

    public void setRationCardNo(String rationCardNo) {
        this.rationCardNo = rationCardNo;
    }

    public String getAdditionalID1() {
        return additionalID1;
    }

    public void setAdditionalID1(String additionalID1) {
        this.additionalID1 = additionalID1;
    }

    public String getAdditionalID2() {
        return additionalID2;
    }

    public void setAdditionalID2(String additionalID2) {
        this.additionalID2 = additionalID2;
    }

}