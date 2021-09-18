package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DsCibilBureau {

    @SerializedName("dsCibilBureauData")
    @Expose
    private DsCibilBureauData dsCibilBureauData;
    @SerializedName("dsCibilBureauStatus")
    @Expose
    private DsCibilBureauStatus dsCibilBureauStatus;
    @SerializedName("response")
    @Expose
    private Response response;

    public DsCibilBureauData getDsCibilBureauData() {
        return dsCibilBureauData;
    }

    public void setDsCibilBureauData(DsCibilBureauData dsCibilBureauData) {
        this.dsCibilBureauData = dsCibilBureauData;
    }

    public DsCibilBureauStatus getDsCibilBureauStatus() {
        return dsCibilBureauStatus;
    }

    public void setDsCibilBureauStatus(DsCibilBureauStatus dsCibilBureauStatus) {
        this.dsCibilBureauStatus = dsCibilBureauStatus;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}