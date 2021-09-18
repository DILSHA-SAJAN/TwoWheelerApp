package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginOutput {

    @SerializedName("loginStatus")
    @Expose
    private Integer loginStatus;
    @SerializedName("firmID")
    @Expose
    private Integer firmID;
    @SerializedName("firmName")
    @Expose
    private String firmName;
    @SerializedName("empCode")
    @Expose
    private Integer empCode;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("branchID")
    @Expose
    private Integer branchID;
    @SerializedName("branchName")
    @Expose
    private String branchName;
    @SerializedName("accessID")
    @Expose
    private Integer accessID;
    @SerializedName("roleID")
    @Expose
    private Integer roleID;
    @SerializedName("postID")
    @Expose
    private Integer postID;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("mobileNumber")
    @Expose
    private Object mobileNumber;
    @SerializedName("loginKey")
    @Expose
    private Object loginKey;
    @SerializedName("status")
    @Expose
    private ResponseStatus status;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginOutput() {
    }

    /**
     *
     * @param accessID
     * @param loginKey
     * @param firmName
     * @param status
     * @param loginStatus
     * @param postID
     * @param empCode
     * @param employeeName
     * @param branchID
     * @param firmID
     * @param token
     * @param branchName
     * @param mobileNumber
     * @param roleID
     */
    public LoginOutput(Integer loginStatus, Integer firmID, String firmName, Integer empCode, String employeeName, Integer branchID, String branchName, Integer accessID, Integer roleID, Integer postID, String token, Object mobileNumber, Object loginKey, ResponseStatus status) {
        super();
        this.loginStatus = loginStatus;
        this.firmID = firmID;
        this.firmName = firmName;
        this.empCode = empCode;
        this.employeeName = employeeName;
        this.branchID = branchID;
        this.branchName = branchName;
        this.accessID = accessID;
        this.roleID = roleID;
        this.postID = postID;
        this.token = token;
        this.mobileNumber = mobileNumber;
        this.loginKey = loginKey;
        this.status = status;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Integer getFirmID() {
        return firmID;
    }

    public void setFirmID(Integer firmID) {
        this.firmID = firmID;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public Integer getEmpCode() {
        return empCode;
    }

    public void setEmpCode(Integer empCode) {
        this.empCode = empCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getAccessID() {
        return accessID;
    }

    public void setAccessID(Integer accessID) {
        this.accessID = accessID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Object getLoginKey() {
        return loginKey;
    }

    public void setLoginKey(Object loginKey) {
        this.loginKey = loginKey;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
