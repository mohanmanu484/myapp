package com.taykit.assignment.rxexample.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taykit.assignment.rxexample.R;
import com.taykit.assignment.rxexample.databinding.VocabFragmentBinding;

/**
 * Created by mohan on 12/1/17.
 */

public class VocabFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        VocabFragmentBinding vocabFragmentBinding= DataBindingUtil.inflate(inflater, R.layout.vocab_fragment,container,false);
        vocabFragmentBinding.vocabList.setLayoutManager(new LinearLayoutManager(container.getContext()));
        vocabFragmentBinding.vocabList.setHasFixedSize(true);
        //vocabFragmentBinding.vocabList.setAdapter();


        return vocabFragmentBinding.getRoot();
    }
}
