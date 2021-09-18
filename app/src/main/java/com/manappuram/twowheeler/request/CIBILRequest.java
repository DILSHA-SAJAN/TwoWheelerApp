package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CIBILRequest {
    @SerializedName("applicantType")
    @Expose
    private String applicantType;
    @SerializedName("applicantFirstName")
    @Expose
    private String applicantFirstName;
    @SerializedName("applicantLastName")
    @Expose
    private String applicantLastName;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("gender")
    @Expose
    private String gender ;
    @SerializedName("idNumber")
    @Expose
    private String idNumber;
    @SerializedName("idType")
    @Expose
    private String idType;
    @SerializedName("telephoneNumber")
    @Expose
    private String telephoneNumber;
    @SerializedName("telephoneType")
    @Expose
    private String telephoneType;
    @SerializedName("addressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("addressLine2")
    @Expose
    private String addressLine2;
    @SerializedName("addressLine3")
    @Expose
    private String addressLine3;
    @SerializedName("city")
    @Expose
    private String city ;
    @SerializedName("pinCode")
    @Expose
    private String pinCode;
    @SerializedName("residenceType")
    @Expose
    private String residenceType;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("amount")
    @Expose
    private String amount ;
    @SerializedName("scoreType")
    @Expose
    private String scoreType;
    @SerializedName("gstStateCode")
    @Expose
    private String gstStateCode;
    @SerializedName("cibilBureauFlag")
    @Expose
    private String cibilBureauFlag;
    @SerializedName("idVerificationFlag")
    @Expose
    private String idVerificationFlag;

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getApplicantFirstName() {
        return applicantFirstName;
    }

    public void setApplicantFirstName(String applicantFirstName) {
        this.applicantFirstName = applicantFirstName;
    }

    public String getApplicantLastName() {
        return applicantLastName;
    }

    public void setApplicantLastName(String applicantLastName) {
        this.applicantLastName = applicantLastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
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

    public String getIdVerificationFlag() {
        return idVerificationFlag;
    }

    public void setIdVerificationFlag(String idVerificationFlag) {
        this.idVerificationFlag = idVerificationFlag;
    }
}
