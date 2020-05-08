package com.tencent.tmsecure.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.tmsecure.ad.ui.TxSplashAdManage;
import com.tencent.tmsecure.ad.util.SplashInteractionListener;
import com.tmsdk.module.ad.StyleAdEntity;

public class DkSplashActivity extends Activity {
    private static final String TAG = "SplashActivity";
    private TxSplashAdManage dkAdManage;
    private FrameLayout mSplashContainer;
    //是否强制跳转到主页面
    private boolean mForceGoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashContainer = (FrameLayout) findViewById(R.id.splash_container);
        dkAdManage = new TxSplashAdManage(this);//传IMEI参数

        //step4:请求广告，调用开屏广告异步请求接口，对请求回调的广告作渲染处理
        dkAdManage.loadSplashAd("admo5" , 103 , new SplashInteractionListener() {
            @Override
            public void onLoadSuccess(StyleAdEntity styleAdEntity, final View view) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSplashContainer.removeAllViews();
                        mSplashContainer.addView(view);
                    }
                });
            }

            @Override
            public void onLoadEmpty() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("广告返回为空");
                        goToMainActivity();
                    }
                });
            }

            @Override
            public void onLoadFail(final String message) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(message);
                        goToMainActivity();
                    }
                });
            }

            @Override
            public void onAdClicked() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("点击广告");
                    }
                });
            }

            @Override
            public void onAdShow() {

            }

            @Override
            public void onAdClose() {

            }
            @Override
            public void onAdSkip() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        showToast("点击跳过");
                        goToMainActivity();
                        Log.e("TAG" ,"----   点击跳过 ");
                    }
                });
            }

            @Override
            public void onAdTimeOver() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("倒计时结束跳转");
                        goToMainActivity();
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        //判断是否该跳转到主页面
        if (mForceGoMain) {
            goToMainActivity();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mForceGoMain = true;
    }

    /**
     * 跳转到主页面
     */
    private void goToMainActivity() {
        Intent intent = new Intent(DkSplashActivity.this, DemoMainActivity.class);
        startActivity(intent);
        mSplashContainer.removeAllViews();
        this.finish();
    }

    private void showToast(String msg) {
        Toast.makeText(DkSplashActivity.this ,""+msg , Toast.LENGTH_LONG).show();
    }
}
