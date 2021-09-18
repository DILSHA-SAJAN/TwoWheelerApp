package com.manappuram.twowheeler.request.cibilinput;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Identifiers {

    @SerializedName("identifier")
    @Expose
    private List<Identifier> identifier = null;

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

}