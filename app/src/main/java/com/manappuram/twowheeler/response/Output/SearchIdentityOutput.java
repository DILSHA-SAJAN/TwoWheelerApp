package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SearchIdentityOutput {


    @SerializedName("identityCount")
    @Expose
    private Integer identityCount;
    @SerializedName("status")
    @Expose
    private Status status;

    public Integer getIdentityCount() {
        return identityCount;
    }

    public void setIdentityCount(Integer identityCount) {
        this.identityCount = identityCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
