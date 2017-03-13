package com.deepspring.dsplay.di.module;

import com.deepspring.dsplay.data.http.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anonym on 2017/3/13.
 */

@Module
public class HttpModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        //log用拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                //连接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                //读取时间超时设置
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient);

        return builder.build();
    }

    @Provides
    @Singleton
    public ApiService provideApiServer(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
