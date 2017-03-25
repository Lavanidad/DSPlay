package com.deepspring.dsplay.data;


import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.http.ApiService;

import rx.Observable;


/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendModel {

    private ApiService mApiServer;

    public RecommendModel(ApiService apiService) {
        this.mApiServer = apiService;
    }

    public Observable<PageBean<AppInfo>> getApps() {
        return mApiServer.getApps("{'page':0}");
//      mApiServer.getApps("{'page':0}").enqueue(callback);
    }
}
