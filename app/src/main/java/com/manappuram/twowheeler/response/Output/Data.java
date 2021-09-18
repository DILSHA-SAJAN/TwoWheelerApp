package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("body")
    @Expose
    private Body body;
    @SerializedName("cibilApplicationNoResponse")
    @Expose
    private CibilApplicationNoResponse cibilApplicationNoResponse;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public CibilApplicationNoResponse getCibilApplicationNoResponse() {
        return cibilApplicationNoResponse;
    }

    public void setCibilApplicationNoResponse(CibilApplicationNoResponse cibilApplicationNoResponse) {
        this.cibilApplicationNoResponse = cibilApplicationNoResponse;
    }

}
