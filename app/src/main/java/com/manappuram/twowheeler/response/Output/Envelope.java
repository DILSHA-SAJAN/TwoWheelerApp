package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Envelope {

    @SerializedName("xmlnss")
    @Expose
    private String xmlnss;
    @SerializedName("body")
    @Expose
    private Body_ body;

    public String getXmlnss() {
        return xmlnss;
    }

    public void setXmlnss(String xmlnss) {
        this.xmlnss = xmlnss;
    }

    public Body_ getBody() {
        return body;
    }

    public void setBody(Body_ body) {
        this.body = body;
    }

}