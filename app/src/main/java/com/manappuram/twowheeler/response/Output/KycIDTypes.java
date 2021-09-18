package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KycIDTypes {

    @SerializedName("KYCIDType")
    @Expose
    private  Integer KYCIDType;

    @SerializedName("Name")
    @Expose
    private  String Name;

    public KycIDTypes(Integer KYCIDType, String name) {
        this.KYCIDType = KYCIDType;
        this.Name = name;
    }

    public Integer getKYCIDType() {
        return KYCIDType;
    }

    public void setKYCIDType(Integer KYCIDType) {
        this.KYCIDType = KYCIDType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public String toString() {
        return Name;
    }
}
