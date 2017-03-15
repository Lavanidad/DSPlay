package com.deepspring.dsplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.deepspring.dsplay.AppApplication;
import com.deepspring.dsplay.di.component.AppComponent;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Anonym on 2017/3/15.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    private AppApplication mApplication;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(),
                new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (AppApplication) getApplication();
        setupActivityComponent(mApplication.getAppComponent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    public abstract int setLayout();
    public abstract void setupActivityComponent(AppComponent appComponent);
}
