package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassportDataOutput extends CommonOutput{
    @SerializedName("data")
    @Expose
    private PassportData data;

    /**
     * No args constructor for use in serialization
     *
     */
    public PassportDataOutput() {
    }

    /**
     *
     * @param data
     */
    public PassportDataOutput(PassportData data) {
        super();
        this.data = data;
    }

    public PassportData getData() {
        return data;
    }

    public void setData(PassportData data) {
        this.data = data;
    }

}
