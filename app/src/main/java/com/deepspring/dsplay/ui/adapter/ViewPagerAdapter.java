package com.deepspring.dsplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.deepspring.dsplay.ui.bean.FragmentInfo;
import com.deepspring.dsplay.ui.fragment.CategoryFragment;
import com.deepspring.dsplay.ui.fragment.GamesFragment;
import com.deepspring.dsplay.ui.fragment.RankingFragment;
import com.deepspring.dsplay.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonym on 2017/2/27.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragment=new ArrayList<>(4);

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }
    private void initFragment()
    {

        mFragment.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragment.add(new FragmentInfo("排行",RankingFragment.class));
        mFragment.add(new FragmentInfo("游戏",GamesFragment.class));
        mFragment.add(new FragmentInfo("分类",CategoryFragment.class));
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragment.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        try {
            return (Fragment) mFragment.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
