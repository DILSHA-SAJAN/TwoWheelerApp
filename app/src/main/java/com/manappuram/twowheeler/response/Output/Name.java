package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("consumerName1")
    @Expose
    private String consumerName1;
    @SerializedName("consumerName2")
    @Expose
    private String consumerName2;
    @SerializedName("consumerName3")
    @Expose
    private String consumerName3;
    @SerializedName("consumerName4")
    @Expose
    private String consumerName4;
    @SerializedName("consumerName5")
    @Expose
    private String consumerName5;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("gender")
    @Expose
    private String gender;

    public String getConsumerName1() {
        return consumerName1;
    }

    public void setConsumerName1(String consumerName1) {
        this.consumerName1 = consumerName1;
    }

    public String getConsumerName2() {
        return consumerName2;
    }

    public void setConsumerName2(String consumerName2) {
        this.consumerName2 = consumerName2;
    }

    public String getConsumerName3() {
        return consumerName3;
    }

    public void setConsumerName3(String consumerName3) {
        this.consumerName3 = consumerName3;
    }

    public String getConsumerName4() {
        return consumerName4;
    }

    public void setConsumerName4(String consumerName4) {
        this.consumerName4 = consumerName4;
    }

    public String getConsumerName5() {
        return consumerName5;
    }

    public void setConsumerName5(String consumerName5) {
        this.consumerName5 = consumerName5;
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

}