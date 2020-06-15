package com.example.arhaicwordsdictionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GitHubApiService {

    @GET("words")
    Call<List<Words>> getAllWords();

    @POST("words")
    Call<Words> addNewWord(@Body Words word);

}
