package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassportData {
    @SerializedName("string2")
    @Expose
    private String string2;
    @SerializedName("string1")
    @Expose
    private String string1;

    /**
     * No args constructor for use in serialization
     *
     */
    public PassportData() {
    }

    /**
     *
     * @param string2
     * @param string1
     */
    public PassportData(String string2, String string1) {
        super();
        this.string2 = string2;
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

}
