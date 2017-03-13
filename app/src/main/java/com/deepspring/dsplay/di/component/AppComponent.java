package com.deepspring.dsplay.di.component;

import com.deepspring.dsplay.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Anonym on 2017/3/13.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
}
