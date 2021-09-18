package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressList
    {

        @SerializedName("cust_id")
        @Expose
        private String custId;
        @SerializedName("address_Line1")
        @Expose
        private String addressLine1;
        @SerializedName("address_Line2")
        @Expose
        private String addressLine2;
        @SerializedName("address_Line3")
        @Expose
        private String addressLine3;
        @SerializedName("address_Line4")
        @Expose
        private String addressLine4;
        @SerializedName("address_Line5")
        @Expose
        private String addressLine5;
        @SerializedName("address_category")
        @Expose
        private String addressCategory;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("residence_type")
        @Expose
        private String residenceType;
        @SerializedName("state_code")
        @Expose
        private String stateCode;


        public String getCustId() {
        return custId;
    }

        public void setCustId(String custId) {
        this.custId = custId;
    }

        public String getAddressLine1() {
        return addressLine1;
    }

        public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

        public String getAddressLine2() {
        return addressLine2;
    }

        public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

        public String getAddressLine3() {
        return addressLine3;
    }

        public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

        public String getAddressLine4() {
        return addressLine4;
    }

        public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

        public String getAddressLine5() {
        return addressLine5;
    }

        public void setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }

        public String getAddressCategory() {
        return addressCategory;
    }

        public void setAddressCategory(String addressCategory) {
        this.addressCategory = addressCategory;
    }

        public String getCity() {
        return city;
    }

        public void setCity(String city) {
        this.city = city;
    }

        public String getPincode() {
        return pincode;
    }

        public void setPincode(String pincode) {
        this.pincode = pincode;
    }

        public String getResidenceType() {
        return residenceType;
    }

        public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

        public String getStateCode() {
        return stateCode;
    }

        public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


}
