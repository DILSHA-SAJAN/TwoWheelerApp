package com.manappuram.twowheeler.response.Output;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchCustomerContactOutput implements Parcelable {

    @SerializedName("customerid")
    @Expose
    private String customerid;
    @SerializedName("emailid")
    @Expose
    private String emailid;
    @SerializedName("phoneno")
    @Expose
    private String phoneno;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private String result;

    protected SearchCustomerContactOutput(Parcel in) {
        customerid = in.readString();
        emailid = in.readString();
        phoneno = in.readString();
        status = in.readString();
        result = in.readString();
    }

    public static final Creator<SearchCustomerContactOutput> CREATOR = new Creator<SearchCustomerContactOutput>() {
        @Override
        public SearchCustomerContactOutput createFromParcel(Parcel in) {
            return new SearchCustomerContactOutput(in);
        }

        @Override
        public SearchCustomerContactOutput[] newArray(int size) {
            return new SearchCustomerContactOutput[size];
        }
    };

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerid);
        dest.writeString(emailid);
        dest.writeString(phoneno);
        dest.writeString(status);
        dest.writeString(result);
    }
}
