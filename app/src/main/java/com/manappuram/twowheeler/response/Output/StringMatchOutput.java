package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StringMatchOutput {
    @SerializedName("matchPercentage")
    @Expose
    private Integer matchPercentage;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public StringMatchOutput() {
    }

    /**
     *
     * @param status
     * @param matchPercentage
     */
    public StringMatchOutput(Integer matchPercentage, ResponseStatus status) {
        super();
        this.matchPercentage = matchPercentage;
        this.status = status;
    }

    public Integer getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(Integer matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
