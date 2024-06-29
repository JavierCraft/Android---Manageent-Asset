package com.polytechnic.astra.ac.id.managementasset.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserModel {

    @SerializedName("usr_id")
    @Expose
    private String usrId;

    @SerializedName("rol_id")
    @Expose
    private char rolId;

    @SerializedName("app_id")
    @Expose
    private char appId;

    @SerializedName("usr_status")
    @Expose
    private String usrStatus;

    @SerializedName("usr_created_by")
    @Expose
    private String usrCreated_by;

    @SerializedName("usr_created_date")
    @Expose
    private Date usrCreated_date;

    @SerializedName("usr_modif_by")
    @Expose
    private String usrModif_by;

    @SerializedName("usr_modif_date")
    @Expose
    private Date usrModif_date;

    public UserModel() {
    }


    public UserModel(String usrId, char rolId, char appId, String usrStatus, String usrCreated_by, Date usrCreated_date, String usrModif_by, Date usrModif_date) {
        this.usrId = usrId;
        this.rolId = rolId;
        this.appId = appId;
        this.usrStatus = usrStatus;
        this.usrCreated_by = usrCreated_by;
        this.usrCreated_date = usrCreated_date;
        this.usrModif_by = usrModif_by;
        this.usrModif_date = usrModif_date;

    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public char getRolId() {
        return rolId;
    }

    public void setRolId(char rolId) {
        this.rolId = rolId;
    }

    public char getAppId() {
        return appId;
    }

    public void setAppId(char appId) {
        this.appId = appId;
    }

    public String getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(String usrStatus) {
        this.usrStatus = usrStatus;
    }

    public String getUsrCreated_by() {
        return usrCreated_by;
    }

    public void setUsrCreated_by(String usrCreated_by) {
        this.usrCreated_by = usrCreated_by;
    }

    public Date getUsrCreated_date() {
        return usrCreated_date;
    }

    public void setUsrCreated_date(Date usrCreated_date) {
        this.usrCreated_date = usrCreated_date;
    }

    public String getUsrModif_by() {
        return usrModif_by;
    }

    public void setUsrModif_by(String usrModif_by) {
        this.usrModif_by = usrModif_by;
    }

    public Date getUsrModif_date() {
        return usrModif_date;
    }

    public void setUsrModif_date(Date usrModif_date) {
        this.usrModif_date = usrModif_date;
    }

    /*@Override
    public String toString() {
        return "UserModel{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", namaUser='" + namaUser + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }*/
}
