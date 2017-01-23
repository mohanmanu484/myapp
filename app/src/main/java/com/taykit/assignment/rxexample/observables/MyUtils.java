package com.taykit.assignment.rxexample.observables;

/**
 * Created by mohan on 13/1/17.
 */

public class MyUtils {

    public static String add(String a,String b){

        if(a==null || a.equalsIgnoreCase("")){
            a="0";
        }
        if(b==null || b.equalsIgnoreCase("")){
            b="0";
        }

        int i=Integer.valueOf(a);
        int j=Integer.valueOf(b);
        return i+j+"";

    }
}
