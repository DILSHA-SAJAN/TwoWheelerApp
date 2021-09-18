package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealerIDCreationRequest extends BaseRequest {
    @SerializedName("id_no")
    @Expose
    private String id_no;
    @SerializedName("mob")
    @Expose
    private String mob;
    @SerializedName("doc_seq")
    @Expose
    private String doc_seq;

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDoc_seq() {
        return doc_seq;
    }

    public void setDoc_seq(String doc_seq) {
        this.doc_seq = doc_seq;
    }
}
