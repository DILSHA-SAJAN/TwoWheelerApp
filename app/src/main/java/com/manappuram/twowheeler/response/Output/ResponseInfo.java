package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseInfo {

    @SerializedName("applicationId")
    @Expose
    private String applicationId;
    @SerializedName("solutionSetInstanceId")
    @Expose
    private String solutionSetInstanceId;
    @SerializedName("currentQueue")
    @Expose
    private String currentQueue;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSolutionSetInstanceId() {
        return solutionSetInstanceId;
    }

    public void setSolutionSetInstanceId(String solutionSetInstanceId) {
        this.solutionSetInstanceId = solutionSetInstanceId;
    }

    public String getCurrentQueue() {
        return currentQueue;
    }

    public void setCurrentQueue(String currentQueue) {
        this.currentQueue = currentQueue;
    }

}