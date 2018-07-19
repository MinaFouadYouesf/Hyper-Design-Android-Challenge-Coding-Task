package com.example.mina.minatask.rest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.example.mina.minatask.model.productObject;

import java.util.List;

public interface ApiInterface {
    @GET("products")
    Call<List<productObject>> getProducts(@Query("count") int count, @Query("from") int from);
}
