package com.baway.monthtest.MyFrag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.monthtest.R;
import com.baway.monthtest.web;
import com.bumptech.glide.Glide;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:页面2
 */
public class Frag2 extends Fragment implements View.OnClickListener {

    private TextView tv;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);
        tv = view.findViewById(R.id.ttv);
        img = view.findViewById(R.id.img);
        this.img.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.img) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            //打开图库
            intent.setType("image/*");
            startActivityForResult(intent,0);
        }else if(v.getId()==R.id.ttv){
            Intent intent = new Intent(getContext(), web.class);
            startActivity(intent);
            //跳转到web
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0) {
            Uri uri = data.getData();
            //回传
            Glide.with(getContext()).load(uri).into(img);
            //设置图片
        }
    }
}
