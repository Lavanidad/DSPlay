package com.deepspring.dsplay.data;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.http.ApiService;
import com.deepspring.dsplay.data.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendModel {

    public void getApps(Callback<PageBean<AppInfo>> callback) {
        HttpManager manager = new HttpManager();

        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);

        apiService.getApps("{'page':0}").enqueue(callback);
    }
}
