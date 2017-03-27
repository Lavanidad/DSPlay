package com.deepspring.dsplay.presenter;

import android.util.Log;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.bean.BaseBean;
import com.deepspring.dsplay.common.rx.RxErrorHandler;
import com.deepspring.dsplay.common.rx.RxHttpReponseCompat;
import com.deepspring.dsplay.common.rx.subscriber.ErrorHandlerSubscriber;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;

import org.xml.sax.ErrorHandler;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    private RxErrorHandler mErrorHandler;

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view, RxErrorHandler errorHandler) {
        super(model, view);
        this.mErrorHandler = errorHandler;
    }

    public void requestDatas() {

        mModel.getApps()
                .compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())
                //.compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())
                .subscribe(new ErrorHandlerSubscriber<PageBean<AppInfo>>(mErrorHandler) {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PageBean<AppInfo> appInfoPageBean) {

                    }
                });
    }
}
