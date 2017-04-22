package com.deepspring.dsplay.ui;

/**
 * Created by Anonym on 2017/3/6.
 */

public interface BaseView {
    void showLoading();
    void showError(String msg);
    void dismissLoading();
}
