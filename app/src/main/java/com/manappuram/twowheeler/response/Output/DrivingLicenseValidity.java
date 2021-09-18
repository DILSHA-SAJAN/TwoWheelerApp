package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrivingLicenseValidity {

    @SerializedName("nontransport")
    @Expose
    private Nontransport nontransport;
    @SerializedName("transport")
    @Expose
    private Transport transport;

    public Nontransport getNontransport() {
        return nontransport;
    }

    public void setNontransport(Nontransport nontransport) {
        this.nontransport = nontransport;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}