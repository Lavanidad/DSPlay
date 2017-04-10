package com.deepspring.dsplay.data.http;


import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.BaseBean;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.bean.requestbean.LoginRequestBean;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Anonym on 2017/2/28.
 */

public interface ApiService {

    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

//    @GET("featured")
//    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);

    @GET("featured2")
    public Observable<BaseBean<PageBean<AppInfo>>> getApps(@Query("p") String jsonParam);

    //{"phone":"","password":""}
    @POST("login")
    public Observable<BaseBean> login(@Body LoginRequestBean bean);

    @FormUrlEncoded // FormBody
    @POST("login")
    public   void login2(@Field("phone") String phone);


}
