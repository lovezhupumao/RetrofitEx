package com.example.administrator.retrofitex;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetFlyRouteByRouteNo {
	//@Headers({"Content-Type: application/json","Accept: application/json"})
	@GET("api/route/{routeNo}")
	Call<FlyRouteBean> getFlyRouteBean(@Path("routeNo") String routeno);

}
