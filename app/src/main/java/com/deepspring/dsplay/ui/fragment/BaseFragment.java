package com.deepspring.dsplay.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepspring.dsplay.AppApplication;
import com.deepspring.dsplay.di.component.AppComponent;
import com.deepspring.dsplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Anonym on 2017/3/15.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private Unbinder mUnbinder;
    private AppApplication mApplication;
    private View mRootView;
    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        init();
        return mRootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication = (AppApplication) getActivity().getApplication();
        setupActivityComponent(mApplication.getAppComponent());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }

    public abstract int setLayout();
    public abstract void setupActivityComponent(AppComponent appComponent);
    public abstract void init();
}
