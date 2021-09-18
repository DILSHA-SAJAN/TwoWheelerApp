package com.manappuram.twowheeler.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CibilResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("apiStatus")
    private String apiStatus;
    @SerializedName("responseMsg")
    private String responseMsg;
    @SerializedName("data")
    private Data data;
//constructor

    public CibilResponse(String status, String apiStatus, String responseMsg, Data data) {
        this.status = status;
        this.apiStatus = apiStatus;
        this.responseMsg = responseMsg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

//constructor





    public class Data {
        @SerializedName("response")
        private String response;
        @SerializedName("body")
        private Body body;
    }

    public class Body {
        @SerializedName("downloadDocumentResponse")
        private DownloadDocumentResponse downloadDocumentResponse;
        @SerializedName("cibilApplicationNoResponse")
        private CibilApplicationNoResponse cibilApplicationNoResponse;
    }

    public class DownloadDocumentResponse {
        @SerializedName("xmlns")
        private String xmlns;
        @SerializedName("downloadDocumentResult")
        private DownloadDocumentResult downloadDocumentResult;

    }
    public class DownloadDocumentResult {
        @SerializedName("xmlnsa")
        private String xmlnsa;
        @SerializedName("xmlnsi")
        private String xmlnsi;
        @SerializedName("fileContents")
        private ArrayList<String> fileContents;
        @SerializedName("fileContent")
        private String fileContent;
        @SerializedName("aResponse")
        private AResponse aResponse;

    }
    public class AResponse {
        @SerializedName("dcResponse")
        private DcResponse dcResponse;
    }

    public class DcResponse {

        @SerializedName("status")
        private String status;
        @SerializedName("authentication")
        private Authentication authentication;
    }
    public class Authentication {
        @SerializedName("status")
        private String status;
        @SerializedName("token")
        private String token;
        @SerializedName("responseInfo")
        private ResponseInfo responseInfo;
    }
    public class ResponseInfo {
    }

    public class CibilApplicationNoResponse {
        @SerializedName("status")
        private String status;
        @SerializedName("apiStatus")
        private String apiStatus;
        @SerializedName("responseMsg")
        private String responseMsg;
        @SerializedName("data")
        private Datas data;
    }



    public class Datas {
    }


}

