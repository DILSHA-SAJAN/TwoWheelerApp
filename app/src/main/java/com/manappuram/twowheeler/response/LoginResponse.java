package com.manappuram.twowheeler.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse extends BaseResponse{
    @SerializedName("EmpDetails")
    @Expose
    public EmpDetails empDetails;


    public EmpDetails getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(EmpDetails empDetails) {
        this.empDetails = empDetails;
    }

    public class EmpDetails implements Serializable {

        @SerializedName("empCode")
        @Expose
        public String empCode;
        @SerializedName("deptId")
        @Expose
        public String deptId;
        @SerializedName("deptName")
        @Expose
        public String deptName;
        @SerializedName("postId")
        @Expose
        public String postId;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("designation")
        @Expose
        public String designation;
        @SerializedName("branch")
        @Expose
        public String branch;
        @SerializedName("branchId")
        @Expose
        public String branchId;
        @SerializedName("joinDate")
        @Expose
        public String joinDate;
        @SerializedName("sessionId")
        @Expose
        public String sessionId;

        @SerializedName("areaId")
        @Expose
        public String areaId;

        @SerializedName("regionId")
        @Expose
        public String regionId;

        @SerializedName("zoneId")
        @Expose
        public String zoneId;


        public String getEmpCode() {
            return empCode;
        }

        public void setEmpCode(String empCode) {
            this.empCode = empCode;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getJoinDate() {
            return joinDate;
        }

        public void setJoinDate(String joinDate) {
            this.joinDate = joinDate;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getZoneId() {
            return zoneId;
        }

        public void setZoneId(String zoneId) {
            this.zoneId = zoneId;
        }

        @Override
        public String toString() {
            return "EmpDetails{" +
                    "empCode='" + empCode + '\'' +
                    ", deptId='" + deptId + '\'' +
                    ", deptName='" + deptName + '\'' +
                    ", postId='" + postId + '\'' +
                    ", name='" + name + '\'' +
                    ", designation='" + designation + '\'' +
                    ", branch='" + branch + '\'' +
                    ", branchId='" + branchId + '\'' +
                    ", joinDate='" + joinDate + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    '}';
        }
    }
}
