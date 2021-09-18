package com.manappuram.twowheeler.request.cibilinput;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibilScoreInput implements Parcelable {

    @SerializedName("fields")
    @Expose
    private Fields fields;
    public CibilScoreInput() {
    }
    protected CibilScoreInput(Parcel in) {
    }

    public static final Creator<CibilScoreInput> CREATOR = new Creator<CibilScoreInput>() {
        @Override
        public CibilScoreInput createFromParcel(Parcel in) {
            return new CibilScoreInput(in);
        }

        @Override
        public CibilScoreInput[] newArray(int size) {
            return new CibilScoreInput[size];
        }
    };

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}