package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TdsCategory {
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("description")
    @Expose
    private String description;

    public TdsCategory(Integer categoryId, String description) {
        super();
        this.categoryId = categoryId;
        this.description = description;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
