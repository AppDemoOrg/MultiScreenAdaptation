# MultiScreenAdaptation

## 参考资料：    
[一个强大的安卓开发屏幕适配工具库](https://github.com/yatoooon/AndroidScreenAdaptation)      

## ViVo_X9 Device Info     
Width（PX）= 1080     
Height（PX）= 1920      
Density = 3.0    
Density DPI = 480          
Screen Inches = 5.464510361895758      

## 密度DPI与DIR映射关系      
DPI=480 xxxhdpi: 3.0       
DPI=400 xxhdpi: 2.5    
DPI=320 xhdpi：2.0    
DPI=240 hdpi：1.5    
DPI=160 mdpi：1.0（基准）   
DPI=120 ldpi：0.75    

## 根据屏幕宽度的适配   
Android 不止提供了根据分辨率的适配规则 ，也提供了屏幕宽度限定进行的适配方式；   
使用w-Ndp 方式限定资源，可以在一套配置中适配多个分辨率；   

1280x720 分辨率的手机，相对屏幕密度是2，把单位换算成dp后，屏幕尺寸变为640x360dp ；    
960x540 分辨率的手机，相对屏幕密度是1.5，把单位换算成dp后，屏幕尺寸变为640x360dp ；   
1920x1080 分辨率的手机，相对屏幕密度是3，把单位换算成dp后，屏幕尺寸变为640x360dp ；    
在res下新建values-w360dp，就能适配到以上配置的手机了；    

854x480，800x480分辨率的手机，通常是宽度通常是320dp ，放置在values-w360dp下面就可以适配到了。   
以上详情参考[Android 屏幕适配方案](https://www.jianshu.com/p/f33c03a0d3a4)     


## 说明
art中Android设备分辨率统计，数据来源[友盟统计](https://www.umeng.com/)     
1184x720以及1776x1080的屏幕分辨率实际上是1280x720和1920x1080；     
他们的系统使用了虚拟按键，导致可显示区域的减少；     

