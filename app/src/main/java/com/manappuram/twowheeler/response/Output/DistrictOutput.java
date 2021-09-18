package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistrictOutput {
    @SerializedName("districtsList")
    @Expose
    private List<District> districtsList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public DistrictOutput() {
    }

    /**
     *
     * @param status
     * @param districtsList
     */
    public DistrictOutput(List<District> districtsList, ResponseStatus status) {
        super();
        this.districtsList = districtsList;
        this.status = status;
    }

    public List<District> getDistrictsList() {
        return districtsList;
    }

    public void setDistrictsList(List<District> districtsList) {
        this.districtsList = districtsList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
