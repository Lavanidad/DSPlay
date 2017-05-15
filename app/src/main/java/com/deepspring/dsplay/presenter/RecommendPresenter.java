package com.deepspring.dsplay.presenter;

import com.deepspring.dsplay.bean.IndexBean;
import com.deepspring.dsplay.common.rx.RxHttpReponseCompat;
import com.deepspring.dsplay.common.rx.subscriber.ProgressSubcriber;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;

import javax.inject.Inject;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);

    }

    public void requestDatas() {

//        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
//
//        rxPermissions.request(Manifest.permission.READ_PHONE_STATE)
//                .flatMap(new Func1<Boolean, Observable<PageBean<AppInfo>>>() {
//                    @Override
//                    public Observable<PageBean<AppInfo>> call(Boolean aBoolean) {
//
//                        if (aBoolean) {
//                            return mModel.getApps().compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult());
//                        } else {
//                            return Observable.empty();
//                        }
//                    }
//                })
//                .subscribe(new ProgressSubcriber<PageBean<AppInfo>>(mContext,mView) {
//                    @Override
//                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
//                        mView.showResult(appInfoPageBean.getDatas());
//                    }
//                });
        mModel.index().compose(RxHttpReponseCompat.<IndexBean>compatResult())
                .subscribe(new ProgressSubcriber<IndexBean>(mContext,mView) {
                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.showResult(indexBean);
                    }
                });
    }
}
