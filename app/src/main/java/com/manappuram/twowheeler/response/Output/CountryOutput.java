package com.manappuram.twowheeler.response.Output;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryOutput implements Parcelable {
    @SerializedName("countriesList")
    @Expose
    private List<Country> countriesList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public CountryOutput() {
    }

    /**
     *
     * @param status
     * @param countriesList
     */
    public CountryOutput(List<Country> countriesList, ResponseStatus status) {
        super();
        this.countriesList = countriesList;
        this.status = status;
    }

    protected CountryOutput(Parcel in) {
    }

    public static final Creator<CountryOutput> CREATOR = new Creator<CountryOutput>() {
        @Override
        public CountryOutput createFromParcel(Parcel in) {
            return new CountryOutput(in);
        }

        @Override
        public CountryOutput[] newArray(int size) {
            return new CountryOutput[size];
        }
    };

    public List<Country> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Country> countriesList) {
        this.countriesList = countriesList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
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
