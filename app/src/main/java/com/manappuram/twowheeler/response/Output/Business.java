package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Business {
    @SerializedName("occupationId")
    @Expose
    private Integer occupationId;
    @SerializedName("occupationName")
    @Expose
    private String occupationName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Business() {
    }

    /**
     *
     * @param occupationName
     * @param occupationId
     */
    public Business(Integer occupationId, String occupationName) {
        super();
        this.occupationId = occupationId;
        this.occupationName = occupationName;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }


    @Override
    public String toString() {
        return occupationName;
    }
}
