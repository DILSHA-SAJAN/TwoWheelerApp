package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Field {

    @SerializedName("applicants")
    @Expose
    private Applicants applicants;
    @SerializedName("applicationData")
    @Expose
    private ApplicationData applicationData;

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

}