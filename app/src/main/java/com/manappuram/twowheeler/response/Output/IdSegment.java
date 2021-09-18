package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdSegment {

    @SerializedName("Length")
    @Expose
    private String length;
    @SerializedName("SegmentTag")
    @Expose
    private String segmentTag;
    @SerializedName("IDType")
    @Expose
    private String iDType;
    @SerializedName("IDNumberFieldLength")
    @Expose
    private String iDNumberFieldLength;
    @SerializedName("IDNumber")
    @Expose
    private String iDNumber;
    @SerializedName("EnrichedThroughEnquiry")
    @Expose
    private String enrichedThroughEnquiry;

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

    public String getIDType() {
        return iDType;
    }

    public void setIDType(String iDType) {
        this.iDType = iDType;
    }

    public String getIDNumberFieldLength() {
        return iDNumberFieldLength;
    }

    public void setIDNumberFieldLength(String iDNumberFieldLength) {
        this.iDNumberFieldLength = iDNumberFieldLength;
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public String getEnrichedThroughEnquiry() {
        return enrichedThroughEnquiry;
    }

    public void setEnrichedThroughEnquiry(String enrichedThroughEnquiry) {
        this.enrichedThroughEnquiry = enrichedThroughEnquiry;
    }

}