package com.featzsoft.project2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {

    @POST("users")
    Call<ModelClass> createPost(@Body ModelClass dataModal);

}
