package com.jy.jyjy;

import android.app.Application;
import android.content.Context;

import com.jy.jyjy.api.RetrofitService;
import com.jy.jyjy.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by zcr on 2017/4/17.
 */
public class MyApplication extends Application {


    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
            Logger.init("LogTAG");
        }
        mContext = this.getApplicationContext();
    ToastUtils.init(getContext());
    RetrofitService.init();
}

    public static Context getContext(){
        return mContext;
    }
}
