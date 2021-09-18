package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchingCustomersoutput {
    @SerializedName("matchingCustomers")
    @Expose
    private List<MatchingCustomer> matchingCustomers = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public List<MatchingCustomer> getMatchingCustomers() {
        return matchingCustomers;
    }

    public void setMatchingCustomers(List<MatchingCustomer> matchingCustomers) {
        this.matchingCustomers = matchingCustomers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
