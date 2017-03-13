package com.deepspring.dsplay.di.component;

import com.deepspring.dsplay.di.FragmentScope;
import com.deepspring.dsplay.di.module.RemmendModule;
import com.deepspring.dsplay.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Anonym on 2017/3/7.
 */

@FragmentScope
@Component(modules = {RemmendModule.class, AppComponent.class})
public interface RecommendComponent {

    void inject(RecommendFragment fragment);
}
