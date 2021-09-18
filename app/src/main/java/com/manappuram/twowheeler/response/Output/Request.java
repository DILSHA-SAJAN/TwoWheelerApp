package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("consumerDetails")
    @Expose
    private ConsumerDetails consumerDetails;

    public ConsumerDetails getConsumerDetails() {
        return consumerDetails;
    }

    public void setConsumerDetails(ConsumerDetails consumerDetails) {
        this.consumerDetails = consumerDetails;
    }

}