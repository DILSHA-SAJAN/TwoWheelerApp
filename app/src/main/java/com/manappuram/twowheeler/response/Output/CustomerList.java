package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerList {


        @SerializedName("cust_id")
        @Expose
        private String custId;
        @SerializedName("cust_name")
        @Expose
        private String custName;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("gender_id")
        @Expose
        private String genderId;
        @SerializedName("gender")
        @Expose
        private String gender;


        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGenderId() {
            return genderId;
        }

        public void setGenderId(String genderId) {
            this.genderId = genderId;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }



}
