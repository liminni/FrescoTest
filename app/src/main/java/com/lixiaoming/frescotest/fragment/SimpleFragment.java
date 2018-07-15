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
import com.lixiaoming.frescotest.activity.BasicUsageActivity;
import com.lixiaoming.frescotest.activity.BlurActivity;
import com.lixiaoming.frescotest.activity.ListViewUsageActivity;
import com.lixiaoming.frescotest.activity.RecyclerViewUsageActivity;
import com.lixiaoming.frescotest.adapter.SimpleListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class SimpleFragment extends Fragment implements View.OnClickListener {

    private View view;

    private List<String> data;
    private SimpleListViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_simple,container,false);

        initData();
        initView();

        return view;
    }

    private void initView() {
        ListView listView = ((ListView) view.findViewById(R.id.simple_listview));
        adapter = new SimpleListViewAdapter(getActivity(), data);
        listView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    private void initData() {
        data= new ArrayList<>();
        data.clear();
        data.add("basic use");
        data.add("listview use");
        data.add("RecycleView use");
        data.add("Blur use");
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Intent intent = null;
        switch (data.get(position)){
            case "basic use":
                intent = new Intent(getActivity(), BasicUsageActivity.class);
                break;
            case "listview use":
                intent = new Intent(getActivity(), ListViewUsageActivity.class);
                break;
            case "RecycleView use":
                intent = new Intent(getActivity(), RecyclerViewUsageActivity.class);
                break;
            case "Blur use":
                intent = new Intent(getActivity(), BlurActivity.class);
                break;
        }
        getActivity().startActivity(intent);
    }
}
