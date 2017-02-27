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

public class ViewPageAdapter extends FragmentStatePagerAdapter{

    private List<FragmentInfo> mFragments = new ArrayList<>(4);

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment(){
        mFragments.add(new FragmentInfo( "推荐", RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行", RankingFragment.class));
        mFragments.add(new FragmentInfo("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo("分类", CategoryFragment.class));



    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment)mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
//        switch (position){
//            case 0:
//                fragment = new RecommendFragment();
//                break;
//            case 1:
//                fragment = new RankingFragment();
//                break;
//            case 2:
//                fragment = new GamesFragment();
//                break;
//            case 3:
//                fragment = new CategoryFragment();
//                break;
//        }
//        return fragment;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
