package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DistrictResponse extends BaseResponse{
    @SerializedName("DistrictList")
    @Expose
    public ArrayList<DistrictList> DistrictList = null;

    public ArrayList<DistrictResponse.DistrictList> getDistrictList() {
        return DistrictList;
    }

    public void setDistrictList(ArrayList<DistrictResponse.DistrictList> districtList) {
        DistrictList = districtList;
    }

    public class DistrictList implements Serializable {

        @SerializedName("districtId")
        @Expose
        public String districtId;
        @SerializedName("districtName")
        @Expose
        public String districtName;

        public String getDistrictId() {
            return districtId;
        }

        public void setDistrictId(String districtId) {
            this.districtId = districtId;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }
    }
}
