package com.baway.monthtest.MyBase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baway.monthtest.R;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:Base类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        getById();
        getData();
        getEvent();
    }
    //获取布局
    public abstract int getView();
    //获取ID控件
    public abstract void getById();
    //获取数据
    public abstract void getData();
    //获取事件
    public abstract void getEvent();



}
