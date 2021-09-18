package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibilBureauResponse {

    @SerializedName("bureauResponseRaw")
    @Expose
    private String bureauResponseRaw;
    @SerializedName("bureauResponseXml")
    @Expose
    private BureauResponseXml bureauResponseXml;
    @SerializedName("secondaryReportXml")
    @Expose
    private SecondaryReportXml secondaryReportXml;
    @SerializedName("isSucess")
    @Expose
    private String isSucess;

    public String getBureauResponseRaw() {
        return bureauResponseRaw;
    }

    public void setBureauResponseRaw(String bureauResponseRaw) {
        this.bureauResponseRaw = bureauResponseRaw;
    }

    public BureauResponseXml getBureauResponseXml() {
        return bureauResponseXml;
    }

    public void setBureauResponseXml(BureauResponseXml bureauResponseXml) {
        this.bureauResponseXml = bureauResponseXml;
    }

    public SecondaryReportXml getSecondaryReportXml() {
        return secondaryReportXml;
    }

    public void setSecondaryReportXml(SecondaryReportXml secondaryReportXml) {
        this.secondaryReportXml = secondaryReportXml;
    }

    public String getIsSucess() {
        return isSucess;
    }

    public void setIsSucess(String isSucess) {
        this.isSucess = isSucess;
    }

}