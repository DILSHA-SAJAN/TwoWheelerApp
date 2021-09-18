package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseStatus {
    @SerializedName("flag")
    @Expose
    private Integer flag;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("timeStamp")
    @Expose
    private String timeStamp;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseStatus() {
    }

    /**
     *
     * @param message
     * @param flag
     * @param timeStamp
     * @param code
     */
    public ResponseStatus(Integer flag, Integer code, String message, String timeStamp) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
