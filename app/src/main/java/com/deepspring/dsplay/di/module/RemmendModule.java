package com.deepspring.dsplay.di.module;

import android.app.ProgressDialog;

import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.data.http.ApiService;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.deepspring.dsplay.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anonym on 2017/3/7.
 */


@Module
public class RemmendModule {

    private RecommendContract.View mView;

    public RemmendModule(RecommendContract.View view) {
        this.mView = view;
    }


    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

    @Provides
    public RecommendModel privodeModel(ApiService apiService) {
        return new RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog privodeProgressDialog(RecommendContract.View view) {
        return new ProgressDialog(((RecommendFragment)view).getActivity());
    }
}
