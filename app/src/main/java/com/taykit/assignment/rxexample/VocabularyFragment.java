package com.taykit.assignment.rxexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taykit.assignment.rxexample.databinding.VocabularyFragmentLayoutBinding;
import com.taykit.assignment.rxexample.retrofit.NetworkCall;
import com.taykit.assignment.rxexample.retrofit.RestClient;
import com.taykit.assignment.rxexample.vocabulary.Vocabulary;
import com.taykit.assignment.rxexample.vocabulary.VocabularyResponce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by mohan on 8/1/17.
 */

public class VocabularyFragment extends Fragment {

    VocabularyAdapter vocabularyAdapter;
    RecyclerView recyclerView;
    private static final String TAG = "VocabularyFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VocabularyFragmentLayoutBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.vocabulary_fragment_layout, container, false);
        recyclerView = viewDataBinding.rvMovieList;
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setHasFixedSize(true);
        vocabularyAdapter = new VocabularyAdapter(new ArrayList<Vocabulary>(0));
        recyclerView.setAdapter(vocabularyAdapter);
        fetchWords();
        return viewDataBinding.getRoot();
    }

    private void fetchWords() {
        Retrofit retrofit = RestClient.getClient();
        NetworkCall networkCall = retrofit.create(NetworkCall.class);
        Observable<VocabularyResponce> responceObservable = networkCall.fetchWords("http://appsculture.com/vocab/words.json");
        responceObservable
                .map(new Func1<VocabularyResponce, List<Vocabulary>>() {
                    @Override
                    public List<Vocabulary> call(VocabularyResponce vocabularyResponce) {

                        List<Vocabulary> vocabularyList=vocabularyResponce.vocabularyList;
                        List<Vocabulary> correctVocabularyList=new ArrayList<Vocabulary>();
                        for (Vocabulary vocabulary : vocabularyList) {

                            if(vocabulary.getRatio()!=-1){
                                correctVocabularyList.add(vocabulary);
                            }
                        }
                        return correctVocabularyList;
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Vocabulary>>() {
                    @Override
                    public void call(List<Vocabulary> vocabularies) {

                        vocabularyAdapter.updateList(vocabularies);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
}
