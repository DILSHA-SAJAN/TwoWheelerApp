package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddDealerRequest {
    @SerializedName("flag")
    @Expose
    private String flag;

    @SerializedName("shop_name")
    @Expose
    private String shop_name;

    @SerializedName("owner_name")
    @Expose
    private String owner_name;


    @SerializedName("shop_gst")
    @Expose
    private String shop_gst;

    @SerializedName("pan_no")
    @Expose
    private String pan_no;

    @SerializedName("id_no")
    @Expose
    private String id_no;

    @SerializedName("id_type")
    @Expose
    private String id_type;

    @SerializedName("loc_name")
    @Expose
    private String loc_name;

    @SerializedName("post_office")
    @Expose
    private String post_office;
    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("mob")
    @Expose
    private String mob;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("upload_by")
    @Expose
    private String upload_by;

    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }



    public String getShop_gst() {
        return shop_gst;
    }

    public void setShop_gst(String shop_gst) {
        this.shop_gst = shop_gst;
    }

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public String getPost_office() {
        return post_office;
    }

    public void setPost_office(String post_office) {
        this.post_office = post_office;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUpload_by() {
        return upload_by;
    }

    public void setUpload_by(String upload_by) {
        this.upload_by = upload_by;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
