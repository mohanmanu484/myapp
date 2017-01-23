package com.taykit.assignment.rxexample.vocabulary;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.taykit.assignment.rxexample.BR;

/**
 * Created by mohan on 3/1/17.
 */

public class Vocabulary extends BaseObservable {

    @SerializedName("id")
    private int id;
    @SerializedName("word")
    private String word;
    @SerializedName("meaning")
    private String meaning;
    @SerializedName("ratio")
    private float ratio;

    /*private int id;
    private String word;
    private String meaning;
    private float ratio;*/

    public Vocabulary(int id, String word) {
        this.id = id;
        this.word = word;
    }


    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
        notifyPropertyChanged(BR.ratio);
    }

    @Bindable
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
        notifyPropertyChanged(BR.meaning);
    }

    @Bindable
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        notifyPropertyChanged(BR.word);

    }

    @Override
    public String toString() {
        return "[" +id+
                " " +word+
                        " " +ratio +"]";
    }
}
