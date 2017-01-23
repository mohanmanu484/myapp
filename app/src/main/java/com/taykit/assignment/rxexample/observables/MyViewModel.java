package com.taykit.assignment.rxexample.observables;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by mohan on 13/1/17.
 */

public class MyViewModel {


    public ObservableField<String> firstNumber;
    public ObservableField<String> secondNumber;

    public ObservableField<Integer> result;

    public MyViewModel() {
        firstNumber=new ObservableField<>("");
        secondNumber=new ObservableField<>("");
    }

    public TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
