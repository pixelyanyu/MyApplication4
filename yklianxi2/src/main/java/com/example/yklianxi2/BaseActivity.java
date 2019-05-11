package com.example.yklianxi2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.*;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());

        getById();
        getBase();
        getEvent();
    }
    public abstract int getView();

    public abstract void getById();

    public abstract void getBase();

    public abstract void getEvent();

    public void getToast(String s){
        Toast.makeText(BaseActivity.this,s, LENGTH_SHORT).show();
    }
}
