# MultiScreenAdaptation     

## 密度(DPI)、密度DIR、values-wNdp、(px/dp换算)、XML(realDp - @dimen/dp_n)映射关系      
密度 3.0(480)  xxxhdpi  values-wNdp(N=Width/3.0)   1dp=3.0px   realDp=realPx/3.0   (n=readDp*240/N)                
密度 2.5(400)  xxhdpi   values-wNdp(N=Width/2.5)   1dp=2.5px   realDp=realPx/2.5   (n=readDp*240/N)           
密度 2.0(320)  xhdpi    values-wNdp(N=Width/2.0)   1dp=2.0px   realDp=realPx/2.0   (n=readDp*240/N)            
密度 1.5(240)  hdpi     values-wNdp(N=Width/1.5)   1dp=1.5px   realDp=realPx/1.5   (n=readDp*240/N)             
密度 1.0(160)  mdpi     values-wNdp(N=Width/1.0)   1dp=1px     realDp=realPx/1.0   (n=readDp*240/N)            
密度0.75(120)  ldpi     values-wNdp(N=Width/0.75)  1dp=0.75px  realDp=realPx/0.75  (n=readDp*240/N)          

## 根据屏幕宽度的适配   
1、Android 不止提供了根据分辨率的适配规则 ，也提供了屏幕宽度限定进行的适配方式；   
2、使用w-Ndp 方式限定资源，可以在一套配置中适配多个分辨率；   
3、1280x720 分辨率的手机，相对屏幕密度是2，把单位换算成dp后，屏幕尺寸变为640x360dp；    
4、960x540 分辨率的手机，相对屏幕密度是1.5，把单位换算成dp后，屏幕尺寸变为640x360dp；   
5、1920x1080 分辨率的手机，相对屏幕密度是3，把单位换算成dp后，屏幕尺寸变为640x360dp；    
6、在res下新建values-w360dp，就能适配到以上配置的手机了；    
7、854x480，800x480分辨率的手机，通常是宽度通常是320dp ，放置在values-w360dp下面就可以适配到了。   

## 几个但是    
1、但是，鉴于Android本身的开放性，各个厂商都没有能够很好的做到一致性，比如说三星的手机有1280x800的设备，相对密度为2，于是需要添加values-w400dp的文件夹；  
2、但是，1280x720 手机的相对密度可能是1.5的，可能是3的，于是还可能需要适配w480dp，w240dp；    
3、但是，960x540 手机的相对密度可能是1的，可能是2的，于是还可能需要适配w540dp，w270dp；   
4、但是，1920x1080 手机的相对密度可能是2的，于是还可能需要适配w540dp；   
5、代码中，请采用dp作为单位      

## 说明   
1、art中Android设备分辨率统计，数据来源[友盟统计](https://www.umeng.com/)     
2、1184x720以及1776x1080的屏幕分辨率实际上是1280x720和1920x1080；      
   他们的系统使用了虚拟按键，导致可显示区域的减少；      

## 参考资料    
1、[一个强大的安卓开发屏幕适配工具库](https://github.com/yatoooon/AndroidScreenAdaptation)      
2、[Android 屏幕适配方案](https://www.jianshu.com/p/f33c03a0d3a4)         
3、[android屏幕适配，自动生成不同的dimens.xml详解](https://blog.csdn.net/hnzcdy/article/details/50628993)   
4、[安卓屏幕完美适配方案——独家秘笈](https://blog.csdn.net/jiashuai94/article/details/77639511)    
5、[Android屏幕适配规则](https://blog.csdn.net/mydreamongo/article/details/45366247)      

