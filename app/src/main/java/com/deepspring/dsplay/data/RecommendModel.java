package com.deepspring.dsplay.data;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.http.ApiService;

import retrofit2.Callback;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendModel {

    private ApiService mApiServer;

    public RecommendModel(ApiService apiService) {
        this.mApiServer = apiService;
    }

    public void getApps(Callback<PageBean<AppInfo>> callback) {


        mApiServer.getApps("{'page':0}").enqueue(callback);
    }
}
