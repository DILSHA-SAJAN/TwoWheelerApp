package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoterIdOutput extends CommonOutput{
    @SerializedName("data")
    @Expose
    private VoterIdData data;

    /**
     * No args constructor for use in serialization
     *
     */
    public VoterIdOutput() {
    }

    /**
     *
     * @param data
     */
    public VoterIdOutput(VoterIdData data) {
        super();
        this.data = data;
    }

    public VoterIdData getData() {
        return data;
    }

    public void setData(VoterIdData data) {
        this.data = data;
    }

}
