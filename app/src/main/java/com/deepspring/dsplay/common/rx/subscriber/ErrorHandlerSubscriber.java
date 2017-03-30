package com.deepspring.dsplay.common.rx.subscriber;

import com.deepspring.dsplay.common.exception.BaseException;
import com.deepspring.dsplay.common.rx.RxErrorHandler;

/**
 * Created by Anonym on 2017/3/27.
 */

public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {

    private RxErrorHandler mRxErrorHandler;

    public ErrorHandlerSubscriber(RxErrorHandler errorHandler) {
        this.mRxErrorHandler = errorHandler;
    }

    @Override
    public void onError(Throwable e) {
        BaseException exception = mRxErrorHandler.handleError(e);
        mRxErrorHandler.showErrorMessage(exception);
    }
}
