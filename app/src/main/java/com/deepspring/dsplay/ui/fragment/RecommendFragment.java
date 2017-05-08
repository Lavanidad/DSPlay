package com.deepspring.dsplay.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
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
import com.deepspring.dsplay.ui.adapter.RecommendAppAdatper;
import com.deepspring.dsplay.ui.decoration.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Anonym on 2017/2/27.
 */

public class RecommendFragment extends ProgressFragment<RecommendPresenter> implements RecommendContract.View{

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private RecommendAppAdatper mAdatper;

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
        mPresenter.requestDatas();
    }

    @Override
    public void onEmptyViewClick() {
        mPresenter.requestDatas();
    }

    private void initRecycleView(List<AppInfo> datas){

        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //为RecyclerView设置分割线(这个可以对DividerItemDecoration进行修改，自定义)
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdatper = new RecommendAppAdatper(getActivity(),datas);

        mRecyclerView.setAdapter(mAdatper);

    }

    @Override
    public void showResult(List<AppInfo> datas) {
        Toast.makeText(getActivity(),"小豆子好",Toast.LENGTH_LONG).show();
        initRecycleView( datas);
    }

    @Override
    public void showNodata() {

        Toast.makeText(getActivity(),"暂时无数据，请吃完饭再来",Toast.LENGTH_LONG).show();
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
