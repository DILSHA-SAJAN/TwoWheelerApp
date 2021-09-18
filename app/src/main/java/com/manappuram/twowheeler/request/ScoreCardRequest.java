package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ScoreCardRequest extends BaseRequest{

    @SerializedName("cust_id")
    @Expose
    private String custid;

    @SerializedName("scorestring")
    @Expose
    private String score_string;

    @SerializedName("total")
    @Expose
    private String total_score;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getScore_string() {
        return score_string;
    }

    public void setScore_string(String score_string) {
        this.score_string = score_string;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }
}
