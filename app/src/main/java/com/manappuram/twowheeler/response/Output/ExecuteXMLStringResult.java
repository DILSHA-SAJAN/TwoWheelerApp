package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExecuteXMLStringResult {

    @SerializedName("dcResponse")
    @Expose
    private DcResponse_ dcResponse;

    public DcResponse_ getDcResponse() {
        return dcResponse;
    }

    public void setDcResponse(DcResponse_ dcResponse) {
        this.dcResponse = dcResponse;
    }

}