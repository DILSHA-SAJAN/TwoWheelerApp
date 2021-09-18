package com.manappuram.twowheeler.response.Output;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CibilScoreOutput  implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("apiStatus")
    @Expose
    private String apiStatus;
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("errorList")
    @Expose
    private List<ErrorList_> errorList = null;

    protected CibilScoreOutput(Parcel in) {
        status = in.readString();
        apiStatus = in.readString();
        responseMsg = in.readString();
    }

    public static final Creator<CibilScoreOutput> CREATOR = new Creator<CibilScoreOutput>() {
        @Override
        public CibilScoreOutput createFromParcel(Parcel in) {
            return new CibilScoreOutput(in);
        }

        @Override
        public CibilScoreOutput[] newArray(int size) {
            return new CibilScoreOutput[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<ErrorList_> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorList_> errorList) {
        this.errorList = errorList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(apiStatus);
        dest.writeString(responseMsg);
    }
}