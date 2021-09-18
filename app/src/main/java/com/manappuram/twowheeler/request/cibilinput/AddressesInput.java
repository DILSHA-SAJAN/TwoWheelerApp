package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressesInput {

    @SerializedName("address")
    @Expose
    private List<AddressInput> address = null;

    public List<AddressInput> getAddress() {
        return address;
    }

    public void setAddress(List<AddressInput> address) {
        this.address = address;
    }

}