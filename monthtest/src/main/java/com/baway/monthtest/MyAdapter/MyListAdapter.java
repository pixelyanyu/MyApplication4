package com.baway.monthtest.MyAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.monthtest.Bean.ListBean;
import com.baway.monthtest.MyBase.BaseActivity;
import com.baway.monthtest.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class MyListAdapter extends BaseAdapter
{
    private ArrayList<ListBean> list;
    private Context context;

    public MyListAdapter(ArrayList<ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        if (getItemViewType(position)==0) {//如果是0
            MyHodle hodle=null;
            if(convertView==null){
                convertView=View.inflate(context, R.layout.item1,null);
                hodle=new MyHodle();
                hodle.textView1=convertView.findViewById(R.id.item1_tv);
                hodle.imageView1=convertView.findViewById(R.id.item1_iv);
                convertView.setTag(hodle);
            }else{
                hodle= (MyHodle) convertView.getTag();
            }
            hodle.textView1.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getImageUrl()).into(hodle.imageView1);
        }else if(getItemViewType(position)==1){//如果是1
            MyHodle2 hodle2=null;
            if(convertView==null){
                convertView=View.inflate(context, R.layout.item2,null);
                hodle2=new MyHodle2();
                hodle2.textView2=convertView.findViewById(R.id.item2_tv);
                hodle2.imageView2=convertView.findViewById(R.id.item2_iv);
                convertView.setTag(hodle2);
            }else{
                hodle2= (MyHodle2) convertView.getTag();
            }
            hodle2.textView2.setText(list.get(position).getName());
            Glide.with(context).load(list.get(position).getImageUrl()).into(hodle2.imageView2);
        }
        return convertView;
    }
    class MyHodle{
        ImageView imageView1;
        TextView textView1;
    }
    class MyHodle2{
        ImageView imageView2;
        TextView textView2;
    }

    @Override//下标
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override//总量
    public int getViewTypeCount() {
        return 2;
    }
}
