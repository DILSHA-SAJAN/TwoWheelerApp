package com.manappuram.twowheeler.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("empCode")
    @Expose
    private String empCode;

    @SerializedName("pwd")
    @Expose
    private String pwd;


    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//    @Override
//    public String toString() {
//        return "LoginRequest{" +
//                "empCode='" + empCode + '\'' +
//                ", pwd='" + pwd + '\'' +
////                ", uuid='" + uuid + '\'' +
////                ", imei='" + imei + '\'' +
//                '}';
//    }
}
