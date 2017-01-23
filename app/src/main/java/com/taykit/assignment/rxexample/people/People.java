package com.taykit.assignment.rxexample.people;

import com.google.gson.annotations.SerializedName;
import com.taykit.assignment.rxexample.Location;
import com.taykit.assignment.rxexample.Login;

/**
 * Created by mohan on 6/1/17.
 */

public class People {

    @SerializedName("name")
    public Name name;
    @SerializedName("login")
    public Login login;
    @SerializedName("gender")
    public String gender;
    @SerializedName("email")
    public String email;
    @SerializedName("location")
    public Location location;
    @SerializedName("picture")
    public Picture picture;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
