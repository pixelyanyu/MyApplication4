package com.baway.monthtest.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class FragAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public FragAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public FragAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override//下标
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override//数量
    public int getCount() {
        return list.size();
    }
}
