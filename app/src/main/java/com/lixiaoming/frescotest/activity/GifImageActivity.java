package com.lixiaoming.frescotest.activity;

import android.os.Bundle;
import android.util.Log;

import com.lixiaoming.frescotest.util.fresco.ImageDownloadListener;
import com.lixiaoming.frescotest.util.fresco.gifimageview.CustomGifImageView;

public class GifImageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gif_image);
        CustomGifImageView gifView = new CustomGifImageView(this);
        gifView.setImageDownloadListener(new ImageDownloadListener() {
            @Override
            public void onUpdate(int progress) {
                Log.d("GifImageViewActivity","[onCreate][onUpdate] progress = " + progress );
            }
        });
        setContentView(gifView);
        gifView.setImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=431821665,3271102547&fm=23&gp=0.jpg");
    }
}
