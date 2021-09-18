package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TelephoneSegment {

    @SerializedName("Length")
    @Expose
    private String length;
    @SerializedName("SegmentTag")
    @Expose
    private String segmentTag;
    @SerializedName("TelephoneNumberFieldLength")
    @Expose
    private String telephoneNumberFieldLength;
    @SerializedName("TelephoneNumber")
    @Expose
    private String telephoneNumber;
    @SerializedName("TelephoneType")
    @Expose
    private String telephoneType;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getSegmentTag() {
        return segmentTag;
    }

    public void setSegmentTag(String segmentTag) {
        this.segmentTag = segmentTag;
    }

    public String getTelephoneNumberFieldLength() {
        return telephoneNumberFieldLength;
    }

    public void setTelephoneNumberFieldLength(String telephoneNumberFieldLength) {
        this.telephoneNumberFieldLength = telephoneNumberFieldLength;
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