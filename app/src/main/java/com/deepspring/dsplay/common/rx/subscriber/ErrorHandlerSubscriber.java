package com.deepspring.dsplay.common.rx.subscriber;

import android.util.Log;

import com.deepspring.dsplay.common.exception.BaseException;
import com.deepspring.dsplay.common.rx.RxErrorHandler;

/**
 * Created by Anonym on 2017/3/27.
 */

public abstract  class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {

    protected RxErrorHandler mRxErrorHandler;


    public ErrorHandlerSubscriber(RxErrorHandler errorHandler){
        //mErrorHandler = new RxErrorHandler(mContext);
        this.mRxErrorHandler = errorHandler;
    }

    @Override
    public void onError(Throwable e) {
        BaseException baseException =  mRxErrorHandler.handleError(e);

        if(baseException==null){
            e.printStackTrace();
            Log.d("ErrorHandlerSubscriber",e.getMessage());
        }
        else {
            mRxErrorHandler.showErrorMessage(baseException);
        }
    }
}
