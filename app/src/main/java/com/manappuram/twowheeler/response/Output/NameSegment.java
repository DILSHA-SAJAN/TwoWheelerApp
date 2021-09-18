package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameSegment {

    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("segmentTag")
    @Expose
    private String segmentTag;
    @SerializedName("consumerName1FieldLength")
    @Expose
    private String consumerName1FieldLength;
    @SerializedName("consumerName1")
    @Expose
    private String consumerName1;
    @SerializedName("consumerName2FieldLength")
    @Expose
    private String consumerName2FieldLength;
    @SerializedName("consumerName2")
    @Expose
    private String consumerName2;
    @SerializedName("consumerName3FieldLength")
    @Expose
    private String consumerName3FieldLength;
    @SerializedName("consumerName3")
    @Expose
    private String consumerName3;
    @SerializedName("dateOfBirthFieldLength")
    @Expose
    private String dateOfBirthFieldLength;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("genderFieldLength")
    @Expose
    private String genderFieldLength;
    @SerializedName("gender")
    @Expose
    private String gender;

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

    public String getConsumerName1FieldLength() {
        return consumerName1FieldLength;
    }

    public void setConsumerName1FieldLength(String consumerName1FieldLength) {
        this.consumerName1FieldLength = consumerName1FieldLength;
    }

    public String getConsumerName1() {
        return consumerName1;
    }

    public void setConsumerName1(String consumerName1) {
        this.consumerName1 = consumerName1;
    }

    public String getConsumerName2FieldLength() {
        return consumerName2FieldLength;
    }

    public void setConsumerName2FieldLength(String consumerName2FieldLength) {
        this.consumerName2FieldLength = consumerName2FieldLength;
    }

    public String getConsumerName2() {
        return consumerName2;
    }

    public void setConsumerName2(String consumerName2) {
        this.consumerName2 = consumerName2;
    }

    public String getConsumerName3FieldLength() {
        return consumerName3FieldLength;
    }

    public void setConsumerName3FieldLength(String consumerName3FieldLength) {
        this.consumerName3FieldLength = consumerName3FieldLength;
    }

    public String getConsumerName3() {
        return consumerName3;
    }

    public void setConsumerName3(String consumerName3) {
        this.consumerName3 = consumerName3;
    }

    public String getDateOfBirthFieldLength() {
        return dateOfBirthFieldLength;
    }

    public void setDateOfBirthFieldLength(String dateOfBirthFieldLength) {
        this.dateOfBirthFieldLength = dateOfBirthFieldLength;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGenderFieldLength() {
        return genderFieldLength;
    }

    public void setGenderFieldLength(String genderFieldLength) {
        this.genderFieldLength = genderFieldLength;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}