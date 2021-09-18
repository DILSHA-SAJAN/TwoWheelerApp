package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class TenureResponse extends BaseResponse{

    @SerializedName("tenureList")
    @Expose
    ArrayList<tenureList> tenureList = null;

    public ArrayList<TenureResponse.tenureList> getTenureList() {
        return tenureList;
    }

    public void setTenureList(ArrayList<TenureResponse.tenureList> tenureList) {
        this.tenureList = tenureList;
    }

    public class tenureList implements Serializable {

        @SerializedName("tenureId")
        @Expose
        public String tenureId;

        @SerializedName("tenure")
        @Expose
        public String tenure;

        public String getTenureId() {
            return tenureId;
        }

        public void setTenureId(String tenureId) {
            this.tenureId = tenureId;
        }

        public String getTenure() {
            return tenure;
        }

        public void setTenure(String tenure) {
            this.tenure = tenure;
        }


    }
}
