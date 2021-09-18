package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCibilDataOutput {

    @SerializedName("cibilData")
    @Expose
    private List<CibilDatum> cibilData = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public List<CibilDatum> getCibilData() {
        return cibilData;
    }

    public void setCibilData(List<CibilDatum> cibilData) {
        this.cibilData = cibilData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}