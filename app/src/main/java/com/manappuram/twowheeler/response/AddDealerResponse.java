package com.manappuram.twowheeler.response;

import com.google.gson.annotations.SerializedName;

public class AddDealerResponse extends BaseResponse{
    @SerializedName("owner_name")
    private String owner_name;

    @SerializedName("MOB")
    private String MOB;

    @SerializedName("doc_sequence")
    private String doc_sequence;

    @SerializedName("ID_NO")
    private String ID_NO;

    public String getID_NO() {
        return ID_NO;
    }

    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getMOB() {
        return MOB;
    }

    public void setMOB(String MOB) {
        this.MOB = MOB;
    }

    public String getDoc_sequence() {
        return doc_sequence;
    }

    public void setDoc_sequence(String doc_sequence) {
        this.doc_sequence = doc_sequence;
    }
}
