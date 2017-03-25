package com.deepspring.dsplay.presenter;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {

        mModel.getApps()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PageBean<AppInfo>>() {
                    @Override
                    public void onStart() {
                        mView.showLoading();
                    }

                    @Override
                    public void onCompleted() {
                        mView.dimissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dimissLoading();
                        //handler error
                    }

                    @Override
                    public void onNext(PageBean<AppInfo> response) {
                        if(response != null){
                            mView.showResult(response.getDatas());
                        }else {
                            mView.showNodata();
                        }
                    }
                });
    }
}
