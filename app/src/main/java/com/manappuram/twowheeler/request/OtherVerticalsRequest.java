package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherVerticalsRequest {
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("empcode")
    @Expose
    private String empcode;


    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }
}
