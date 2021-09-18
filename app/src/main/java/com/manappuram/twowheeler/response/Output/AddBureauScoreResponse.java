package com.manappuram.twowheeler.response.Output;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddBureauScoreResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private Status status;

    protected AddBureauScoreResponse(Parcel in) {
    }

    public static final Creator<AddBureauScoreResponse> CREATOR = new Creator<AddBureauScoreResponse>() {
        @Override
        public AddBureauScoreResponse createFromParcel(Parcel in) {
            return new AddBureauScoreResponse(in);
        }

        @Override
        public AddBureauScoreResponse[] newArray(int size) {
            return new AddBureauScoreResponse[size];
        }
    };

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
