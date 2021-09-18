package com.manappuram.twowheeler.response.Output;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibilDatum {

    @SerializedName("option_id")
    @Expose
    private Integer optionId;
    @SerializedName("status_id")
    @Expose
    private String statusId;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
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