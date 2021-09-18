package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DownloadDocumentResult {

    @SerializedName("xmlnsa")
    @Expose
    private String xmlnsa;
    @SerializedName("xmlnsi")
    @Expose
    private String xmlnsi;
    @SerializedName("fileContents")
    @Expose
    private List<String> fileContents = null;
    @SerializedName("fileContent")
    @Expose
    private String fileContent;
    @SerializedName("aResponse")
    @Expose
    private AResponse aResponse;

    public String getXmlnsa() {
        return xmlnsa;
    }

    public void setXmlnsa(String xmlnsa) {
        this.xmlnsa = xmlnsa;
    }

    public String getXmlnsi() {
        return xmlnsi;
    }

    public void setXmlnsi(String xmlnsi) {
        this.xmlnsi = xmlnsi;
    }

    public List<String> getFileContents() {
        return fileContents;
    }

    public void setFileContents(List<String> fileContents) {
        this.fileContents = fileContents;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public AResponse getAResponse() {
        return aResponse;
    }

    public void setAResponse(AResponse aResponse) {
        this.aResponse = aResponse;
    }

}