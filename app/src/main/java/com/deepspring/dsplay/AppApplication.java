package com.deepspring.dsplay;

import android.app.Application;
import android.content.Context;

import com.deepspring.dsplay.di.component.AppComponent;
import com.deepspring.dsplay.di.component.DaggerAppComponent;
import com.deepspring.dsplay.di.module.AppModule;
import com.deepspring.dsplay.di.module.HttpModule;

/**
 * Created by Anonym on 2017/3/13.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }
}
