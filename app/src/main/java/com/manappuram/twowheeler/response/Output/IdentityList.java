package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdentityList {
    @SerializedName("cust_id")
    @Expose
    private String custId;
    @SerializedName("id_number")
    @Expose
    private String idNumber;
    @SerializedName("identity_id")
    @Expose
    private String identityId;
    @SerializedName("identitY_NAME")
    @Expose
    private String identitYNAME;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getIdentitYNAME() {
        return identitYNAME;
    }

    public void setIdentitYNAME(String identitYNAME) {
        this.identitYNAME = identitYNAME;
    }
}
