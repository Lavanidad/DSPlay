package com.deepspring.dsplay.presenter;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.deepspring.dsplay.ui.adapter.RecomendAppAdatper;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    private int pageSize = 10;
    private int pageIndex = 1;
    private RecomendAppAdatper mAdatper;
    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view, RecomendAppAdatper appAdatper) {
        super(model, view);
        mAdatper = appAdatper;
    }


    public void requestDatas() {

        mView.showLoading();
        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if(response != null){
                    mView.showResult(response.body().getDatas());
                }else {
                    mView.showNodata();
                }
                mView.dimissLoading();
            }
            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());
            }
        });
    }
}
