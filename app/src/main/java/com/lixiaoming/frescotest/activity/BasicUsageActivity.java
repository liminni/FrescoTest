package com.lixiaoming.frescotest.activity;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lixiaoming.frescotest.R;

public class BasicUsageActivity extends BaseActivity {

    private SimpleDraweeView draweeView;

    private SimpleDraweeView draweeView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);//初始化Fresco，这一步操作必须在setContentView()之前，否则SimpleDraweeView会报错
        setContentView(R.layout.activity_basic_usage);
        initView();
    }

    private void initView() {
        /**正常加载图片 含占位图*/
        draweeView = (SimpleDraweeView) findViewById(R.id.drawee_basic);
        draweeView.setImageURI(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489552198155&di=121749f20db6263df1a878b3b25c7100&imgtype=0&src=http%3A%2F%2Fimg.app178.com%2Ftu%2F201507%2Fvmxelhvyx3b.jpg"));

        /**设置加载进度图*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_anim));
        draweeView.setImageURI(Uri.parse("http://picture.ik123.com/uploads/allimg/160708/12-160FQ51514.jpg"));

        /**设置圆形图片*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_circle));
        draweeView.setImageURI(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489552619541&di=864bb0361640a606b0b8ec83c0f37bd5&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fblog%2F201506%2F21%2F20150621205945_wT3rj.jpeg"));

        /**设置圆角图片*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_roundCorner));
        draweeView.setImageURI(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490150069&di=65d2d9293e5eb8faa7febc54d8fd849b&imgtype=jpg&er=1&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20151204%2F1440x900_a57000139dd08a2.jpg"));

        /**加载错误*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_error));
        draweeView.setImageURI(Uri.parse("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E6%97%A5%E7%B3%BB%E5%B0%91%E5%A5%B3%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1842364479,921282162&os=3059257219,838328528&simid=4004855935,522980359&pn=95&rn=1&di=35326470740&ln=3898&fr=&fmq=1489542113637_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=5a&hs=2&objurl=http%3A%2F%2Fimg.19196.com%2Fuploads%2F151209%2F9-151209102RS53.jpg&rpstart=0&rpnum=0&adpicid=0"));

        /**重试  需要注意的是重试加载4次还没加载出来就会显示加载失败的图片*/
        draweeView1 = ((SimpleDraweeView) findViewById(R.id.drawee_again));
        Uri imageURI = Uri.parse("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E6%97%A5%E7%B3%BB%E5%B0%91%E5%A5%B3%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2225100923,779839335&os=2450709940,3917304213&simid=3556553653,283736908&pn=85&rn=1&di=193474039330&ln=3898&fr=&fmq=1489542113637_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=1e&hs=2&objurl=http%3A%2F%2Fd.5857.com%2Fshao_160605%2Fdesk_004.jpg&rpstart=0&rpnum=0&adpicid=0");
        draweeView1.setImageURI(imageURI);
        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                                       //要加载的图片URL
                                       //Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489557828780&di=e7005756991e00c9272335e2bf2af371&imgtype=0&src=http%3A%2F%2Fd.5857.com%2Fshao_160605%2Fdesk_004.jpg"
                                      .setUri(imageURI)
                                      //设置点击重试是否开启
                                      .setTapToRetryEnabled(true)
                                      //设置旧的Controller
                                      .setOldController(draweeView1.getController())
                                      //构建
                                      .build();
        //设置Controller
        draweeView1.setController(controller);

        /**淡入淡出动画*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_fade));
        draweeView.setImageURI(Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2440305671,4126191952&fm=23&gp=0.jpg"));

        /**叠加图*/
        draweeView = ((SimpleDraweeView) findViewById(R.id.drawee_overlay));
        draweeView.setImageURI(Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490161023&di=fdc9471f337dd66b1f2f3698ab979377&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201607%2F20160702004.jpg"));
    }
}
