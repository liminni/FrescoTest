package com.lixiaoming.frescotest.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.adapter.ViewPagerAdapter;
import com.lixiaoming.frescotest.fragment.AndroidPickerViewFragment;
import com.lixiaoming.frescotest.fragment.CustomFragment;
import com.lixiaoming.frescotest.fragment.GlideFragment;
import com.lixiaoming.frescotest.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments;

    private List<String> pages;

    private ViewPagerAdapter adapter;

    private String TAG = "fate";
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        initData();
        initView();

    }
    private void getData() {
        Intent i_getvalue = getIntent();
        String action = i_getvalue.getAction();

        if(Intent.ACTION_VIEW.equals(action)){
            Uri uri = i_getvalue.getData();
            if(uri != null){
                name = uri.getQueryParameter("name");
                String age= uri.getQueryParameter("age");
            }

        }
    }

    private void initData() {
        pages = new ArrayList<>();
        pages.clear();
        pages.add("SIMPLE");
        pages.add("CUSTOM");
        pages.add("PICKERVIEW");
        pages.add("GLIDE");

        fragments = new ArrayList<>();
        fragments.clear();
        fragments.add(new SimpleFragment());
        fragments.add(new CustomFragment());
        fragments.add(new AndroidPickerViewFragment());
        fragments.add(new GlideFragment());

    }

    private void initView() {
        Toolbar toolbar = ((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Fresco Demo");
        getSupportActionBar().setTitle(name);

        TabLayout tabLayout = ((TabLayout) findViewById(R.id.tablayout));
        // tabLayout.setTabMode(TabLayout.MODE_FIXED);//当tab太多，超出屏幕范围是可以设置为mode_scrollable
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);// 当tab比较少，不会超出屏幕，则可以设置为mode_fixed
        ViewPager viewPager = ((ViewPager) findViewById(R.id.viewPager));
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments, pages);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);

    }

}
