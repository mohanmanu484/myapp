package com.taykit.assignment.rxexample;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taykit.assignment.rxexample.databinding.VocabularyListItemBinding;
import com.taykit.assignment.rxexample.vocabulary.Vocabulary;

import java.util.List;

/**
 * Created by mohan on 9/1/17.
 */

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyHolder> {

    private List<Vocabulary> vocabularyList;
    private static final String TAG = "VocabularyAdapter";

    public VocabularyAdapter(List<Vocabulary> vocabularyList) {
        this.vocabularyList = vocabularyList;
    }

    public void updateList(List<Vocabulary> vocabularyList) {
        this.vocabularyList = vocabularyList;
        notifyDataSetChanged();
    }

    @Override
    public VocabularyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        VocabularyListItemBinding singleItemBinding= DataBindingUtil.inflate(layoutInflater,R.layout.vocabulary_list_item,parent,false);
        return new VocabularyHolder(singleItemBinding);
    }

    @Override
    public void onBindViewHolder(VocabularyHolder holder, int position) {

        holder.bindMovie(vocabularyList.get(position));
    }

    @Override
    public int getItemCount() {
        return vocabularyList.size();
    }

    @BindingAdapter("bind:url")
    public static void loadImage(View view,int url){
        Log.d(TAG, "loadImage: "+"http://appsculture.com/vocab/images/"+url+".png");
        Picasso.with(view.getContext()).load("http://appsculture.com/vocab/images/"+url+".png").into((ImageView) view);

    }

    public static class VocabularyHolder extends RecyclerView.ViewHolder{

        VocabularyListItemBinding singleItemBinding;

        public VocabularyHolder(VocabularyListItemBinding itemView) {
            super(itemView.getRoot());
            this.singleItemBinding=itemView;
        }

        private void bindMovie(com.taykit.assignment.rxexample.vocabulary.Vocabulary movie){
            singleItemBinding.setVocabulary(movie);
           // singleItemBinding.setHandler(this);
        }

    }
}
