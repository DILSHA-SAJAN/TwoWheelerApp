package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchCustomerResponse {

    @SerializedName("customerList")
    @Expose
    private List<CustomerList> customerList = null;
    @SerializedName("identityList")
    @Expose
    private List<IdentityList> identityList = null;
    @SerializedName("telephoneList")
    @Expose
    private List<TelephoneList> telephoneList = null;
    @SerializedName("addressList")
    @Expose
    private List<AddressList> addressList = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public List<CustomerList> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerList> customerList) {
        this.customerList = customerList;
    }

    public List<IdentityList> getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List<IdentityList> identityList) {
        this.identityList = identityList;
    }

    public List<TelephoneList> getTelephoneList() {
        return telephoneList;
    }

    public void setTelephoneList(List<TelephoneList> telephoneList) {
        this.telephoneList = telephoneList;
    }

    public List<AddressList> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressList> addressList) {
        this.addressList = addressList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
