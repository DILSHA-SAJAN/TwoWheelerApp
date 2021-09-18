package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExecuteXMLStringResponse {

    @SerializedName("xmlns")
    @Expose
    private String xmlns;
    @SerializedName("executeXMLStringResult")
    @Expose
    private ExecuteXMLStringResult executeXMLStringResult;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public ExecuteXMLStringResult getExecuteXMLStringResult() {
        return executeXMLStringResult;
    }

    public void setExecuteXMLStringResult(ExecuteXMLStringResult executeXMLStringResult) {
        this.executeXMLStringResult = executeXMLStringResult;
    }

}