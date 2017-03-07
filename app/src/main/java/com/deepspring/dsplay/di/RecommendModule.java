package com.deepspring.dsplay.di;

import android.app.ProgressDialog;

import com.deepspring.dsplay.data.RecommendModel;
import com.deepspring.dsplay.presenter.RecommendPresenter;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.deepspring.dsplay.ui.fragment.RecommendFragment;

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
    public RecommendContract.Presenter providePresenter(RecommendContract.View view, RecommendModel recommendModel) {

        return new RecommendPresenter(view, recommendModel);
    }

    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

    @Provides
    public RecommendModel privodeModel() {
        return new RecommendModel();
    }

    @Provides
    public ProgressDialog progressDialog(RecommendContract.View view) {
        return new ProgressDialog(((RecommendFragment)view).getActivity());
    }
}
