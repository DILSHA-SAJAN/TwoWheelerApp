package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PinDetailsOutput {
    @SerializedName("detailsList")
    @Expose
    private List<PinDetails> detailsList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public PinDetailsOutput() {
    }

    /**
     *
     * @param status
     * @param detailsList
     */
    public PinDetailsOutput(List<PinDetails> detailsList, ResponseStatus status) {
        super();
        this.detailsList = detailsList;
        this.status = status;
    }

    public List<PinDetails> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<PinDetails> detailsList) {
        this.detailsList = detailsList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }


}
