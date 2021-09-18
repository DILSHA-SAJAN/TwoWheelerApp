package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonStatusDescription {
    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("Description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public CommonStatusDescription() {
    }

    /**
     *
     * @param statusId
     * @param description
     */
    public CommonStatusDescription(Integer statusId, String description) {
        super();
        this.statusId = statusId;
        this.description = description;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return description;
    }
}
