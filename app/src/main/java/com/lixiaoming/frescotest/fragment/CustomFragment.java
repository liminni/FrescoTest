package com.lixiaoming.frescotest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.activity.GifImageActivity;
import com.lixiaoming.frescotest.activity.PhotoViewActivity;
import com.lixiaoming.frescotest.activity.SubsamplingScaleImageActivity;
import com.lixiaoming.frescotest.adapter.CustomListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class CustomFragment extends Fragment implements View.OnClickListener {

    private View view;

    private List<String> data;
    private CustomListViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_custom,container,false);

        initData();
        initView();

        return view;
    }

    private void initData() {
        data = new ArrayList<>();
        data.clear();
        data.add("photoView");
        data.add("SubsamplingScaleImageView");
        data.add("GifImageView & GifDrawable");
    }

    private void initView() {
        ListView listView = ((ListView) view.findViewById(R.id.custom_listview));
        adapter = new CustomListViewAdapter(getActivity(), data);
        listView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = ((int) view.getTag());
        Intent intent = null;
        switch (data.get(position)){
            case "photoView":
                intent = new Intent(getActivity(), PhotoViewActivity.class);
                break;
            case "SubsamplingScaleImageView":
                intent = new Intent(getActivity(), SubsamplingScaleImageActivity.class);
                break;
            case "GifImageView & GifDrawable":
                intent = new Intent(getActivity(), GifImageActivity.class);
                break;
        }
        startActivity(intent);
    }
}
