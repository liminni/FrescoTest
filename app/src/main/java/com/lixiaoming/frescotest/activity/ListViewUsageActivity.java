package com.lixiaoming.frescotest.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.adapter.ListViewUsageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewUsageActivity extends BaseActivity {

    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_list_view_usage);
        initData();
        initView();
    }

    private void initView() {
        ListView listView = ((ListView) findViewById(R.id.listview_usage));
        listView.setAdapter(new ListViewUsageAdapter(data,this));
    }

    private void initData() {
        data = new ArrayList<>();
        data.clear();
        data.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3861177005,4191933452&fm=23&gp=0.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490164118&di=f4db0ce1decf64dc474f7816b2706f1d&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1606%2F16%2Fc4%2F22908462_1466047757553.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4286792526,3366985205&fm=23&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=663640211,3865518564&fm=23&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1885985695,1728737400&fm=23&gp=0.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489569485856&di=8beda0e9ed1f8df7fd7ef2551c48391c&imgtype=0&src=http%3A%2F%2Fpic6.wed114.cn%2F20110504%2F20110504092800830544.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490164215&di=3436742ad8f9838f63ff85ca13361f99&imgtype=jpg&er=1&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20151204%2F1440x900_a57000139dd08a2.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3291422869,959233357&fm=23&gp=0.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489569528853&di=ef592921dcda0b5d3af98248b444674f&imgtype=0&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20151204%2F1440x900_dfe11b0ff2127a8.jpg");
    }
}
