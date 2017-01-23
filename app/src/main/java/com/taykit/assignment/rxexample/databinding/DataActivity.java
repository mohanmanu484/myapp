package com.taykit.assignment.rxexample.databinding;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.taykit.assignment.rxexample.R;
import com.taykit.assignment.rxexample.movie.Movie;
import com.taykit.assignment.rxexample.vocabulary.Vocabulary;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class DataActivity extends AppCompatActivity {
    Movie movie=new Movie("",2,true);

    EditText editText;
    private static final String TAG = "DataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.taykit.assignment.rxexample.databinding.ActivityDataBinding activityDataBinding= DataBindingUtil.setContentView(this,R.layout.activity_data);
        movie.setId(1);
        movie.setAdult(true);
        movie.setTitle("Kirik party");
        activityDataBinding.setMovie(movie);

      Observable<List<Vocabulary>> observable=  Observable.create(new Observable.OnSubscribe<List<Vocabulary>>() {
            @Override
            public void call(Subscriber<? super List<Vocabulary>> subscriber) {

                List<Vocabulary> vocabularyList=new ArrayList<Vocabulary>();
                vocabularyList.add(new Vocabulary(1,"A"));
                subscriber.onNext(vocabularyList);
                subscriber.onCompleted();


            }
        });


        observable
                .map(new Func1<List<Vocabulary>, List<String>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public List<String> call(List<Vocabulary> vocabularies) {
                        List<String> strings=new ArrayList<String>();
                        for (Vocabulary vocabulary  :
                                vocabularies){
                            strings.add(vocabulary.getWord());
                        }

                        return strings;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {

                    }
                });

    }

    public void update(View view) {

        movie.setTitle("Ulidavaru kandanthe");
    }



}
