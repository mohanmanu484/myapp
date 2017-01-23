package com.taykit.assignment.rxexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohan on 12/1/17.
 */

public class BaseActivity extends AppCompatActivity {


    public void addFragmentToActivity(int container,Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(container,fragment).commit();
    }
}
