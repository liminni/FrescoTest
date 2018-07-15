package com.lixiaoming.frescotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaoming on 17/3/15.
 */

public class RecycleFragement extends Fragment {

    private View view;

    private static String BUNDLE_INDEX = "BUNDLE_INDEX";

    private int index;

    private List<String> data;

    public static RecycleFragement newInstance(int index) {
        RecycleFragement fragement = new RecycleFragement();
        Bundle arg = new Bundle();
        arg.putInt(BUNDLE_INDEX, index);
        fragement.setArguments(arg);
        return fragement;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(BUNDLE_INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recycler, container, false);
        initData();
        initView(index);
        return view;
    }

    private void initData() {
        data = new ArrayList<>();
        data.clear();
        data.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3861177005,4191933452&fm=23&gp=0.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490164118&di=f4db0ce1decf64dc474f7816b2706f1d&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1606%2F16%2Fc4%2F22908462_1466047757553.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4286792526,3366985205&fm=23&gp=0.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577385548&di=4c40d41775ac465448e033dbd9ce7f7a&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1606%2F16%2Fc4%2F22908419_1466047759505.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577385547&di=74cf7a921f05b85e4f57e18570aed5e7&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F57a15493df3a2.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577385547&di=7fab14a98498b8817e9ee54374b0c8d2&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2Fimgzone%2Fjfs%2Ft1360%2F148%2F312232934%2F217640%2F76d6790d%2F5571840fNc0b454a1.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=663640211,3865518564&fm=23&gp=0.jpg");
        data.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1885985695,1728737400&fm=23&gp=0.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489569485856&di=8beda0e9ed1f8df7fd7ef2551c48391c&imgtype=0&src=http%3A%2F%2Fpic6.wed114.cn%2F20110504%2F20110504092800830544.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490164215&di=3436742ad8f9838f63ff85ca13361f99&imgtype=jpg&er=1&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20151204%2F1440x900_a57000139dd08a2.jpg");
        data.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3291422869,959233357&fm=23&gp=0.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489569528853&di=ef592921dcda0b5d3af98248b444674f&imgtype=0&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20151204%2F1440x900_dfe11b0ff2127a8.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490172103&di=f72ad34d231818c3efe4bc02f6f7f371&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1606%2F16%2Fc4%2F22908502_1466047790062_mthumb.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577385546&di=b849fa8cdbb7af4cdd85c25d3f93282c&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1606%2F16%2Fc4%2F22908326_1466047725255_mthumb.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577385542&di=26232e7b37ed404abb1915cc7d407595&imgtype=0&src=http%3A%2F%2Fimg0.pconline.com.cn%2Fpconline%2Ftest%2F2014%2Ffunction%2Fdp%2F1409%2F14_1.jpg");
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1087601952,3102591664&fm=23&gp=0.jpg");
        data.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1852131669,1354754905&fm=11&gp=0.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577487588&di=c597d8ef41923fa42e11e0c1c08bee03&imgtype=0&src=http%3A%2F%2Fwww.sh.xinhuanet.com%2F135365954_14634744145361n.jpg");
        data.add(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577514833&di=19b9a85e93ca3b748c35fbe6c2fea347&imgtype=0&src=http%3A%2F%2Fdynamic-image.yesky.com%2F600x-%2FuploadImages%2Fupload%2F20140822%2Fupload%2F201408%2Fasvdeeudq3ojpg.jpg");
    }

    private void initView(int index) {
        RecyclerView recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerView));
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(index, StaggeredGridLayoutManager.VERTICAL);
        RecycleViewAdapter adapter = new RecycleViewAdapter(data, getActivity());
        recyclerView.setLayoutManager(manager);
        // recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
    }
}
