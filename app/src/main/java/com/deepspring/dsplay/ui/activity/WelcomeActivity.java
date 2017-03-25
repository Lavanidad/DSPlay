package com.deepspring.dsplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.common.Constant;
import com.deepspring.dsplay.common.util.ACache;
import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anonym on 2017/3/20.
 */

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.pathView)
    PathView pathView;
    @BindView(R.id.activity_welcome)
    LinearLayout activityWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        pathView.getPathAnimator()
                .delay(100)
                .duration(500)
                .interpolator(new AccelerateDecelerateInterpolator())
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        jump();
                    }
                })
                .start();
    }

    private void jump() {
        String isShowGuide = ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);
        // 第一次启动
        if(null == isShowGuide) {
            startActivity(new Intent(this, GuideActivity.class));
        }
        else {
            startActivity(new Intent(this, MainActivity.class));
        }
        this.finish();
    }
}
