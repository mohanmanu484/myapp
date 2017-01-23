package com.taykit.assignment.rxexample.retrofit;


import com.taykit.assignment.rxexample.movie.MovieResponce;
import com.taykit.assignment.rxexample.people.PeopleResponce;
import com.taykit.assignment.rxexample.vocabulary.VocabularyResponce;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by mohan on 6/1/17.
 */

public interface NetworkCall {

    @GET()
    Observable<PeopleResponce> peopleObservableApi(@Url String url);

    @GET()
    Observable<MovieResponce> getMovies(@Url String url);

    @GET()
    Observable<VocabularyResponce> fetchWords(@Url String url);
}
