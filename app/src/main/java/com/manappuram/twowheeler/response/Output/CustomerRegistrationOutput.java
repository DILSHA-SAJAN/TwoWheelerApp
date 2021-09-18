package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerRegistrationOutput {
    @SerializedName("customerID")
    @Expose
    private String customerID;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public CustomerRegistrationOutput() {
    }

    /**
     *
     * @param status
     * @param customerID
     */
    public CustomerRegistrationOutput(String customerID, ResponseStatus status) {
        super();
        this.customerID = customerID;
        this.status = status;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
