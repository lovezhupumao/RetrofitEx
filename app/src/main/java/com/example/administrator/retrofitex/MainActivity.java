package com.example.administrator.retrofitex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private final String URL="http://192.168.1.155:18888/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void get(View view){
        Log.e("GET", "//");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        GetFlyRouteByRouteNo getFlyRouteByRouteNo=retrofit.create(GetFlyRouteByRouteNo.class);
        Call<FlyRouteBean> call=getFlyRouteByRouteNo.getFlyRouteBean("no1");
        call.enqueue(new Callback<FlyRouteBean>() {
            @Override
            public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
                Log.e("sssss",response.body().getDeviceId());
            }

            @Override
            public void onFailure(Call<FlyRouteBean> call, Throwable t) {
                Log.e("fail",t.getMessage());
            }
        });

    }
    public void post(View view) {
        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=initdata(flyRouteBean);
        Gson gson=new Gson();
        String route= gson.toJson(flyRouteBean);
        Log.e("post", "//");

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostRoute postRoute=retrofit.create(PostRoute.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<FlyRouteBean> call=postRoute.postFlyRoute(body);
    call.enqueue(new Callback<FlyRouteBean>() {
        @Override
        public void onResponse(Call<FlyRouteBean> call, Response<FlyRouteBean> response) {
            Log.e("sssss","-----------------------"+response.body().getDeviceId());
        }

        @Override
        public void onFailure(Call<FlyRouteBean> call, Throwable t) {
            Log.e("sssss",t.getMessage());
        }
    });
        Log.e("postjson", route);



    }
    public void patch(View view) {

        FlyRouteBean flyRouteBean=new FlyRouteBean();
        flyRouteBean=initdata(flyRouteBean);
        List<FlyRouteBean> list=new ArrayList<FlyRouteBean>();
        list.add(flyRouteBean);
        flyRouteBean=initdata(flyRouteBean);
        list.add(flyRouteBean);
        Gson gson=new Gson();
        String route= gson.toJson(list);
        Log.e("patchjson", route);
        String url =URL+ "api/FlyRoute/Patch";


    }
    private FlyRouteBean initdata(FlyRouteBean flyRouteBean) {
        // TODO Auto-generated method stub
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss");
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        String    str    =    formatter.format(curDate);
        flyRouteBean.setDeviceId("uav1");
        flyRouteBean.setId(UUID.randomUUID().toString());
        flyRouteBean.setName("hello");
        flyRouteBean.setRouteNo("uavno1");
        flyRouteBean.setSetupTime(str);
        flyRouteBean.setUsedTime(5);
        flyRouteBean.setSumPoints(1);
        flyRouteBean.setSumDistance(1000);
        List<FlyRouteBean.PointsBean> pointsBeans=new ArrayList<FlyRouteBean.PointsBean>();
        FlyRouteBean.PointsBean pointsBean=new FlyRouteBean.PointsBean();
        pointsBean.setId(UUID.randomUUID().toString());
        pointsBean.setRouteNo("routeno");
        pointsBean.setName("name");
        pointsBean.setLongitude("Longitude");
        pointsBean.setLatitude("Latitude");
        pointsBean.setHeight(10);
        pointsBean.setDistance(10);
        pointsBean.setYaw(20);
        pointsBean.setPitch(20);
        pointsBean.setUsedtime(100);
        pointsBean.setSpeed(2);

        pointsBean.setDistance(10);
        pointsBeans.add(pointsBean);
        flyRouteBean.setPoints(pointsBeans);
        return flyRouteBean;
    }
    //按钮json运行函数，直接在布局文件写了onclick属性，
    public void postStudent(View v){
        Student stu=new Student();
        stu.setId("20103177");
        stu.setName("zpm");
        stu.setAge(18);
        Gson gson=new Gson();
        String route= gson.toJson(stu);
        Log.e("post", "//");

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://172.20.69.209:9665/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostRoute postRoute=retrofit.create(PostRoute.class);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<ResponseBody> call=postRoute.postStudent(body,true);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("onResponse", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });

        Log.e("postjson", route);
    }
    public void retrofit(View v){
        //jsonAndField();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostRoute postRoute=retrofit.create(PostRoute.class);
        Call<ResponseBody> call=postRoute.getWeather("2f654b3b9212b440b4ab946cd989d4dd");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("onResponse", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    private void jsonAndField() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://172.20.69.209:9665/")
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        PostRoute postRoute=retrofit.create(PostRoute.class);
        Call<ResponseBody> call=postRoute.getHello("zhupumao",false);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("onResponse", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }
}
