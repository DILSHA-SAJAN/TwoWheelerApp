package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreName {
    @SerializedName("preNameId")
    @Expose
    private Integer preNameId;
    @SerializedName("preName")
    @Expose
    private String preName;
    @SerializedName("gender")
    @Expose
    private Integer gender;

    /**
     * No args constructor for use in serialization
     *
     */
    public PreName() {
    }

    /**
     *
     * @param preName
     * @param gender
     * @param preNameId
     */
    public PreName(Integer preNameId, String preName, Integer gender) {
        super();
        this.preNameId = preNameId;
        this.preName = preName;
        this.gender = gender;
    }

    public Integer getPreNameId() {
        return preNameId;
    }

    public void setPreNameId(Integer preNameId) {
        this.preNameId = preNameId;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return preName;
    }
}
