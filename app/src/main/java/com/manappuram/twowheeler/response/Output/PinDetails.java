package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PinDetails {
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("stateId")
    @Expose
    private String stateId;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("districtId")
    @Expose
    private String districtId;
    @SerializedName("districtName")
    @Expose
    private String districtName;
    @SerializedName("pinCode")
    @Expose
    private Integer pinCode;
    @SerializedName("postofficeId")
    @Expose
    private String postofficeId;
    @SerializedName("postOffice")
    @Expose
    private String postOffice;

    /**
     * No args constructor for use in serialization
     *
     */
    public PinDetails() {
    }

    /**
     *
     * @param countryId
     * @param pinCode
     * @param districtName
     * @param countryName
     * @param postOffice
     * @param postofficeId
     * @param districtId
     * @param stateId
     * @param stateName
     */
    public PinDetails(String countryId, String countryName, String stateId, String stateName, String districtId, String districtName, Integer pinCode, String postofficeId, String postOffice) {
        super();
        this.countryId = countryId;
        this.countryName = countryName;
        this.stateId = stateId;
        this.stateName = stateName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.pinCode = pinCode;
        this.postofficeId = postofficeId;
        this.postOffice = postOffice;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getPostofficeId() {
        return postofficeId;
    }

    public void setPostofficeId(String postofficeId) {
        this.postofficeId = postofficeId;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }


    @Override
    public String toString() {
        return postOffice;
    }
}
