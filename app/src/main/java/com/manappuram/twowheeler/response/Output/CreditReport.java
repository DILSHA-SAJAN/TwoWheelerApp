package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditReport {
//
//    @SerializedName("header")
//    @Expose
//    private Header_ header;
    @SerializedName("nameSegment")
    @Expose
    private NameSegment nameSegment;
//    @SerializedName("idSegment")
//    @Expose
//    private IdSegment idSegment;
//    @SerializedName("telephoneSegment")
//    @Expose
//    private List<TelephoneSegment> telephoneSegment;
    @SerializedName("scoreSegment")
    @Expose
    private ScoreSegment scoreSegment;
//    @SerializedName("address")
//    @Expose
//    private Address__ address;
//    @SerializedName("enquiry")
//    @Expose
//    private Enquiry enquiry;
//    @SerializedName("end")
//    @Expose
//    private End end;
//
//    public Header_ getHeader() {
//        return header;
//    }
//
//    public void setHeader(Header_ header) {
//        this.header = header;
//    }
//
    public NameSegment getNameSegment() {
        return nameSegment;
    }

    public void setNameSegment(NameSegment nameSegment) {
        this.nameSegment = nameSegment;
    }
//
//    public IdSegment getIdSegment() {
//        return idSegment;
//    }
//
//    public void setIdSegment(IdSegment idSegment) {
//        this.idSegment = idSegment;
//    }
//
//    public List<TelephoneSegment> getTelephoneSegment() {
//        return telephoneSegment;
//    }
//
//    public void setTelephoneSegment(List<TelephoneSegment> telephoneSegment) {
//        this.telephoneSegment = telephoneSegment;
//    }
//
    public ScoreSegment getScoreSegment() {
        return scoreSegment;
    }

    public void setScoreSegment(ScoreSegment scoreSegment) {
        this.scoreSegment = scoreSegment;
    }
//
//    public Address__ getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address__ address) {
//        this.address = address;
//    }
//
//    public Enquiry getEnquiry() {
//        return enquiry;
//    }
//
//    public void setEnquiry(Enquiry enquiry) {
//        this.enquiry = enquiry;
//    }
//
//    public End getEnd() {
//        return end;
//    }
//
//    public void setEnd(End end) {
//        this.end = end;
//    }

}