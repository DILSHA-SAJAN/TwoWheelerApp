package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCustDocumentRequest {
    @SerializedName("cust_name")
    @Expose
    private String cust_name;

    @SerializedName("doc_seq")
    @Expose
    private String doc_seq;

    @SerializedName("Questioncopy")
    @Expose
    private String Questioncopy;

    @SerializedName("pan_no")
    @Expose
    private String pan_no;
    @SerializedName("PanCopy")
    @Expose
    private String PanCopy;

    @SerializedName("bankstatement")
    @Expose
    private String bank_statement;


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("upload_by")
    @Expose
    private String upload_by;

    @SerializedName("cust_mob")
    @Expose
    private String cust_mob;

    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    public String getDoc_seq() {
        return doc_seq;
    }

    public void setDoc_seq(String doc_seq) {
        this.doc_seq = doc_seq;
    }

    public String getCust_mob() {
        return cust_mob;
    }

    public void setCust_mob(String cust_mob) {
        this.cust_mob = cust_mob;
    }

    public String getUpload_by() {
        return upload_by;
    }

    public void setUpload_by(String upload_by) {
        this.upload_by = upload_by;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getQuestioncopy() {
        return Questioncopy;
    }

    public void setQuestioncopy(String questioncopy) {
        Questioncopy = questioncopy;
    }

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getPanCopy() {
        return PanCopy;
    }

    public void setPanCopy(String panCopy) {
        PanCopy = panCopy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getBank_statement() {
        return bank_statement;
    }

    public void setBank_statement(String bank_statement) {
        this.bank_statement = bank_statement;
    }
}
