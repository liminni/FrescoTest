package com.lixiaoming.frescotest.activity;

import android.os.Bundle;

import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.util.fresco.subscaleview.SubsamplingScaleImageView;

public class SubsamplingScaleImageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subsampling_scale_image);
        SubsamplingScaleImageView scaleImageView = (SubsamplingScaleImageView) findViewById(R.id.SubsamplingScaleImage);
        scaleImageView.setImageUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489753691286&di=05ba50e8ac9e071889b30ecd651bc107&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201207%2F13%2F20120713191526_sQW8N.thumb.224_0.jpeg");
    }
}
