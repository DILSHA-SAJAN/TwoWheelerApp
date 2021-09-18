package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Field {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("applicants")
    @Expose
    private Applicants applicants;
    @SerializedName("applicationData")
    @Expose
    private ApplicationData applicationData;
    @SerializedName("text")
    @Expose
    private String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Applicants getApplicants() {
        return applicants;
    }

    public void setApplicants(Applicants applicants) {
        this.applicants = applicants;
    }

    public ApplicationData getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(ApplicationData applicationData) {
        this.applicationData = applicationData;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}