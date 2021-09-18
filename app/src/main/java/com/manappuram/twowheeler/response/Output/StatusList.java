package com.manappuram.twowheeler.response.Output;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusList {

    @SerializedName("statusId")
    @Expose
    private Integer statusId;
    @SerializedName("Description")
    @Expose
    private String description;

    public StatusList(int statusId, String description) {
        this.description=description;
        this.statusId=statusId;

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

    @NonNull
    @Override
    public String toString() {
        return description;
    }
}

