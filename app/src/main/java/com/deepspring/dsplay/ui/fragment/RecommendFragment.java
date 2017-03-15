package com.deepspring.dsplay.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.di.component.AppComponent;
import com.deepspring.dsplay.di.component.DaggerRecommendComponent;
import com.deepspring.dsplay.di.module.RemmendModule;
import com.deepspring.dsplay.presenter.RecommendPresenter;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.deepspring.dsplay.ui.adapter.RecomendAppAdatper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Anonym on 2017/2/27.
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View{

    @BindView(R.id.recyle_view)
    RecyclerView mRecycleView;
    private RecomendAppAdatper mAdapter;
    @Inject
    public ProgressDialog mProgressDialog;

    @Override
    public int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
            .appComponent(appComponent)
            .remmendModule(new RemmendModule(this)).build().inject(this);
    }

    @Override
    public void init() {
        mPresenter.requestDatas();
    }

    private void initRecycleView(List<AppInfo> datas) {
        //设置布局管理器
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割线
        mRecycleView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        //动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new RecomendAppAdatper(getActivity(), datas);
        mRecycleView.setAdapter(mAdapter);

    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dimissLoading() {
        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecycleView(datas);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了："+ msg, Toast.LENGTH_SHORT).show();
    }
}
