package com.deepspring.dsplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.bean.PageBean;
import com.deepspring.dsplay.http.ApiService;
import com.deepspring.dsplay.http.HttpManager;
import com.deepspring.dsplay.ui.adapter.RecomendAppAdatper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anonym on 2017/2/27.
 */

public class RecommendFragment extends Fragment {

    @BindView(R.id.recyle_view)
    RecyclerView mRecycleView;
    private RecomendAppAdatper mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recomend,container,false);
        ButterKnife.bind(this,view);
        initData();
        return view ;
    }

    private void initData() {
        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                PageBean<AppInfo> pageBean = response.body();
                List<AppInfo> datas = pageBean.getDatas();
                initRecycleView(datas);
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                Log.d("msg",t.getMessage());
            }

        });
    }//end init

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
}
