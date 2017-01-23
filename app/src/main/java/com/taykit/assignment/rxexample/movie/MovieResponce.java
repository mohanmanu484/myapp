package com.taykit.assignment.rxexample.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohan on 6/1/17.
 */

public class MovieResponce {

    @SerializedName("results")
    public List<Movie> movieList;
}
