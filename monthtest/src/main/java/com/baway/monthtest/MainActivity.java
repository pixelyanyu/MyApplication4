package com.baway.monthtest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.baway.monthtest.MyAdapter.FragAdapter;
import com.baway.monthtest.MyBase.BaseActivity;
import com.baway.monthtest.MyFrag.Frag1;
import com.baway.monthtest.MyFrag.Frag2;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list;

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void getById() {
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
    }

    @Override
    public void getData() {
        list = new ArrayList<>();
    }

    @Override
    public void getEvent() {
        //设置tab标题
        tab.addTab(tab.newTab().setText("首页"));
        tab.addTab(tab.newTab().setText("我的"));
        list.add(new Frag1());
        list.add(new Frag2());
        //添加到 list
        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            //选定标签
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //选定pager
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab.setScrollPosition(vp.getCurrentItem(),0,false);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //设置适配器
        vp.setAdapter(new FragAdapter(getSupportFragmentManager(),list));

    }
}
