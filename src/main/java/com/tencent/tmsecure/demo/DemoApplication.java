package com.tencent.tmsecure.demo;

import android.app.Application;
import android.util.Log;

import com.tencent.tmsecure.ad.ui.TxUiManage;
import com.tmsdk.AbsTMSConfig;
import com.tmsdk.TMSDKContext;

/**
 * 使用tms.jar，必须具备一个Application的子类
 *
 * @author boyliang
 */
public final class DemoApplication extends Application {

    volatile static boolean mBresult = false;

    @Override
    public void onCreate() {
        super.onCreate();
        new LoggingExceptionHandler(this);

//        long tt = 1558519749150L;
//        Date date = new Date(tt);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
//        String version = simpleDateFormat.format(date);
//        version = null;

        /**
         * setTMSDKLogEnable（true）会把tmsdk的log打开，release时可以去掉这个接口调用。
         */
        TMSDKContext.setTMSDKLogEnable(true);
        TxUiManage.setChannel("admo5");
        long start = System.currentTimeMillis();
                /**
         * setAutoConnectionSwitch（）影响渠道号上报这个自动联网项是否运行。请不要一直设置为false，影响激活量和活跃量统计,后台会关注并停止相关服务，请在过工信部测试允许联网后，设置回true
         */
        //boolean nFlag = true;//这里厂商应该用自己保存的用户设置
        //TMSDKContext.setAutoConnectionSwitch(nFlag);
        // TMSDK初始化
        mBresult = TMSDKContext.init(this, new AbsTMSConfig() {
            @Override
            public String getServerAddress() {
                return TCP_SERVER;
            }
        });
        long end = System.currentTimeMillis();
        Log.v("demo", "TMSDK init spend =" + (end - start));
        Log.v("demo", "init result =" + mBresult);
    }

    private static final String TCP_SERVER = "mazu.3g.qq.com"; // 正式环境
    //private static final String TCP_SERVER = "mazutest.3g.qq.com"; // 测试环境
}