package com.lixiaoming.frescotest.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lixiaoming.frescotest.R;

import java.util.List;

import static android.R.attr.id;


public class BlurActivity extends BaseActivity {

    private String blur_url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490599436&di=2bd3ee0eb3adf747168b2224d1272718&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F12.jpg";
    private String circle_url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490599496&di=7ce0bdca5329f246dc7e74929ec7a5a1&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F12%2F90%2F36k58PICzSn_1024.jpg";
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);
        initView();
    }


    private void initView() {
        SimpleDraweeView blur_simple_drawee = ((SimpleDraweeView) findViewById(R.id.blur_simple_drawee));
        SimpleDraweeView circle_simple_drawee = ((SimpleDraweeView) findViewById(R.id.circle_simple_drawee));
        showBlurUrl(blur_simple_drawee, blur_url, 4, 6);
        circle_simple_drawee.setImageURI(Uri.parse(blur_url));
        tv = ((TextView) findViewById(R.id.tv));
    }

    /**
     * 高斯模糊
     * @param blur_simple_drawee 控件
     * @param url   url
     * @param iterations  迭代次数  迭代次数越多 越模糊
     * @param blurRadius  模糊半径  半径必须大于0，越大越模糊
     */
    public void showBlurUrl(SimpleDraweeView blur_simple_drawee, String url, int iterations, int blurRadius) {
        try {

            Uri uri = Uri.parse(url);
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                    .setPostprocessor(new IterativeBoxBlurPostProcessor(iterations, blurRadius)).build();
            AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setOldController(blur_simple_drawee.getController()).setImageRequest(request).build();
            blur_simple_drawee.setController(controller);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
