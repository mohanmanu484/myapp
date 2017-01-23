package com.taykit.assignment.rxexample.people;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohan on 6/1/17.
 */

public class PeopleResponce {

    @SerializedName("results")
    List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
