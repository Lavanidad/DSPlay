package com.deepspring.dsplay.di;

import com.deepspring.dsplay.presenter.RecommendPresenter;
import com.deepspring.dsplay.presenter.contract.RecommendContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Anonym on 2017/3/7.
 */


@Module
public class RecommendModule {

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        this.mView = view;
    }

    @Provides
    public RecommendContract.Presenter providePresenter(RecommendContract.View view) {

        return new RecommendPresenter(view);
    }

    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

}
