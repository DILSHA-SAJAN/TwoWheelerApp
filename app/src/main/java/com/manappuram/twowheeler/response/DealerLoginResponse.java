package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DealerLoginResponse extends BaseResponse {
    @SerializedName("dealerDetails")
    @Expose
    public dealerDetails dealerDetails;

    public DealerLoginResponse.dealerDetails getDealerDetails() {
        return dealerDetails;
    }

    public void setDealerDetails(DealerLoginResponse.dealerDetails dealerDetails) {
        this.dealerDetails = dealerDetails;
    }

    public class dealerDetails implements Serializable {

        @SerializedName("dealerCode")
        @Expose
        public String dealerCode;
        @SerializedName("ownername")
        @Expose
        public String ownername;
        @SerializedName("password")
        @Expose
        public String password;
        @SerializedName("sessionid")
        @Expose
        public String sessionid;
        @SerializedName("shopname")
        @Expose
        public String shopname;
        @SerializedName("status")
        @Expose
        public String status;
        @SerializedName("loc_name")
        @Expose
        public String loc_name;
        @SerializedName("district")
        @Expose
        public String district;
        @SerializedName("state")
        @Expose
        public String state;

        public String getDealerCode() {
            return dealerCode;
        }

        public void setDealerCode(String dealerCode) {
            this.dealerCode = dealerCode;
        }

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSessionid() {
            return sessionid;
        }

        public void setSessionid(String sessionid) {
            this.sessionid = sessionid;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLoc_name() {
            return loc_name;
        }

        public void setLoc_name(String loc_name) {
            this.loc_name = loc_name;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

}
