package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerStatusList {
    @SerializedName("typeId")
    @Expose
    private  Integer typeId;

    @SerializedName("customerStatus")
    @Expose
    private  String customerStatus;

    public CustomerStatusList(Integer typeId, String customerStatus) {
        this.typeId = typeId;
        this.customerStatus = customerStatus;
    }
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    @Override
    public String toString() {
        return customerStatus;
    }
}
