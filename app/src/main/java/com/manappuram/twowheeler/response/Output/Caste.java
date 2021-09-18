package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Caste {
    @SerializedName("casteId")
    @Expose
    private Integer casteId;
    @SerializedName("religionId")
    @Expose
    private Integer religionId;
    @SerializedName("casteName")
    @Expose
    private String casteName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Caste() {
    }

    /**
     *
     * @param casteName
     * @param religionId
     * @param casteId
     */
    public Caste(Integer casteId, Integer religionId, String casteName) {
        super();
        this.casteId = casteId;
        this.religionId = religionId;
        this.casteName = casteName;
    }

    public Integer getCasteId() {
        return casteId;
    }

    public void setCasteId(Integer casteId) {
        this.casteId = casteId;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public String getCasteName() {
        return casteName;
    }

    public void setCasteName(String casteName) {
        this.casteName = casteName;
    }

    @Override
    public String toString() {
        return casteName;
    }
}
