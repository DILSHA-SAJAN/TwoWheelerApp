package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeList {
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

}