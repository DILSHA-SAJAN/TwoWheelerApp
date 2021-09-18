package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("cibilBureauResponse")
    @Expose
    private CibilBureauResponse cibilBureauResponse;

    public CibilBureauResponse getCibilBureauResponse() {
        return cibilBureauResponse;
    }

    public void setCibilBureauResponse(CibilBureauResponse cibilBureauResponse) {
        this.cibilBureauResponse = cibilBureauResponse;
    }

}