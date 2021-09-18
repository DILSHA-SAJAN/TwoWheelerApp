package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewDealerListResponse extends BaseResponse{
    @SerializedName("DealerList")
    @Expose
    public ArrayList<DealerList> DealerList = null;

    public ArrayList<ViewDealerListResponse.DealerList> getDealerList() {
        return DealerList;
    }

    public void setDealerList(ArrayList<ViewDealerListResponse.DealerList> dealerList) {
        DealerList = dealerList;
    }

    public class DealerList implements Serializable {

        @SerializedName("DEALER_ID")
        @Expose
        public String DEALER_ID;

        @SerializedName("SHOP_NAME")
        @Expose
        public String SHOP_NAME;

        @SerializedName("OWNER_NAME")
        @Expose
        public String OWNER_NAME;

        @SerializedName("SHOP_GST")
        @Expose
        public String SHOP_GST;

        @SerializedName("PAN_NO")
        @Expose
        public String PAN_NO;

        @SerializedName("ID_NO")
        @Expose
        public String ID_NO;



        @SerializedName("ID_TYPE")
        @Expose
        public String ID_TYPE;

        @SerializedName("LOC_NAME")
        @Expose
        public String LOC_NAME;

        @SerializedName("POST_OFFICE")
        @Expose
        public String POST_OFFICE;
        @SerializedName("DISTRICT")
        @Expose
        public String DISTRICT;

        @SerializedName("STATE")
        @Expose
        public String STATE;

        @SerializedName("PIN")
        @Expose
        public String PIN;
        @SerializedName("MOB")
        @Expose
        public String MOB;

        @SerializedName("EMAIL")
        @Expose
        public String EMAIL;

        @SerializedName("ADDED_DATE")
        @Expose
        public String ADDED_DATE;

        //checked

        @SerializedName("UPLOAD_BY")
        @Expose
        public String UPLOAD_BY;

        @SerializedName("pan_docname")
        @Expose
        public String pan_docname;

        @SerializedName("quest_docname")
        @Expose
        public String quest_docname;

        @SerializedName("aadhar_docname")
        @Expose
        public String aadhar_docname;

        @SerializedName("bank_docname")
        @Expose
        public String bank_docname;

        @SerializedName("agree_docname")
        @Expose
        public String agree_docname;

        @SerializedName("pledge_docname")
        @Expose
        public String pledge_docname;

        public String getPan_docname() {
            return pan_docname;
        }

        public void setPan_docname(String pan_docname) {
            this.pan_docname = pan_docname;
        }

        public String getQuest_docname() {
            return quest_docname;
        }

        public void setQuest_docname(String quest_docname) {
            this.quest_docname = quest_docname;
        }

        public String getAadhar_docname() {
            return aadhar_docname;
        }

        public void setAadhar_docname(String aadhar_docname) {
            this.aadhar_docname = aadhar_docname;
        }

        public String getBank_docname() {
            return bank_docname;
        }

        public void setBank_docname(String bank_docname) {
            this.bank_docname = bank_docname;
        }

        public String getAgree_docname() {
            return agree_docname;
        }

        public void setAgree_docname(String agree_docname) {
            this.agree_docname = agree_docname;
        }

        public String getPledge_docname() {
            return pledge_docname;
        }

        public void setPledge_docname(String pledge_docname) {
            this.pledge_docname = pledge_docname;
        }

        public String getDEALER_ID() {
            return DEALER_ID;
        }

        public void setDEALER_ID(String DEALER_ID) {
            this.DEALER_ID = DEALER_ID;
        }

        public String getSHOP_NAME() {
            return SHOP_NAME;
        }

        public void setSHOP_NAME(String SHOP_NAME) {
            this.SHOP_NAME = SHOP_NAME;
        }

        public String getOWNER_NAME() {
            return OWNER_NAME;
        }

        public void setOWNER_NAME(String OWNER_NAME) {
            this.OWNER_NAME = OWNER_NAME;
        }

        public String getSHOP_GST() {
            return SHOP_GST;
        }

        public void setSHOP_GST(String SHOP_GST) {
            this.SHOP_GST = SHOP_GST;
        }

        public String getPAN_NO() {
            return PAN_NO;
        }

        public void setPAN_NO(String PAN_NO) {
            this.PAN_NO = PAN_NO;
        }


        public String getUPLOAD_BY() {
            return UPLOAD_BY;
        }

        public void setUPLOAD_BY(String UPLOAD_BY) {
            this.UPLOAD_BY = UPLOAD_BY;
        }

        public String getID_NO() {
            return ID_NO;
        }

        public void setID_NO(String ID_NO) {
            this.ID_NO = ID_NO;
        }

        public String getID_TYPE() {
            return ID_TYPE;
        }

        public void setID_TYPE(String ID_TYPE) {
            this.ID_TYPE = ID_TYPE;
        }

        public String getLOC_NAME() {
            return LOC_NAME;
        }

        public void setLOC_NAME(String LOC_NAME) {
            this.LOC_NAME = LOC_NAME;
        }

        public String getPOST_OFFICE() {
            return POST_OFFICE;
        }

        public void setPOST_OFFICE(String POST_OFFICE) {
            this.POST_OFFICE = POST_OFFICE;
        }

        public String getDISTRICT() {
            return DISTRICT;
        }

        public void setDISTRICT(String DISTRICT) {
            this.DISTRICT = DISTRICT;
        }

        public String getSTATE() {
            return STATE;
        }

        public void setSTATE(String STATE) {
            this.STATE = STATE;
        }

        public String getPIN() {
            return PIN;
        }

        public void setPIN(String PIN) {
            this.PIN = PIN;
        }

        public String getMOB() {
            return MOB;
        }

        public void setMOB(String MOB) {
            this.MOB = MOB;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public void setEMAIL(String EMAIL) {
            this.EMAIL = EMAIL;
        }

        public String getADDED_DATE() {
            return ADDED_DATE;
        }

        public void setADDED_DATE(String ADDED_DATE) {
            this.ADDED_DATE = ADDED_DATE;
        }
    }
}
