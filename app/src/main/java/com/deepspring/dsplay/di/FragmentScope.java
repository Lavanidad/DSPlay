package com.deepspring.dsplay.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Anonym on 2017/3/13.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
