package com.taykit.assignment.rxexample.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mohan on 16/1/17.
 */

public class Student implements Parcelable {

    private int mData;

    private Student(Parcel in) {
        mData = in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mData);
    }

    public static final Parcelable.Creator<Student> CREATOR
            = new Parcelable.Creator<Student>() {
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };


}
