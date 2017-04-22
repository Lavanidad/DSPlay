package com.deepspring.dsplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepspring.dsplay.AppApplication;
import com.deepspring.dsplay.di.component.AppComponent;
import com.deepspring.dsplay.presenter.BasePresenter;
import com.deepspring.dsplay.ui.BaseView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Anonym on 2017/3/15.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    private Unbinder mUnbinder;
    private AppApplication mApplication;
    private View mRootView;
    @Inject
    T  mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        mUnbinder=ButterKnife.bind(this, mRootView);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication= (AppApplication) getActivity().getApplication();
        setUpActivityComponent(mApplication.getAppComponent());
        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void showError(String msg) {
    }

    @Override
    public void dismissLoading() {
    }

    public abstract int setLayout();
    public abstract void setUpActivityComponent(AppComponent appComponent);
    public  abstract void init();

}
