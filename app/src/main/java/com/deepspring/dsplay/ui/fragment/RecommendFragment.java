package com.deepspring.dsplay.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.bean.IndexBean;
import com.deepspring.dsplay.di.component.AppComponent;
import com.deepspring.dsplay.di.component.DaggerRecommendComponent;
import com.deepspring.dsplay.di.module.RemmendModule;
import com.deepspring.dsplay.presenter.RecommendPresenter;
import com.deepspring.dsplay.presenter.contract.RecommendContract;
import com.deepspring.dsplay.ui.adapter.IndexMutilAdapter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Anonym on 2017/2/27.
 */

public class RecommendFragment extends ProgressFragment<RecommendPresenter> implements RecommendContract.View{

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private IndexMutilAdapter mAdatper;

    @Inject
    ProgressDialog mProgressDialog;

    @Override
    public int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void setUpActivityComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder().appComponent(appComponent)
                .remmendModule(new RemmendModule(this)).build().inject(this);
    }

    @Override
    public void init() {
        initRecycleView();
        mPresenter.requestDatas();
    }

    @Override
    public void onEmptyViewClick() {
        mPresenter.requestDatas();
    }

    private void initRecycleView(){

        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void showResult(IndexBean indexBean) {
        mAdatper = new IndexMutilAdapter(getActivity());
        mAdatper.setData(indexBean);
        mRecyclerView.setAdapter(mAdatper);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了："+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissonSuccess() {
        mPresenter.requestDatas();
    }

    @Override
    public void onRequestPermissonError() {
        Toast.makeText(getActivity(),"你已拒绝授权",Toast.LENGTH_LONG).show();
    }

}
