package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateOutput {
    @SerializedName("statesList")
    @Expose
    private List<State> statesList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public StateOutput() {
    }

    /**
     *
     * @param status
     * @param statesList
     */
    public StateOutput(List<State> statesList, ResponseStatus status) {
        super();
        this.statesList = statesList;
        this.status = status;
    }

    public List<State> getStatesList() {
        return statesList;
    }

    public void setStatesList(List<State> statesList) {
        this.statesList = statesList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
