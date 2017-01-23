package com.taykit.assignment.rxexample.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taykit.assignment.rxexample.R;
import com.taykit.assignment.rxexample.movie.Movie;

import java.util.ArrayList;

/**
 * Created by mohan on 8/1/17.
 */

public class MyFragment extends Fragment {

    Movie movie=new Movie("kirik",1,true);

    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.taykit.assignment.rxexample.databinding.MyFragmentLayoutBinding view= DataBindingUtil.inflate(inflater,R.layout.my_fragment_layout,container,false);
        recyclerView=view.rvList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        ArrayList<Movie> movieArrayList=new ArrayList<>();
        for (int i=0;i<20;i++){
            movieArrayList.add(new Movie("title"+i,i,i%2==0?true:false));
        }
        MyAdapter myAdapter=new MyAdapter(movieArrayList);
        recyclerView.setAdapter(myAdapter);
        return view.getRoot();
    }

    public void myClick(View view){
        movie.setTitle("party");
        movie.setAdult(false);
    }
}
