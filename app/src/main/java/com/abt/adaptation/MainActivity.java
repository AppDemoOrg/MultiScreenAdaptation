package com.abt.adaptation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width =metric.widthPixels;  //宽度（PX）
        int height =metric.heightPixels;  //高度（PX）
        float density =metric.density;  //密度（0.75 / 1.0 / 1.5）
        int densityDpi =metric.densityDpi;  //密度DPI（120 / 160 / 240）
        Logger.d("宽度（PX）= "+width);
        Logger.d("高度（PX）= "+height);
        Logger.d("密度 = "+density);
        Logger.d("密度DPI = "+densityDpi);

        getScreenInch();
    }


    // 获取设备的物理尺寸
    public void getScreenInch() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);
        Logger.d("Screen Inches = "+screenInches);
    }

}
