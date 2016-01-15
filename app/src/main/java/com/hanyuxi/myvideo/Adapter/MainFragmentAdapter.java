package com.hanyuxi.myvideo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by º«ÏÈÉ­ on 2015/11/13.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    public MainFragmentAdapter(FragmentManager fm ,ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }



    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
