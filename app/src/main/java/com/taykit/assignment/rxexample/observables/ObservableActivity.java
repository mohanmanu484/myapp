package com.taykit.assignment.rxexample.observables;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.taykit.assignment.rxexample.R;
import com.taykit.assignment.rxexample.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObservableBinding activityObservableBinding= DataBindingUtil.setContentView(this,R.layout.activity_observable);
        activityObservableBinding.setObj(new MyViewModel());

    }
}
