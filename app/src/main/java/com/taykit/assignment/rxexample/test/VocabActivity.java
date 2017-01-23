package com.taykit.assignment.rxexample.test;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.taykit.assignment.rxexample.BaseActivity;
import com.taykit.assignment.rxexample.R;

public class VocabActivity extends BaseActivity {


    private static final String TAG = "VocabActivity";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        VocabFragment vocabularyFragment =
                (VocabFragment) getSupportFragmentManager().findFragmentById(R.id.activity_vocab);
        if (vocabularyFragment == null) {
            // Create the fragment
            vocabularyFragment = new VocabFragment();
            addFragmentToActivity(
                    R.id.activity_vocab,vocabularyFragment);
        }


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }
}
