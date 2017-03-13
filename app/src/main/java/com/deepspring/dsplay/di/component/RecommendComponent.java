package com.deepspring.dsplay.di.component;

import com.deepspring.dsplay.di.module.RecommendModule;
import com.deepspring.dsplay.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Anonym on 2017/3/7.
 */


@Component(modules = RecommendModule.class)
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
