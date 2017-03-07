package com.deepspring.dsplay.di;

import com.deepspring.dsplay.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Anonym on 2017/3/7.
 */


@Component(modules = RecommendModule.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
