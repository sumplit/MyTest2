package com.rasmus.newsapi.model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by rasmus on 30/04/18.
 */

public interface ApiInterfaceGetList {

//    @GET("/news")
//    Call<List<News>> getNews(
//            @QueryMap Map<String, String> options
//    );

    @Headers("Content-type: application/json")
    @GET("/v2/top-headlines?country=us") //country=us&category=business&apiKey=87055553233f4db98aad6a760859d8b8
    Call<DataList> getListArticles(@QueryMap Map<String,String> options);
}
