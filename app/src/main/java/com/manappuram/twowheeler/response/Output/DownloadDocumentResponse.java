package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadDocumentResponse {

    @SerializedName("xmlns")
    @Expose
    private String xmlns;
    @SerializedName("downloadDocumentResult")
    @Expose
    private DownloadDocumentResult downloadDocumentResult;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public DownloadDocumentResult getDownloadDocumentResult() {
        return downloadDocumentResult;
    }

    public void setDownloadDocumentResult(DownloadDocumentResult downloadDocumentResult) {
        this.downloadDocumentResult = downloadDocumentResult;
    }

}