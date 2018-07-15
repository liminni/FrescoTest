package com.lixiaoming.frescotest.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lixiaoming.frescotest.R;
import com.lixiaoming.frescotest.adapter.ViewPagerAdapter;
import com.lixiaoming.frescotest.fragment.RecycleFragement;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewUsageActivity extends BaseActivity {

    private List<Fragment> fragments;

    private List<String> pages;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_recycler_view_usage);
        initData();
        initView();
    }

    private void initData() {
        pages = new ArrayList<>();
        pages.clear();
        pages.add("大毛");
        pages.add("二毛");
        pages.add("三毛");

        fragments = new ArrayList<>();
        fragments.clear();
        fragments.add(RecycleFragement.newInstance(1));
        fragments.add(RecycleFragement.newInstance(2));
        fragments.add(RecycleFragement.newInstance(3));
    }

    private void initView() {
        Toolbar toolbar = ((Toolbar) findViewById(R.id.toolbar_rv));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("RecycleViewUsage");

        TabLayout tabLayout = ((TabLayout) findViewById(R.id.tablayout_rv));
        ViewPager viewPager = ((ViewPager) findViewById(R.id.viewPager_rv));
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments,pages);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);

    }
}
