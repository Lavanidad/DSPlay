package com.deepspring.dsplay.presenter.contract;

import com.deepspring.dsplay.bean.IndexBean;
import com.deepspring.dsplay.ui.BaseView;

/**
 * Created by Anonym on 2017/3/6.
 */

public interface RecommendContract {

    interface View extends BaseView {

        void showResult(IndexBean indexBean);


        void onRequestPermissonSuccess();
        void onRequestPermissonError();
    }
}
