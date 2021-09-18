package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditReportInquiry {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("names")
    @Expose
    private Names names;
    @SerializedName("identifications")
    @Expose
    private Identifications identifications;
    @SerializedName("telephones")
    @Expose
    private Telephones_ telephones;
    @SerializedName("addresses")
    @Expose
    private Addresses_ addresses;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Names getNames() {
        return names;
    }

    public void setNames(Names names) {
        this.names = names;
    }

    public Identifications getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Identifications identifications) {
        this.identifications = identifications;
    }

    public Telephones_ getTelephones() {
        return telephones;
    }

    public void setTelephones(Telephones_ telephones) {
        this.telephones = telephones;
    }

    public Addresses_ getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses_ addresses) {
        this.addresses = addresses;
    }

}