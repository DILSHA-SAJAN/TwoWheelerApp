package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class StateResponse extends BaseResponse{
    @SerializedName("StateList")
    @Expose
    public ArrayList<StateList> StateList = null;

    public ArrayList<StateList> getStateList() {
        return StateList;
    }

    public void setStateList(ArrayList<StateList> stateList) {
        StateList = stateList;
    }

    public class StateList implements Serializable {

        @SerializedName("stateId")
        @Expose
        public String stateId;
        @SerializedName("stateName")
        @Expose
        public String stateName;
        @SerializedName("district_name")
        @Expose
        public String district_name;
        @SerializedName("district_id")
        @Expose
        public String district_id;
        @SerializedName("cibil_state")
        @Expose
        public String cibil_state;

        @SerializedName("pinmin")
        @Expose
        public String pinmin;

        @SerializedName("pinmax")
        @Expose
        public String pinmax;

        public String getCibil_state() {
            return cibil_state;
        }

        public void setCibil_state(String cibil_state) {
            this.cibil_state = cibil_state;
        }

        public String getPinmin() {
            return pinmin;
        }

        public void setPinmin(String pinmin) {
            this.pinmin = pinmin;
        }

        public String getPinmax() {
            return pinmax;
        }

        public void setPinmax(String pinmax) {
            this.pinmax = pinmax;
        }

        public String getDistrict_id() {
            return district_id;
        }

        public void setDistrict_id(String district_id) {
            this.district_id = district_id;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public String getStateId() {
            return stateId;
        }

        public void setStateId(String stateId) {
            this.stateId = stateId;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }
}
