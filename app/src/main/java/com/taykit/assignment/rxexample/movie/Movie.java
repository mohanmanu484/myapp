package com.taykit.assignment.rxexample.movie;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import com.taykit.assignment.rxexample.BR;

/**
 * Created by mohan on 6/1/17.
 */

public class Movie extends BaseObservable{

    /*@SerializedName("title")
    private String title;

    @SerializedName("id")
    private int id;

    @SerializedName("adult")
    private boolean adult;*/

    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           setId(charSequence.length());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public TextWatcher getTextWatcher(){
        return textWatcher;
    }

    private String title;

    private int id;

    private boolean adult;

    public Movie(String title, int id, boolean adult) {
        this.title = title;
        this.id = id;
        this.adult = adult;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
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
    public boolean isAdult() {
        return adult;

    }

    public void setAdult(boolean adult) {
        this.adult = adult;
        notifyPropertyChanged(BR.adult);
    }
}
