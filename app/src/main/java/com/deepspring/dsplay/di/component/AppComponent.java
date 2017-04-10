package com.deepspring.dsplay.di.component;

import android.app.Application;

import com.deepspring.dsplay.common.rx.RxErrorHandler;
import com.deepspring.dsplay.data.http.ApiService;
import com.deepspring.dsplay.di.module.AppModule;
import com.deepspring.dsplay.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Anonym on 2017/3/13.
 */


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    public ApiService getApiService();

    public Application getApplication();

    public RxErrorHandler getRxErrorHandler();


}
