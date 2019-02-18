package com.example.client.configuration;

import com.example.client.services.PopulationService;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public Retrofit retrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl("http://api.population.io:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public PopulationService populationService(Retrofit retrofit) {
        return retrofit.create(PopulationService.class);
    }
}
