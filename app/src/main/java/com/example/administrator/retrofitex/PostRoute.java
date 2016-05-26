package com.example.administrator.retrofitex;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/5/26.
 */
public interface PostRoute {
   @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("api/FlyRoute/Add")
   Call<FlyRouteBean> postFlyRoute(@Body RequestBody route);
}
