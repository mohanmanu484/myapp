package com.taykit.assignment.rxexample.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.taykit.assignment.rxexample.R;
import com.taykit.assignment.rxexample.movie.Movie;

import java.util.List;

/**
 * Created by mohan on 8/1/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    private List<Movie> movieList;

    public MyAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        com.taykit.assignment.rxexample.databinding.SingleItemBinding binding=DataBindingUtil.inflate(layoutInflater, R.layout.single_item,parent,false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.bindMovieView(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        com.taykit.assignment.rxexample.databinding.SingleItemBinding binding;

        public MyHolder(com.taykit.assignment.rxexample.databinding.SingleItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bindMovieView(Movie movie){
            binding.setMovie(movie);
            binding.tvTitle.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    binding.getMovie().setTitle(""+charSequence);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            binding.executePendingBindings();
        }
    }
}
