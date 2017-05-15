package com.deepspring.dsplay.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.di.component.AppComponent;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by Anonym on 2017/4/9.
 */


public class LoginActivity extends BaseActivity {


    private static final int READ_PHONE_STATE_CODE = 1000;
    @BindView(R.id.btn)
    Button mBtn;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setUpActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {

        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if(aBoolean){

                        }else {

                        }
                    }
                });

//        // 没有授权
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.READ_PHONE_STATE},READ_PHONE_STATE_CODE);
//        }
//        else{
//            // 已经授权
//            String imei = DeviceUtils.getIMEI(this);
//            Toast.makeText(LoginActivity.this,"imei="+imei, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if(requestCode == READ_PHONE_STATE_CODE){
//
//
//            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
//
//                String imei  = DeviceUtils.getIMEI(this);
//                Toast.makeText(LoginActivity.this,"imei="+imei,Toast.LENGTH_LONG).show();
//            }
//            else {
//                Toast.makeText(LoginActivity.this,"用户拒绝授权",Toast.LENGTH_LONG).show();
//            }
//        }
    }
}
