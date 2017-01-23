package com.taykit.assignment.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.taykit.assignment.rxexample.movie.MovieResponce;
import com.taykit.assignment.rxexample.people.PeopleResponce;
import com.taykit.assignment.rxexample.retrofit.NetworkCall;
import com.taykit.assignment.rxexample.retrofit.RestClient;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void networkCall(View view) {
        Retrofit retrofit = RestClient.getClient();
        NetworkCall networkCall = retrofit.create(NetworkCall.class);

        Observable<PeopleResponce> peopleResponceObservable=networkCall.peopleObservableApi("http://api.randomuser.me/?results=10&nat=en");
        Observable<MovieResponce> movieResponceObservable=networkCall.getMovies("http://api.themoviedb.org/3/movie/top_rated?api_key=66731d2e5d5e953395193ec20af94cac");









        Observable.zip(networkCall.peopleObservableApi("http://api.randomuser.me/?results=10&nat=en"), networkCall.getMovies("http://api.themoviedb.org/3/movie/top_rated?api_key=66731d2e5d5e953395193ec20af94cac"),
                new Func2<PeopleResponce, MovieResponce, Object>() {
                    @Override
                    public Object call(PeopleResponce peopleResponce, MovieResponce movieResponce) {
                        Log.d(TAG, "call: "+peopleResponce.getPeopleList().size());
                        Log.d(TAG, "call: "+movieResponce.movieList.size());
                        return null;
                    }
                }
        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "call: "+o);
            }
        });

       /* Observable.merge(peopleResponceObservable,movieResponceObservable).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

                Log.d(TAG, "onNext: ");
            }
        });
*/


       /* networkCall.getMovies("http://api.themoviedb.org/3/movie/top_rated?api_key=66731d2e5d5e953395193ec20af94cac").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<MovieResponce>() {
            @Override
            public void call(MovieResponce movieResponce) {

                List<Movie> peopleList = movieResponce.movieList;
                for (Movie people : peopleList
                        ) {
                    Log.d(TAG, "call: "+people.title);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                throwable.printStackTrace();
                Log.d(TAG, "call: ");
            }
        });

    }*/
    }


}
