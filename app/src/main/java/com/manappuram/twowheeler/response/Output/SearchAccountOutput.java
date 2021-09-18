package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchAccountOutput {

    @SerializedName("flag")
    @Expose
    private Integer flag;
    @SerializedName("bankDatas")
    @Expose
    private List<SearchAccount> bankDatas = null;

    /**
     * No args constructor for use in serialization
     */
    public SearchAccountOutput() {
    }

    /**
     * @param flag
     * @param bankDatas
     */
    public SearchAccountOutput(Integer flag, List<SearchAccount> bankDatas) {
        super();
        this.flag = flag;
        this.bankDatas = bankDatas;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<SearchAccount> getBankDatas() {
        return bankDatas;
    }

    public void setBankDatas(List<SearchAccount> bankDatas) {
        this.bankDatas = bankDatas;
    }
}
