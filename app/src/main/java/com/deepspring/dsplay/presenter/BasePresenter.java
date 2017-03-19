package com.deepspring.dsplay.presenter;

import com.deepspring.dsplay.ui.BaseView;

/**
 * Created by Anonym on 2017/3/6.
 */

public class BasePresenter<M,V extends BaseView> {

    protected M  mModel;
    protected V mView;

    public BasePresenter(M m, V v) {
        this.mView = v;
        this.mModel = m;
    }
}
