package com.taykit.assignment.rxexample.vocabulary;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohan on 9/1/17.
 */

public class VocabularyResponce  {

    @SerializedName("words")
    public List<Vocabulary> vocabularyList;
}
