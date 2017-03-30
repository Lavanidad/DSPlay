package com.deepspring.dsplay.common.rx;

import android.content.Context;
import android.widget.Toast;

import com.deepspring.dsplay.common.exception.ApiException;
import com.deepspring.dsplay.common.exception.BaseException;
import com.deepspring.dsplay.common.exception.ErrorMessageFacotry;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * Created by Anonym on 2017/3/27.
 */

public class RxErrorHandler {

    private Context mContext;

    public RxErrorHandler(Context context) {
        this.mContext = context;
    }

    public BaseException handleError(Throwable e) {
        BaseException exception = new BaseException();
            if(e instanceof ApiException) {
                exception.setCode(((ApiException)e).getCode());
            }
            else if(e instanceof SocketException) {
                exception.setCode(BaseException.SOCKET_ERROR);
            }
            else if(e instanceof SocketTimeoutException) {
                exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
            }
            else if(e instanceof HttpException) {
                exception.setCode(BaseException.HTTP_ERROR);
            }
            else {
                exception.setCode(BaseException.UNKNOWN_ERROR);
            }
            exception.setDisplayMessage(ErrorMessageFacotry.create(mContext,exception.getCode()));

            return exception;
        }

        public void showErrorMessage(BaseException e) {
            Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_LONG).show();
        }
}
