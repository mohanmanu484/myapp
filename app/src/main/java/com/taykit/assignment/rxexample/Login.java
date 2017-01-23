package com.taykit.assignment.rxexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohan on 6/1/17.
 */

public class Login {

    @SerializedName("username")
    public String userName;
    @SerializedName("password")
    public String password;
    @SerializedName("salt")
    public String salt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
