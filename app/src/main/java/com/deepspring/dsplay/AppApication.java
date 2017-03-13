package com.deepspring.dsplay;

import android.app.Application;
import android.content.Context;

import com.deepspring.dsplay.di.component.DaggerAppComponent;
import com.deepspring.dsplay.di.module.AppModule;

/**
 * Created by Anonym on 2017/3/13.
 */

public class AppAplication extends Application {

    private DaggerAppComponent mAppComponent;

    public static AppAplication get(Context context) {
        return (AppAplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
