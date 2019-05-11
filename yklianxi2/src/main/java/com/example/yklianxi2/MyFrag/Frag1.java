package com.example.yklianxi2.MyFrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yklianxi2.MyAdapter.FragmentAdapter;
import com.example.yklianxi2.R;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class Frag1 extends Fragment {

    private TabLayout tab;
    private ArrayList<Fragment> list;
    private ViewPager vpn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        tab = view.findViewById(R.id.tab);
        vpn = view.findViewById(R.id.vpn);
        tab.addTab(tab.newTab().setText("第一页"));
        tab.addTab(tab.newTab().setText("第二页"));
        tab.addTab(tab.newTab().setText("第三页"));
        list = new ArrayList<>();
        list.add(new Frag01());
        list.add(new Frag02());
        list.add(new Frag03());
        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpn.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vpn.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab.setScrollPosition(vpn.getCurrentItem(),0,false);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        vpn.setAdapter(new FragmentAdapter(getChildFragmentManager(),list));
        return view;
    }
}
