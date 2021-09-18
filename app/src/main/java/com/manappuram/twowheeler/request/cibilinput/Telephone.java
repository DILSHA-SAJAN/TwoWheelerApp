package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telephone {

    @SerializedName("telephoneExtension")
    @Expose
    private String telephoneExtension;
    @SerializedName("telephoneNumber")
    @Expose
    private String telephoneNumber;
    @SerializedName("telephoneType")
    @Expose
    private String telephoneType;

    public String getTelephoneExtension() {
        return telephoneExtension;
    }

    public void setTelephoneExtension(String telephoneExtension) {
        this.telephoneExtension = telephoneExtension;
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

}