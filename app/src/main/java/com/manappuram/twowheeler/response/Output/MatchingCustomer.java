package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchingCustomer {
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("custId")
    @Expose
    private String custId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone2")
    @Expose
    private String phone2;
    @SerializedName("fatHus")
    @Expose
    private String fatHus;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("idNumber")
    @Expose
    private String idNumber;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFatHus() {
        return fatHus;
    }

    public void setFatHus(String fatHus) {
        this.fatHus = fatHus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}