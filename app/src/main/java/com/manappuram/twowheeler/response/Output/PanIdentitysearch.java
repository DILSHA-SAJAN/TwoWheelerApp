package com.manappuram.twowheeler.response.Output;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class PanIdentitysearch {

    @SerializedName("panCount")
    @Expose
    private Integer panCount;

    public Integer getPanCount() {
        return panCount;
    }

    public void setPanCount(Integer panCount) {
        this.panCount = panCount;
    }

}