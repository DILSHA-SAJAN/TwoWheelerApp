package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Applicants {

    @SerializedName("applicant")
    @Expose
    private List<Applicant> applicant = null;

    public List<Applicant> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<Applicant> applicant) {
        this.applicant = applicant;
    }

}