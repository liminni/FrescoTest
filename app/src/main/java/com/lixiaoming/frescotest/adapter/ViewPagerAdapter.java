package com.lixiaoming.frescotest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lixiaoming on 17/3/14.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> pages;
    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setFragments(List<Fragment> fragmentList,List<String> pages){
        this.fragmentList = fragmentList;
        this.pages = pages;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position);
    }
}
