package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsumerDetails {

    @SerializedName("creditReportInquiry")
    @Expose
    private CreditReportInquiry creditReportInquiry;

    public CreditReportInquiry getCreditReportInquiry() {
        return creditReportInquiry;
    }

    public void setCreditReportInquiry(CreditReportInquiry creditReportInquiry) {
        this.creditReportInquiry = creditReportInquiry;
    }

}