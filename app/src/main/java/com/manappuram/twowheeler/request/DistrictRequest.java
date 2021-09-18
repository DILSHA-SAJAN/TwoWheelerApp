package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictRequest  extends BaseRequest{
    @SerializedName("state_id")
    @Expose
    private String state_id;

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }
}
