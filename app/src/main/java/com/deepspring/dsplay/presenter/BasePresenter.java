package com.deepspring.dsplay.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.deepspring.dsplay.ui.BaseView;

/**
 * Created by Anonym on 2017/3/6.
 */

public class BasePresenter<M,V extends BaseView> {

    protected M  mModel;
    protected V mView;
    protected Context mContext;

    public BasePresenter(M m, V v) {
        this.mView = v;
        this.mModel = m;
    }
    private void initContext(){

        if(mView instanceof Fragment){
            mContext = ((Fragment)mView).getActivity();
        }
        else {
            mContext = (Activity) mView;
        }
    }
}
