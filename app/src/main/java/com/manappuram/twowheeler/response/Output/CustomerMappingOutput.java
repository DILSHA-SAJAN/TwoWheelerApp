package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerMappingOutput {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("iD_Type")
    @Expose
    private String iDType;
    @SerializedName("telephone_type")
    @Expose
    private String telephoneType;
    @SerializedName("address_categoty")
    @Expose
    private String addressCategoty;
    @SerializedName("residence_type")
    @Expose
    private String residenceType;
    @SerializedName("score_type")
    @Expose
    private String scoreType;
    @SerializedName("enquiry_purpose")
    @Expose
    private String enquiryPurpose;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pincode")
    @Expose
    private List<Pincode> pincode = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIDType() {
        return iDType;
    }

    public void setIDType(String iDType) {
        this.iDType = iDType;
    }

    public String getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }

    public String getAddressCategoty() {
        return addressCategoty;
    }

    public void setAddressCategoty(String addressCategoty) {
        this.addressCategoty = addressCategoty;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getEnquiryPurpose() {
        return enquiryPurpose;
    }

    public void setEnquiryPurpose(String enquiryPurpose) {
        this.enquiryPurpose = enquiryPurpose;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Pincode> getPincode() {
        return pincode;
    }

    public void setPincode(List<Pincode> pincode) {
        this.pincode = pincode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}