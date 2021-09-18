package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Religions {
    @SerializedName("religionId")
    @Expose
    private Integer religionId;
    @SerializedName("religion")
    @Expose
    private String religion;

    /**
     * No args constructor for use in serialization
     *
     */
    public Religions() {
    }

    /**
     *
     * @param religion
     * @param religionId
     */
    public Religions(Integer religionId, String religion) {
        super();
        this.religionId = religionId;
        this.religion = religion;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }


    @Override
    public String toString() {
        return religion;
    }
}
