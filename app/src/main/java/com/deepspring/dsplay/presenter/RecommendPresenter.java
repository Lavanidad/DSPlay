package com.deepspring.dsplay.presenter;

import android.Manifest;
import android.app.Activity;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.common.rx.RxHttpReponseCompat;
import com.deepspring.dsplay.common.rx.subscriber.ProgressDialogSubcriber;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);

    }

    public void requestDatas() {

        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);

        rxPermissions.request(Manifest.permission.READ_PHONE_STATE)
                .flatMap(new Func1<Boolean, Observable<PageBean<AppInfo>>>() {
                    @Override
                    public Observable<PageBean<AppInfo>> call(Boolean aBoolean) {

                        if (aBoolean) {

                            return mModel.getApps().compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult());
                        } else {

                            return Observable.empty();
                        }

                    }
                })
                .subscribe(new ProgressDialogSubcriber<PageBean<AppInfo>>(mContext) {
                    @Override
                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
                        mView.showResult(appInfoPageBean.getDatas());
                    }
                });
    }
}
