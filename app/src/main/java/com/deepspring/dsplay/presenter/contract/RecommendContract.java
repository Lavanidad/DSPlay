package com.deepspring.dsplay.presenter.contract;

import com.deepspring.dsplay.bean.AppInfo;
import com.deepspring.dsplay.ui.BaseView;

import java.util.List;

/**
 * Created by Anonym on 2017/3/6.
 */

public interface RecommendContract {

    interface View extends BaseView {

        void showResult(List<AppInfo> datas);

        void showNodata();

        void showError(String msg);
    }
}
