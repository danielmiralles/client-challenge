package com.example.client.services;

import com.example.client.domain.PopulationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PopulationService {
    @GET("/1.0/life-expectancy/total/male/Peru/{birthday}/")
    Call<PopulationResponse> calculateLifeExpectancy(@Path("birthday")String birthday);
}
