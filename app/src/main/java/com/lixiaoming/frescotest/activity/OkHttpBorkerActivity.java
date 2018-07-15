package com.lixiaoming.frescotest.activity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.bean.HttpDownloadBean;
import com.lixiaoming.frescotest.util.MyHttpUtil;
import com.lixiaoming.frescotest.util.SharePreferenceUtils;
import com.socks.library.KLog;

public class OkHttpBorkerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_downProgress;

    private String url = "http://gdown.baidu.com/data/wisegame/c5ada0a2f33be088/baidushoujizhushouyuan91zhu_16792523.apk";

    private MyHttpUtil myHttpUtil;

    private HttpDownloadBean mHttpDownloadBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_borker);
        SharePreferenceUtils.getAppConfig(this);
        initView();
    }

    private void initView() {
        ((Button) findViewById(R.id.btn_start1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_pause1)).setOnClickListener(this);
        tv_downProgress = (TextView) findViewById(R.id.tv_downProgress);

        myHttpUtil = MyHttpUtil.getInstance(this);
        mHttpDownloadBean = new HttpDownloadBean();
        mHttpDownloadBean.setUrl(url);
        mHttpDownloadBean.setFilepath(url.substring(url.lastIndexOf("/")));
        mHttpDownloadBean.setStoragepath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/zhang");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btn_start1:
           final Handler handler = new Handler();
            myHttpUtil.download(mHttpDownloadBean, new MyHttpUtil.DownloadCallBack() {
                @Override
                public void download(String current_progress, String total_progress) {
                    KLog.d("current_progress:"+current_progress+",--total_progress:"+total_progress);
                }

                @Override
                public void downloadprogress(final int progress) {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_downProgress.setText("下载进度："+progress+"%");
                        }
                    });
                }
            });

            break;
        case R.id.btn_pause1:
            myHttpUtil.pause(mHttpDownloadBean);
            break;
        }
    }
}
