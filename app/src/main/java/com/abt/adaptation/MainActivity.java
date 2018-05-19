package com.abt.adaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 已适配 800x480 - Inch4.0  - 密度1.5 - 密度DPI240 - value-w320dp
        // 已适配 1280x720 - Inch4.7 - 密度2 - 密度DPI320 - value-w360dp
        // 已适配 1920x1080 - Inch5.5 - 密度3 - 密度DPI480 - value-w360dp

        getScreenInfo();
        getDeviceInch();
    }

    public void getScreenInfo() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width =metric.widthPixels;  //宽度（PX）
        int height =metric.heightPixels;  //高度（PX）
        float density =metric.density;  //密度（0.75 / 1.0 / 1.5）
        int densityDpi =metric.densityDpi;  //密度DPI（120 / 160 / 240）
        Logger.d("宽度（px）= "+width+", 高度（px）= "+height+", 密度 = "+density+", 密度dpi = "+densityDpi);
    }

    // 获取设备的物理尺寸
    public void getDeviceInch() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);
        Logger.d("Screen Inches = "+screenInches);
    }

}
