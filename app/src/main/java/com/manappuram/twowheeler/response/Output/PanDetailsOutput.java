package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PanDetailsOutput extends CommonOutput{
    @SerializedName("data")
    @Expose
    private List<PanDetails> data;

    /**
     * No args constructor for use in serialization
     *
     */
    public PanDetailsOutput() {
    }

    /**
     *
     * @param data
     */
    public PanDetailsOutput(List<PanDetails> data) {
        super();
        this.data = data;
    }

    public List<PanDetails> getData() {
        return data;
    }

    public void setData(List<PanDetails> data) {
        this.data = data;
    }
}
