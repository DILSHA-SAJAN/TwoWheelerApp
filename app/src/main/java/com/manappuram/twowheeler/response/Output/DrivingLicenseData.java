package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrivingLicenseData {



    @SerializedName("dlNumber")
    @Expose
    private String dlNumber;
    @SerializedName("issue_date")
    @Expose
    private String issueDate;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("father/husband")
    @Expose
    private String fatherHusband;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("endorse_dt")
    @Expose
    private String endorseDt;
    @SerializedName("endorse_no")
    @Expose
    private String endorseNo;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusDetails")
    @Expose
    private StatusDetails statusDetails;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("validity")
    @Expose
    private DrivingLicenseValidity validity;
    @SerializedName("cov_details")
    @Expose
    private List<DrivingLicenseCOVDetails> covDetails = null;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFatherHusband() {
        return fatherHusband;
    }

    public void setFatherHusband(String fatherHusband) {
        this.fatherHusband = fatherHusband;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEndorseDt() {
        return endorseDt;
    }

    public void setEndorseDt(String endorseDt) {
        this.endorseDt = endorseDt;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusDetails getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(StatusDetails statusDetails) {
        this.statusDetails = statusDetails;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public DrivingLicenseValidity getValidity() {
        return validity;
    }

    public void setValidity(DrivingLicenseValidity validity) {
        this.validity = validity;
    }

    public List<DrivingLicenseCOVDetails> getCovDetails() {
        return covDetails;
    }

    public void setCovDetails(List<DrivingLicenseCOVDetails> covDetails) {
        this.covDetails = covDetails;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

}