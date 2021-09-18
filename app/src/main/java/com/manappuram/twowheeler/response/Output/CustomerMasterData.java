package com.manappuram.twowheeler.response.Output;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerMasterData  implements Parcelable {

    @SerializedName("residentialStatus")
    @Expose
    private List<CommonStatusDescription> residentialList = null;
    @SerializedName("nationality")
    @Expose
    private List<CommonStatusDescription> nationalityList = null;

    @SerializedName("citizenships")
    @Expose
    private List<CommonStatusDescription> citizenshipsList = null;

    @SerializedName("relationsList")
    @Expose
    private List<Relation> relationsList = null;

    @SerializedName("businessList")
    @Expose
    private List<Business> occupationList = null;
    @SerializedName("maritalStatus")
    @Expose
    private List<CommonStatusDescription> maritalList = null;
    @SerializedName("religionsList")
    @Expose
    private List<Religions> religionsList = null;
    @SerializedName("casteMasterList")
    @Expose
    private List<Caste> casteList = null;
    @SerializedName("preNameList")
    @Expose
    private List<PreName> preNamesList = null;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    @SerializedName("kycIDTypes")
    @Expose
    private List<KycIDTypes> KycIdTypesList = null;

    @SerializedName("customerStatusList")
    @Expose
    private List<CustomerStatusList> customerStatusList = null;

    public CustomerMasterData() {
    }

    public List<CustomerStatusList> getCustomerStatusList() {
        return customerStatusList;
    }

    public void setCustomerStatusList(List<CustomerStatusList> customerStatusList) {
        this.customerStatusList = customerStatusList;
    }

    protected CustomerMasterData(Parcel in) {
    }

    public List<KycIDTypes> getKycIdTypesList() {
        return KycIdTypesList;
    }

    public void setKycIdTypesList(List<KycIDTypes> kycIdTypesList) {
        KycIdTypesList = kycIdTypesList;
    }

    public static final Creator<CustomerMasterData> CREATOR = new Creator<CustomerMasterData>() {
        @Override
        public CustomerMasterData createFromParcel(Parcel in) {
            return new CustomerMasterData(in);
        }

        @Override
        public CustomerMasterData[] newArray(int size) {
            return new CustomerMasterData[size];
        }
    };

    public List<CommonStatusDescription> getCitizenshipsList() {
        return citizenshipsList;
    }

    public void setCitizenshipsList(List<CommonStatusDescription> citizenshipsList) {
        this.residentialList = residentialList;
    }
    public List<Relation> getRelationsList() {
        return relationsList;
    }

    public void setRelationsList(List<Relation> relationsList) {
        this.relationsList = relationsList;
    }
    public List<CommonStatusDescription> getResidentialList() {
        return residentialList;
    }

    public void setResidentialList(List<CommonStatusDescription> residentialList) {
        this.residentialList = residentialList;
    }

    public List<CommonStatusDescription> getNationalityList() {
        return nationalityList;
    }

    public void setNationalityList(List<CommonStatusDescription> nationalityList) {
        this.nationalityList = nationalityList;
    }

    public List<Business> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Business> occupationList) {
        this.occupationList = occupationList;
    }

    public List<CommonStatusDescription> getMaritalList() {
        return maritalList;
    }

    public void setMaritalList(List<CommonStatusDescription> maritalList) {
        this.maritalList = maritalList;
    }

    public List<Religions> getReligionsList() {
        return religionsList;
    }

    public void setReligionsList(List<Religions> religionsList) {
        this.religionsList = religionsList;
    }


    public List<Caste> getCasteList() {
        return casteList;
    }

    public void setCasteList(List<Caste> casteList) {
        this.casteList = casteList;
    }

    public List<PreName> getPreNamesList() {
        return preNamesList;
    }

    public void setPreNamesList(List<PreName> preNamesList) {
        this.preNamesList = preNamesList;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

}
