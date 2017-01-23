package com.taykit.assignment.rxexample.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.taykit.assignment.rxexample.vocabulary.Vocabulary;

import java.util.ArrayList;

/**
 * Created by mohan on 12/1/17.
 */

public class VocabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Vocabulary> vocabularyArrayList;

    public VocabAdapter(ArrayList<Vocabulary> vocabularyArrayList) {
        this.vocabularyArrayList = vocabularyArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class VocabHolder extends RecyclerView.ViewHolder{

        public VocabHolder(View itemView) {
            super(itemView);
        }
    }
}
