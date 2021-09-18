package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body {

    @SerializedName("downloadDocumentResponse")
    @Expose
    private DownloadDocumentResponse downloadDocumentResponse;

    public DownloadDocumentResponse getDownloadDocumentResponse() {
        return downloadDocumentResponse;
    }

    public void setDownloadDocumentResponse(DownloadDocumentResponse downloadDocumentResponse) {
        this.downloadDocumentResponse = downloadDocumentResponse;
    }

}