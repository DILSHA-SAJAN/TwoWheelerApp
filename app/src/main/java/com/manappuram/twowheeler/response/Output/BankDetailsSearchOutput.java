package com.manappuram.twowheeler.response.Output;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class BankDetailsSearchOutput {

    @SerializedName("accountcount")
    @Expose
    private Integer accountcount;

    public Integer getAccountcount() {
        return accountcount;
    }

    public void setAccountcount(Integer accountcount) {
        this.accountcount = accountcount;
    }

}