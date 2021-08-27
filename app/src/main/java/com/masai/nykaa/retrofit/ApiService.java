package com.masai.nykaa.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v1/products.json?brand=maybelline")
    Call<List<ResponseModel>> getData();
}
