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

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View{
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private RecommendAppAdatper mAdatper;
    @Inject
    ProgressDialog mProgressDialog;

    @Override
    int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void setUpActivityComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder().appComponent(appComponent).
                remmendModule(new RemmendModule(this)).
                build().
                inject(this);
    }

    @Override
    public void init() {
        mPresenter.requestDatas();
    }

    private void initRecycleView(List<AppInfo> datas){
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        mAdatper=new RecommendAppAdatper(getActivity(),datas);
        recycleView.setAdapter(mAdatper);
    }

    @Override
    public void showResult(List<AppInfo> datas) {
        initRecycleView(datas);
    }

    @Override
    public void showNodata() {
        Toast.makeText(getActivity(), "暂时无数据,请吃完饭再来", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), "服务器开小差了："+msg, Toast.LENGTH_SHORT).show();

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
}
