package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PanDetails {
    @SerializedName("pan_number")
    @Expose
    private String panNumber;
    @SerializedName("pan_status")
    @Expose
    private String panStatus;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("pan_holder_title")
    @Expose
    private String panHolderTitle;
    @SerializedName("pan_last_updated")
    @Expose
    private String panLastUpdated;

    /**
     * No args constructor for use in serialization
     *
     */
    public PanDetails() {
    }

    /**
     *
     * @param middleName
     * @param lastName
     * @param panStatus
     * @param panHolderTitle
     * @param panLastUpdated
     * @param firstName
     * @param panNumber
     */
    public PanDetails(String panNumber, String panStatus, String lastName, String firstName, String middleName, String panHolderTitle, String panLastUpdated) {
        super();
        this.panNumber = panNumber;
        this.panStatus = panStatus;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.panHolderTitle = panHolderTitle;
        this.panLastUpdated = panLastUpdated;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        this.panStatus = panStatus;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPanHolderTitle() {
        return panHolderTitle;
    }

    public void setPanHolderTitle(String panHolderTitle) {
        this.panHolderTitle = panHolderTitle;
    }

    public String getPanLastUpdated() {
        return panLastUpdated;
    }

    public void setPanLastUpdated(String panLastUpdated) {
        this.panLastUpdated = panLastUpdated;
    }

}
