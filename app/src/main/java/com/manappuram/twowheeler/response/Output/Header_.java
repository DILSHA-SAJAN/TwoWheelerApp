package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header_ {

    @SerializedName("segmentTag")
    @Expose
    private String segmentTag;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("referenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("futureUse1")
    @Expose
    private String futureUse1;
    @SerializedName("memberCode")
    @Expose
    private String memberCode;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("futureUse2")
    @Expose
    private String futureUse2;
    @SerializedName("scoreType")
    @Expose
    private String scoreType;
    @SerializedName("outputFormat")
    @Expose
    private String outputFormat;
    @SerializedName("responseSize")
    @Expose
    private String responseSize;
    @SerializedName("mediaType")
    @Expose
    private String mediaType;
    @SerializedName("authenticationMethod")
    @Expose
    private String authenticationMethod;

    public String getSegmentTag() {
        return segmentTag;
    }

    public void setSegmentTag(String segmentTag) {
        this.segmentTag = segmentTag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getFutureUse1() {
        return futureUse1;
    }

    public void setFutureUse1(String futureUse1) {
        this.futureUse1 = futureUse1;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getFutureUse2() {
        return futureUse2;
    }

    public void setFutureUse2(String futureUse2) {
        this.futureUse2 = futureUse2;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(String responseSize) {
        this.responseSize = responseSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

}