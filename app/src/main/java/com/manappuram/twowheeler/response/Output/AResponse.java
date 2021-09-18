package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AResponse {

    @SerializedName("dcResponse")
    @Expose
    private DcResponse dcResponse;

    public DcResponse getDcResponse() {
        return dcResponse;
    }

    public void setDcResponse(DcResponse dcResponse) {
        this.dcResponse = dcResponse;
    }

}