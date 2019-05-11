package com.example.yklianxi2;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.example.yklianxi2.MyAdapter.FragmentAdapter;
import com.example.yklianxi2.MyFrag.Frag1;
import com.example.yklianxi2.MyFrag.Frag2;
import com.example.yklianxi2.MyFrag.Frag3;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> list;
    private ImageView img;

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void getById() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);
        this.img.setOnClickListener(this);
        findViewById(R.id.rb1).setOnClickListener(this);
        findViewById(R.id.rb2).setOnClickListener(this);
        findViewById(R.id.rb3).setOnClickListener(this);


        list = new ArrayList<>();
        list.add(new Frag1());
        list.add(new Frag2());
        list.add(new Frag3());
        vp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),list));
    }

    @Override
    public void getBase() {

    }

    @Override
    public void getEvent() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.rb1){
            vp.setCurrentItem(0);
        }else if(v.getId()==R.id.rb2){
            vp.setCurrentItem(1);
        }else if(v.getId()==R.id.rb3){
            vp.setCurrentItem(2);
        }else if(v.getId()==R.id.img){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            Uri uri = data.getData();
            Glide.with(MainActivity.this).load(uri).into(img);
        }
    }
}
