package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicationData {
    @SerializedName("formattedReport")
    @Expose
    private String formattedReport;
    @SerializedName("mfiBranchReferenceNo")
    @Expose
    private String mfiBranchReferenceNo;
    @SerializedName("mfiCenterReferenceNo")
    @Expose
    private String mfiCenterReferenceNo;
    @SerializedName("mfiLoanPurpose")
    @Expose
    private String mfiLoanPurpose;
    @SerializedName("mfiEnquiryAmount")
    @Expose
    private String mfiEnquiryAmount;
    @SerializedName("consumerConsentForUIDAIAuthentication")
    @Expose
    private String consumerConsentForUIDAIAuthentication;
    @SerializedName("ntcProductType")
    @Expose
    private String ntcProductType;
    @SerializedName("mfiBureauFlag")
    @Expose
    private String mfiBureauFlag;
    @SerializedName("idVerificationFlag")
    @Expose
    private String idVerificationFlag;
    @SerializedName("dsTuNtcFlag")
    @Expose
    private String dsTuNtcFlag;
    @SerializedName("cibilBureauFlag")
    @Expose
    private String cibilBureauFlag;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("memberCode")
    @Expose
    private String memberCode;
    @SerializedName("gstStateCode")
    @Expose
    private String gstStateCode;
    @SerializedName("scoreType")
    @Expose
    private String scoreType;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("mfiDocRequest")
    @Expose
    private String mfiDocRequest;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("dtTrail")
    @Expose
    private DtTrail dtTrail;
    @SerializedName("milestone")
    @Expose
    private Milestone milestone;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("inputValReasonCodes")
    @Expose
    private String inputValReasonCodes;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("businessUnitId")
    @Expose
    private String businessUnitId;
    @SerializedName("applicationId")
    @Expose
    private String applicationId;
    @SerializedName("solutionSetId")
    @Expose
    private String solutionSetId;
    @SerializedName("environmentTypeId")
    @Expose
    private String environmentTypeId;
    @SerializedName("environmentType")
    @Expose
    private String environmentType;

    public String getFormattedReport() {
        return formattedReport;
    }

    public void setFormattedReport(String formattedReport) {
        this.formattedReport = formattedReport;
    }

    public String getMfiBranchReferenceNo() {
        return mfiBranchReferenceNo;
    }

    public void setMfiBranchReferenceNo(String mfiBranchReferenceNo) {
        this.mfiBranchReferenceNo = mfiBranchReferenceNo;
    }

    public String getMfiCenterReferenceNo() {
        return mfiCenterReferenceNo;
    }

    public void setMfiCenterReferenceNo(String mfiCenterReferenceNo) {
        this.mfiCenterReferenceNo = mfiCenterReferenceNo;
    }

    public String getMfiLoanPurpose() {
        return mfiLoanPurpose;
    }

    public void setMfiLoanPurpose(String mfiLoanPurpose) {
        this.mfiLoanPurpose = mfiLoanPurpose;
    }

    public String getMfiEnquiryAmount() {
        return mfiEnquiryAmount;
    }

    public void setMfiEnquiryAmount(String mfiEnquiryAmount) {
        this.mfiEnquiryAmount = mfiEnquiryAmount;
    }

    public String getConsumerConsentForUIDAIAuthentication() {
        return consumerConsentForUIDAIAuthentication;
    }

    public void setConsumerConsentForUIDAIAuthentication(String consumerConsentForUIDAIAuthentication) {
        this.consumerConsentForUIDAIAuthentication = consumerConsentForUIDAIAuthentication;
    }

    public String getNtcProductType() {
        return ntcProductType;
    }

    public void setNtcProductType(String ntcProductType) {
        this.ntcProductType = ntcProductType;
    }

    public String getMfiBureauFlag() {
        return mfiBureauFlag;
    }

    public void setMfiBureauFlag(String mfiBureauFlag) {
        this.mfiBureauFlag = mfiBureauFlag;
    }

    public String getIdVerificationFlag() {
        return idVerificationFlag;
    }

    public void setIdVerificationFlag(String idVerificationFlag) {
        this.idVerificationFlag = idVerificationFlag;
    }

    public String getDsTuNtcFlag() {
        return dsTuNtcFlag;
    }

    public void setDsTuNtcFlag(String dsTuNtcFlag) {
        this.dsTuNtcFlag = dsTuNtcFlag;
    }

    public String getCibilBureauFlag() {
        return cibilBureauFlag;
    }

    public void setCibilBureauFlag(String cibilBureauFlag) {
        this.cibilBureauFlag = cibilBureauFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getGstStateCode() {
        return gstStateCode;
    }

    public void setGstStateCode(String gstStateCode) {
        this.gstStateCode = gstStateCode;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMfiDocRequest() {
        return mfiDocRequest;
    }

    public void setMfiDocRequest(String mfiDocRequest) {
        this.mfiDocRequest = mfiDocRequest;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public DtTrail getDtTrail() {
        return dtTrail;
    }

    public void setDtTrail(DtTrail dtTrail) {
        this.dtTrail = dtTrail;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getInputValReasonCodes() {
        return inputValReasonCodes;
    }

    public void setInputValReasonCodes(String inputValReasonCodes) {
        this.inputValReasonCodes = inputValReasonCodes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(String businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSolutionSetId() {
        return solutionSetId;
    }

    public void setSolutionSetId(String solutionSetId) {
        this.solutionSetId = solutionSetId;
    }

    public String getEnvironmentTypeId() {
        return environmentTypeId;
    }

    public void setEnvironmentTypeId(String environmentTypeId) {
        this.environmentTypeId = environmentTypeId;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

}