package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicationData {

    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("scoreType")
    @Expose
    private String scoreType;
    @SerializedName("ntcProductType")
    @Expose
    private String ntcProductType;
    @SerializedName("consumerConsentForUIDAIAuthentication")
    @Expose
    private String consumerConsentForUIDAIAuthentication;
    @SerializedName("gstStateCode")
    @Expose
    private String gstStateCode;
    @SerializedName("cibilBureauFlag")
    @Expose
    private String cibilBureauFlag;
    @SerializedName("dsTuNtcFlag")
    @Expose
    private String dsTuNtcFlag;
    @SerializedName("idVerificationFlag")
    @Expose
    private String idVerificationFlag;
    @SerializedName("mfiBureauFlag")
    @Expose
    private String mfiBureauFlag;
    @SerializedName("mfiEnquiryAmount")
    @Expose
    private String mfiEnquiryAmount;
    @SerializedName("mfiLoanPurpose")
    @Expose
    private String mfiLoanPurpose;
    @SerializedName("mfiCenterReferenceNo")
    @Expose
    private String mfiCenterReferenceNo;
    @SerializedName("mfiBranchReferenceNo")
    @Expose
    private String mfiBranchReferenceNo;
    @SerializedName("formattedReport")
    @Expose
    private String formattedReport;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getNtcProductType() {
        return ntcProductType;
    }

    public void setNtcProductType(String ntcProductType) {
        this.ntcProductType = ntcProductType;
    }

    public String getConsumerConsentForUIDAIAuthentication() {
        return consumerConsentForUIDAIAuthentication;
    }

    public void setConsumerConsentForUIDAIAuthentication(String consumerConsentForUIDAIAuthentication) {
        this.consumerConsentForUIDAIAuthentication = consumerConsentForUIDAIAuthentication;
    }

    public String getGstStateCode() {
        return gstStateCode;
    }

    public void setGstStateCode(String gstStateCode) {
        this.gstStateCode = gstStateCode;
    }

    public String getCibilBureauFlag() {
        return cibilBureauFlag;
    }

    public void setCibilBureauFlag(String cibilBureauFlag) {
        this.cibilBureauFlag = cibilBureauFlag;
    }

    public String getDsTuNtcFlag() {
        return dsTuNtcFlag;
    }

    public void setDsTuNtcFlag(String dsTuNtcFlag) {
        this.dsTuNtcFlag = dsTuNtcFlag;
    }

    public String getIdVerificationFlag() {
        return idVerificationFlag;
    }

    public void setIdVerificationFlag(String idVerificationFlag) {
        this.idVerificationFlag = idVerificationFlag;
    }

    public String getMfiBureauFlag() {
        return mfiBureauFlag;
    }

    public void setMfiBureauFlag(String mfiBureauFlag) {
        this.mfiBureauFlag = mfiBureauFlag;
    }

    public String getMfiEnquiryAmount() {
        return mfiEnquiryAmount;
    }

    public void setMfiEnquiryAmount(String mfiEnquiryAmount) {
        this.mfiEnquiryAmount = mfiEnquiryAmount;
    }

    public String getMfiLoanPurpose() {
        return mfiLoanPurpose;
    }

    public void setMfiLoanPurpose(String mfiLoanPurpose) {
        this.mfiLoanPurpose = mfiLoanPurpose;
    }

    public String getMfiCenterReferenceNo() {
        return mfiCenterReferenceNo;
    }

    public void setMfiCenterReferenceNo(String mfiCenterReferenceNo) {
        this.mfiCenterReferenceNo = mfiCenterReferenceNo;
    }

    public String getMfiBranchReferenceNo() {
        return mfiBranchReferenceNo;
    }

    public void setMfiBranchReferenceNo(String mfiBranchReferenceNo) {
        this.mfiBranchReferenceNo = mfiBranchReferenceNo;
    }

    public String getFormattedReport() {
        return formattedReport;
    }

    public void setFormattedReport(String formattedReport) {
        this.formattedReport = formattedReport;
    }

}