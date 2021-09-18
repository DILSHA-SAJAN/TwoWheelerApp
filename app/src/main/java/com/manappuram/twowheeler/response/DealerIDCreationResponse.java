package com.manappuram.twowheeler.response;

import com.google.gson.annotations.SerializedName;

public class DealerIDCreationResponse extends BaseResponse {
    @SerializedName("dealer_id")
    private String dealer_id;
    @SerializedName("password")
    private String password;

    public String getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(String dealer_id) {
        this.dealer_id = dealer_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
