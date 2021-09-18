package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DcResponse_ {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("authentication")
    @Expose
    private Authentication_ authentication;
    @SerializedName("responseInfo")
    @Expose
    private ResponseInfo_ responseInfo;
    @SerializedName("contextData")
    @Expose
    private ContextData contextData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Authentication_ getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication_ authentication) {
        this.authentication = authentication;
    }

    public ResponseInfo_ getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo_ responseInfo) {
        this.responseInfo = responseInfo;
    }

    public ContextData getContextData() {
        return contextData;
    }

    public void setContextData(ContextData contextData) {
        this.contextData = contextData;
    }

}