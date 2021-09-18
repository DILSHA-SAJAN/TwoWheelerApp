package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body_ {

    @SerializedName("executeXMLStringResponse")
    @Expose
    private ExecuteXMLStringResponse executeXMLStringResponse;

    public ExecuteXMLStringResponse getExecuteXMLStringResponse() {
        return executeXMLStringResponse;
    }

    public void setExecuteXMLStringResponse(ExecuteXMLStringResponse executeXMLStringResponse) {
        this.executeXMLStringResponse = executeXMLStringResponse;
    }

}