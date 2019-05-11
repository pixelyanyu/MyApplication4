package com.example.yklianxi2.MyAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yklianxi2.MyBean.LvBean;
import com.example.yklianxi2.R;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class LvAdapter extends BaseAdapter {
    private ArrayList<LvBean> lvBeans;
    private Context context;

    public LvAdapter(ArrayList<LvBean> lvBeans, Context context) {
        this.lvBeans = lvBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lvBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(getItemViewType(position)==0){
            MyHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(context, R.layout.item1,null);
                holder=new MyHolder();
                holder.textView=convertView.findViewById(R.id.tv1);
                holder.imageView=convertView.findViewById(R.id.iv1);
                convertView.setTag(holder);
            }else{
                holder= (MyHolder) convertView.getTag();
            }
            holder.textView.setText(lvBeans.get(position).getName());
            Glide.with(context).load(lvBeans.get(position).getImageUrl()).into(holder.imageView);
        }else if(getItemViewType(position)==1){
            MyHolder2 holder2=null;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.item2,null);
                holder2=new MyHolder2();
                holder2.textView=convertView.findViewById(R.id.tv2);
                holder2.imageView=convertView.findViewById(R.id.iv2);
                convertView.setTag(holder2);
            }else {
                holder2= (MyHolder2) convertView.getTag();
            }
            holder2.textView.setText(lvBeans.get(position).getName());
            Glide.with(context).load(lvBeans.get(position).getImageUrl()).into(holder2.imageView);
        }
        return convertView;
    }
    class MyHolder{
        ImageView imageView;
        TextView textView;
    }
    class MyHolder2{
        ImageView imageView;
        TextView textView;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
