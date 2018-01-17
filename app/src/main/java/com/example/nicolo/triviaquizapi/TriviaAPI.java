package com.example.nicolo.triviaquizapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by per6 on 1/17/18.
 */

public interface TriviaAPI {

    String baseUrl="https://opentdb.com/api.php?amount=10";
    @GET("words")
    Call<List<Question>> getSoundsLike(@Query("sl") String word);


}
