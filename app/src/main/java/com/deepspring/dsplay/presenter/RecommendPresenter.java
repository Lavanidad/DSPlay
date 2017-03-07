package com.deepspring.dsplay.presenter;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.contract.RecommendContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anonym on 2017/3/6.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendModel mModel;

    private RecommendContract.View mView;

    //@Inject
    public  RecommendPresenter(RecommendContract.View view, RecommendModel model) {

        this.mView = view;
        this.mModel = model;
    }

    @Override
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
