package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoterIdData {

    @SerializedName("ps_lat_long")
    @Expose
    private String psLatLong;
    @SerializedName("rln_name_v1")
    @Expose
    private String rlnNameV1;
    @SerializedName("rln_name_v2")
    @Expose
    private String rlnNameV2;
    @SerializedName("rln_name_v3")
    @Expose
    private String rlnNameV3;
    @SerializedName("part_no")
    @Expose
    private String partNo;
    @SerializedName("rln_type")
    @Expose
    private String rlnType;
    @SerializedName("section_no")
    @Expose
    private String sectionNo;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("epic_no")
    @Expose
    private String epicNo;
    @SerializedName("rln_name")
    @Expose
    private String rlnName;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("ac_no")
    @Expose
    private String acNo;
    @SerializedName("house_no")
    @Expose
    private String houseNo;
    @SerializedName("ps_name")
    @Expose
    private String psName;
    @SerializedName("pc_name")
    @Expose
    private String locality;
    @SerializedName("slno_inpart")
    @Expose
    private String slnoInpart;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("part_name")
    @Expose
    private String streetName;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("ac_name")
    @Expose
    private String city;
    @SerializedName("name_v1")
    @Expose
    private String nameV1;
    @SerializedName("st_code")
    @Expose
    private String stCode;
    @SerializedName("name_v3")
    @Expose
    private String nameV3;
    @SerializedName("name_v2")
    @Expose
    private String nameV2;

    /**
     * No args constructor for use in serialization
     *
     */
    public VoterIdData() {
    }

    /**
     *
     * @param sectionNo
     * @param acNo
     * @param lastUpdate
     * @param psLatLong
     * @param state
     * @param id
     * @param epicNo
     * @param slnoInpart
     * @param name
     * @param age
     * @param stCode
     * @param gender
     * @param district
     * @param rlnName
     * @param locality
     * @param partNo
     * @param streetName
     * @param rlnType
     * @param nameV3
     * @param houseNo
     * @param psName
     * @param city
     * @param rlnNameV3
     * @param rlnNameV1
     * @param rlnNameV2
     * @param dob
     * @param nameV1
     * @param nameV2
     */
    public VoterIdData(String psLatLong, String rlnNameV1, String rlnNameV2, String rlnNameV3, String partNo, String rlnType, String sectionNo, String id, String epicNo, String rlnName, String district, String lastUpdate, String state, String acNo, String houseNo, String psName, String locality, String slnoInpart, String name, String streetName, String dob, String gender, String age, String city, String nameV1, String stCode, String nameV3, String nameV2) {
        super();
        this.psLatLong = psLatLong;
        this.rlnNameV1 = rlnNameV1;
        this.rlnNameV2 = rlnNameV2;
        this.rlnNameV3 = rlnNameV3;
        this.partNo = partNo;
        this.rlnType = rlnType;
        this.sectionNo = sectionNo;
        this.id = id;
        this.epicNo = epicNo;
        this.rlnName = rlnName;
        this.district = district;
        this.lastUpdate = lastUpdate;
        this.state = state;
        this.acNo = acNo;
        this.houseNo = houseNo;
        this.psName = psName;
        this.locality = locality;
        this.slnoInpart = slnoInpart;
        this.name = name;
        this.streetName = streetName;
        this.dob = dob;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.nameV1 = nameV1;
        this.stCode = stCode;
        this.nameV3 = nameV3;
        this.nameV2 = nameV2;
    }

    public String getPsLatLong() {
        return psLatLong;
    }

    public void setPsLatLong(String psLatLong) {
        this.psLatLong = psLatLong;
    }

    public String getRlnNameV1() {
        return rlnNameV1;
    }

    public void setRlnNameV1(String rlnNameV1) {
        this.rlnNameV1 = rlnNameV1;
    }

    public String getRlnNameV2() {
        return rlnNameV2;
    }

    public void setRlnNameV2(String rlnNameV2) {
        this.rlnNameV2 = rlnNameV2;
    }

    public String getRlnNameV3() {
        return rlnNameV3;
    }

    public void setRlnNameV3(String rlnNameV3) {
        this.rlnNameV3 = rlnNameV3;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getRlnType() {
        return rlnType;
    }

    public void setRlnType(String rlnType) {
        this.rlnType = rlnType;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(String sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpicNo() {
        return epicNo;
    }

    public void setEpicNo(String epicNo) {
        this.epicNo = epicNo;
    }

    public String getRlnName() {
        return rlnName;
    }

    public void setRlnName(String rlnName) {
        this.rlnName = rlnName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getSlnoInpart() {
        return slnoInpart;
    }

    public void setSlnoInpart(String slnoInpart) {
        this.slnoInpart = slnoInpart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNameV1() {
        return nameV1;
    }

    public void setNameV1(String nameV1) {
        this.nameV1 = nameV1;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public String getNameV3() {
        return nameV3;
    }

    public void setNameV3(String nameV3) {
        this.nameV3 = nameV3;
    }

    public String getNameV2() {
        return nameV2;
    }

    public void setNameV2(String nameV2) {
        this.nameV2 = nameV2;
    }

}
