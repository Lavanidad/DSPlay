package com.deepspring.dsplay.common.rx.subscriber;

import android.content.Context;

import com.deepspring.dsplay.common.exception.BaseException;
import com.deepspring.dsplay.common.util.ProgressDialogHandler;
import com.deepspring.dsplay.ui.BaseView;

/**
 * Created by Anonym on 2017/4/22.
 */

public abstract class ProgressSubcriber<T> extends ErrorHandlerSubscriber<T> implements ProgressDialogHandler.OnProgressCancelListener {


    private BaseView mView;

    public ProgressSubcriber(Context context, BaseView view) {
        super(context);
        this.mView = view;
    }

    public boolean isShowProgress() {
        return true;
    }

    @Override
    public void onCancelProgress() {
        unsubscribe();
    }

    @Override
    public void onStart() {
        if(isShowProgress()){
            mView.showLoading();
        }
    }

    @Override
    public void onCompleted() {
        mView.dismissLoading();
    }

    @Override
    public void onError(Throwable e) {
        BaseException baseException = mRxErrorHandler.handleError(e);
        mView.showError(baseException.getDisplayMessage());
    }
}

