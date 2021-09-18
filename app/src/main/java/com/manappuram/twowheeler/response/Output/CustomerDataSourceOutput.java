package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerDataSourceOutput {


    @SerializedName("sourceList")
    @Expose
    private List<SourceList> sourceList = null;
    @SerializedName("tdsCategory")
    @Expose
    private List<TdsCategory> tdsCategory = null;
    @SerializedName("status")
    @Expose
    private Status status;

    public List<SourceList> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<SourceList> sourceList) {
        this.sourceList = sourceList;
    }

    public List<TdsCategory> getTdsCategory() {
        return tdsCategory;
    }

    public void setTdsCategory(List<TdsCategory> tdsCategory) {
        this.tdsCategory = tdsCategory;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
