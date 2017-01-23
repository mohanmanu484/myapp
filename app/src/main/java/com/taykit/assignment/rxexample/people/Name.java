package com.taykit.assignment.rxexample.people;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohan on 6/1/17.
 */

public class Name {

    @SerializedName("title")
    public String title;
    @SerializedName("first")
    public String first;
    @SerializedName("last")
    public String last;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
