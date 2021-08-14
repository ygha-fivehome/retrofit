package com.ygha.retroclient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sonchangwoo on 2017. 1. 1..
 */

public interface RetroBaseApiService {

    final String Base_URL = "https://jsonplaceholder.typicode.com";

    @GET("/posts/{post}")
    Call<PostResult> getFirst(@Path("post") String id);

}
