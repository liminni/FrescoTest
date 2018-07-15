package com.lixiaoming.frescotest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lixiaoming.frescotest.R;
import com.yanzhenjie.album.Album;

import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    public static final int ACTIVITY_REQUEST_SELECT_PHOTO = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        // 1. 使用默认风格，并指定选择数量：
        // 第一个参数Activity/Fragment； 第二个request_code； 第三个允许选择照片的数量，不填可以无限选择。
        // Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO, 9);

        // 2. 使用默认风格，不指定选择数量：
        // Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO); //
        // 第三个参数不填的话，可以选择无数个。

        // 3. 指定风格，并指定选择数量，如果不想限制数量传入Integer.MAX_VALUE;
        Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO, 9 // 指定选择数量。
                , ContextCompat.getColor(this, R.color.colorPrimary) // 指定Toolbar的颜色。
                , ContextCompat.getColor(this, R.color.colorPrimary)); // 指定状态栏的颜色。
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_SELECT_PHOTO){
           switch (resultCode){
               case RESULT_OK:
                   List<String> lists = Album.parseResult(data);

                   setResult(RESULT_OK,data);
                   finish();
                   break;
               case RESULT_CANCELED:
                   Toast.makeText(this,"用户取消了选择",Toast.LENGTH_LONG).show();
                   break;

           }
        }
    }
}
