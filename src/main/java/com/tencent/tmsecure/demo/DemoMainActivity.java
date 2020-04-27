package com.tencent.tmsecure.demo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.tmsecure.ad.ui.TxBaseActivity;
import com.tencent.tmsecure.ad.ui.TxPlayGameActivity;
import com.tencent.tmsecure.ad.ui.TxUiManage;
import com.tencent.tmsecure.ad.util.AdStateListener;
import com.tencent.tmsecure.ad.util.DialogUtil;
import com.tencent.tmsecure.ad.util.TaskStatus;
import com.tencent.tmsecure.ad.util.ToolUtil;
import com.tmsdk.TMSDKContext;
import com.tmsdk.module.ad.StyleAdEntity;

import java.util.ArrayList;
import java.util.List;

public class DemoMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);

        TxUiManage.setChannel("admo5");

        Button btnSplash = findViewById(R.id.btnSplash);
        btnSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DemoMainActivity.this, DkSplashActivity.class);
                startActivity(intent);
            }
        });
        Button btnVideo = findViewById(R.id.btnVideo);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoMainActivity.this, "测试有积分/有退出挽留/有强制要求开一次App的情况!", Toast.LENGTH_LONG).show();
                TxUiManage.showVideoAd(DemoMainActivity.this, 3 ,2, 2000, 30, new AdStateListener() {
                    public int abc = 1111;

                    @Override
                    public void onAdDisplay(StyleAdEntity ad) {
                        Log.d("onAdDisplay", "" + this.abc);
                    }

                    @Override
                    public void onAdClick(StyleAdEntity ad) {
                        Log.d("onAdClick", "" + this.abc);
                    }

                    @Override
                    public void onDownloadStart(StyleAdEntity ad) {
                        Toast.makeText(DemoMainActivity.this, "安装完成后再关闭页面, 才能获得金币哦!", Toast.LENGTH_LONG).show();
                        Log.d("onDownloadStart", "" + this.abc);
                    }

                    @Override
                    public void onDownloadFinished(StyleAdEntity ad, String strPath) {
                        Log.d("onDownloadFinished", strPath);
                    }

                    @Override
                    public void onInstalled(StyleAdEntity ad, String strPath) {
                        Log.d("onInstalled", strPath);
                    }

                    @Override
                    public void onAppActive(StyleAdEntity ad) {
                        Log.d("onAppActive", "" + this.abc);
                    }

                    @Override
                    public void onLoadFail(String str) {
                        Log.d("onLoadFail", str);
                    }

                    @Override
                    public void onClosed(TaskStatus status) {
                        Log.d("onClosed", "" + status);
                    }

                    @Override
                    public void onAwakened() {
                        Log.d("onAwakened", "shipin onAwakenedonAwakened  " );
                    }
                });
            }
        });


        Button btnAppAd = findViewById(R.id.btnAppAd);
        btnAppAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoMainActivity.this, "测试无积分/无退出挽留/无强制要求开一次App的情况!", Toast.LENGTH_LONG).show();
                //TxUiManage.showAppAd(DemoMainActivity.this, 0, false, null);
                TxUiManage.showAppAd(DemoMainActivity.this, 0 , new AdStateListener() {
                    public int abc = 2222;

                    @Override
                    public void onAdDisplay(StyleAdEntity ad) {
                        Log.d("onAdDisplay", "" + this.abc);
                    }

                    @Override
                    public void onAdClick(StyleAdEntity ad) {
                        Log.d("onAdClick", "" + this.abc);
                    }

                    @Override
                    public void onDownloadStart(StyleAdEntity ad) {
                        Toast.makeText(DemoMainActivity.this, "安装完成后再关闭页面, 才能获得金币哦!", Toast.LENGTH_LONG).show();
                        Log.d("onDownloadStart", "" + this.abc);
                    }

                    @Override
                    public void onDownloadFinished(StyleAdEntity ad, String strPath) {
                        Log.d("onDownloadFinished", strPath);
                    }

                    @Override
                    public void onInstalled(StyleAdEntity ad, String strPath) {
                        Log.d("onInstalled", strPath);
                    }

                    @Override
                    public void onAppActive(StyleAdEntity ad) {
                        Log.d("onAppActive", "" + this.abc);
                    }

                    @Override
                    public void onLoadFail(String str) {
                        Log.d("onLoadFail", str);
                    }

                    @Override
                    public void onClosed(TaskStatus status) {
                        Log.d("onClosed", "" + status);
                    }

                    @Override
                    public void onAwakened() {

                        Log.d("onAwakened", "shipin2222 onAwakenedonAwakened  " );
                    }
                });
            }
        });

        Button btnAppPopManual = findViewById(R.id.btnAppPopManual);
        btnAppPopManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TxUiManage.showAppRedEnvelopePopAd(DemoMainActivity.this, 2000, 30, new AdStateListener() {
                    public int abc = 3333;

                    @Override
                    public void onAdDisplay(StyleAdEntity ad) {
                        Log.d("onAdDisplay", "" + this.abc);
                    }

                    @Override
                    public void onAdClick(StyleAdEntity ad) {
                        Log.d("onAdClick", "" + this.abc);
                    }

                    @Override
                    public void onDownloadStart(StyleAdEntity ad) {
                        Log.d("onDownloadStart", "" + this.abc);
                    }

                    @Override
                    public void onDownloadFinished(StyleAdEntity ad, String strPath) {
                        Log.d("onDownloadFinished", strPath);
                    }

                    @Override
                    public void onInstalled(StyleAdEntity ad, String strPath) {
                        Log.d("onInstalled", strPath);
                    }

                    @Override
                    public void onAppActive(StyleAdEntity ad) {
                        Log.d("onAppActive", "" + this.abc);
                    }

                    @Override
                    public void onLoadFail(String str) {
                        Log.d("onLoadFail", str);
                    }

                    @Override
                    public void onClosed(TaskStatus status) {
                        Log.d("onClosed", "" + status);
                    }

                    @Override
                    public void onAwakened() {
                        Log.d("onAwakened", "shipin1111 onAwakenedonAwakened  " );
                    }
                }, 0);
            }
        });

        Button btnAppPopAuto = findViewById(R.id.btnAppPopAuto);
        btnAppPopAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TxUiManage.showAppRedEnvelopePopAd(DemoMainActivity.this, 30,600, null, 8);
            }
        });

        Button btnSdkInfo = findViewById(R.id.btnSdkInfo);
        btnSdkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = "guid:" + TMSDKContext.getGUID() + " imei:" + ToolUtil.getIMEI(DemoMainActivity.this);
                Log.d("DemoMainActivity", info);
                Toast.makeText(DemoMainActivity.this, info, Toast.LENGTH_LONG).show();

                //String packageName = "com.luzj.wifiadb";
                //getApplicationContext().startActivity(getApplicationContext().getPackageManager().getLaunchIntentForPackage(packageName));

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Demo", "onResume");
        checkAndRequestPermission();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Demo", "onPause");
    }

    @TargetApi(23)
    protected void checkAndRequestPermission() {
        List arrayList = new ArrayList();
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                if (checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    arrayList.add(str);
                    str = "android.permission.READ_PHONE_STATE";
                    if (checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                        arrayList.add(str);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  checkSelfPermission(Manifest.permission.CALL_PHONE) lackedPermission.size() =");
                    stringBuilder.append(arrayList.size());
                    if (arrayList.size() == 0) {
                        return;
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    requestPermissions(strArr, 1024);
                }
            } catch (Exception e) {

            }
        }
    }

    protected boolean hasAllPermissionsGranted(int[] iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1024 || !hasAllPermissionsGranted(iArr)) {
            DialogUtil.showSelectDialog(this, "温馨提示", "需授权读写手机存储权限", "去授权", "取消", this).show();
        }
    }

}
