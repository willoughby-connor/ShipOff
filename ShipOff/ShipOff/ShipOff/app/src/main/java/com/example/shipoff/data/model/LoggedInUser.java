package com.example.shipoff.data.model;

import android.content.Intent;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {
    private String userID;
    private String email;
    private String password;
    private String displayName;
    private String userType;
    private String pronouns;
    private String sponsor;
    private String address;
    private int points;

    public LoggedInUser(String id, String password, String displayName) {
        this.email = id;
        this.password = password;
        this.displayName = displayName;
    }

    public String getUserID() { return userID; }

    public String setUserID( String newUserID ) {
        userID = newUserID;
        return userID;
    }

    public String getUserEmail() {
        return email;
    }

    public String setUserEmail( String newUserEmail ) {
        email = newUserEmail;
        return email;
    }

    public String getUserType() { return userType; }

    public String setUserType(String newType) {
        userType = newType;
        return userType;
    }

    public String getUserPassword() { return password; }

    public String getDisplayName() {
        return displayName;
    }

    public String setDisplayName(String newName) {
        displayName = newName;
        return displayName;
    }

    public String getSponsorName() { return sponsor; }

    public String setSponsorName(String newSponsor) {
        sponsor = newSponsor;
        return newSponsor;
    }

    public String getAddress() { return address; }

    public String setAddress(String newAddress) {
        address = newAddress;
        return address;
    }

    public int getPoints() { return points; }

    public int setPoints(int newPoints) {
        points = newPoints;
        return points;
    }

    public String getPreferredPronouns() { return pronouns; }

    public String setPreferredPronouns() { return pronouns; }

    // N/A
    public String changePassword() {
        String pass = " ";
        return pass;
    }

}