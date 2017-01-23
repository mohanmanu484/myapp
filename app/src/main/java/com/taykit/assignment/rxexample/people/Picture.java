package com.taykit.assignment.rxexample.people;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohan on 6/1/17.
 */

public class Picture {

    @SerializedName("large")
    public String large;
    @SerializedName("medium")
    public String medium;
    @SerializedName("thumbnail")
    public String thumbnail;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
