package com.abt.adaptation;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @描述： @AdaptationApp
 * @作者： @黄卫旗
 * @创建时间： @2018/5/8
 */
public class AdaptationApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
