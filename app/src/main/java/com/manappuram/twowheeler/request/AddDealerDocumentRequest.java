package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddDealerDocumentRequest {
    @SerializedName("dealer")
    @Expose
    private String dealer;
    @SerializedName("doc_seq")
    @Expose
    private String doc_seq;

    @SerializedName("Questioncopy")
    @Expose
    private String Questioncopy;

    @SerializedName("pan_card")
    @Expose
    private String pan_card;
    @SerializedName("aadhar")
    @Expose
    private String aadhar;

    @SerializedName("bank_statement")
    @Expose
    private String bank_statement;

    @SerializedName("pledge_form")
    @Expose
    private String pledge_form;

    @SerializedName("agreement")
    @Expose
    private String agreement;
    @SerializedName("gold_backed")
    @Expose
    private String gold_backed;

    @SerializedName("upload_by")
    @Expose
    private String upload_by;

    @SerializedName("deal_mob")
    @Expose
    private String deal_mob;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDoc_seq() {
        return doc_seq;
    }

    public void setDoc_seq(String doc_seq) {
        this.doc_seq = doc_seq;
    }

    public String getDeal_mob() {
        return deal_mob;
    }

    public void setDeal_mob(String deal_mob) {
        this.deal_mob = deal_mob;
    }

    public String getGold_backed() {
        return gold_backed;
    }

    public void setGold_backed(String gold_backed) {
        this.gold_backed = gold_backed;
    }

    public String getUpload_by() {
        return upload_by;
    }

    public void setUpload_by(String upload_by) {
        this.upload_by = upload_by;
    }



    public String getQuestioncopy() {
        return Questioncopy;
    }

    public void setQuestioncopy(String questioncopy) {
        Questioncopy = questioncopy;
    }

    public String getPan_card() {
        return pan_card;
    }

    public void setPan_card(String pan_card) {
        this.pan_card = pan_card;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getBank_statement() {
        return bank_statement;
    }

    public void setBank_statement(String bank_statement) {
        this.bank_statement = bank_statement;
    }

    public String getPledge_form() {
        return pledge_form;
    }

    public void setPledge_form(String pledge_form) {
        this.pledge_form = pledge_form;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
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
}
