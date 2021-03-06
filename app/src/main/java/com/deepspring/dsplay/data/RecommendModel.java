package com.deepspring.dsplay.data;


import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.BaseBean;
import com.deepspring.dsplay.bean.IndexBean;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.http.ApiService;

import rx.Observable;


/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendModel {

    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public Observable<BaseBean<PageBean<AppInfo>>> getApps() {
        return mApiService.getApps("{'page':0}");
//      mApiServer.getApps("{'page':0}").enqueue(callback);
    }

    public Observable<BaseBean<IndexBean>> index() {
        return mApiService.index();
    }
}
