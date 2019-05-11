package com.baway.monthtest.MyFrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.baway.monthtest.Bean.ListBean;
import com.baway.monthtest.MyAdapter.MyListAdapter;
import com.baway.monthtest.MyHttpUtil.HttpUtil;
import com.baway.monthtest.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:页面1
 */
public class Frag1 extends Fragment {

    private PullToRefreshListView lv;
    private int page=1;
    private ArrayList<ListBean> list;
    private MyListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        lv = view.findViewById(R.id.lv);
        list = new ArrayList<>();
        lv.setMode(PullToRefreshBase.Mode.BOTH);//设置模式
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //吐司时间
                Toast.makeText(getContext(),""+System.currentTimeMillis(),Toast.LENGTH_SHORT).show();
            }
        });
        //监听上划下拉
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtil.getASS("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3&page="+ ++page, new HttpUtil.getASC() {
                    @Override
                    public void getS(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray result = object.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject o = (JSONObject) result.get(i);
                                String imageUrl = o.getString("imageUrl");
                                String name = o.getString("name");
                                list.add(new ListBean(imageUrl,name));
                            }
                            //刷新适配器
                            adapter.notifyDataSetChanged();
                            //停止刷新
                            lv.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtil.getASS("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3&page="+ ++page, new HttpUtil.getASC() {
                    @Override
                    public void getS(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray result = object.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject o = (JSONObject) result.get(i);
                                String imageUrl = o.getString("imageUrl");
                                String name = o.getString("name");
                                list.add(new ListBean(imageUrl,name));
                                //添加
                            }
                            adapter.notifyDataSetChanged();
                            lv.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
        HttpUtil.getASS("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3&page="+page, new HttpUtil.getASC() {
            @Override
            public void getS(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray result = object.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject o = (JSONObject) result.get(i);
                        String imageUrl = o.getString("imageUrl");
                        String name = o.getString("name");
                        list.add(new ListBean(imageUrl,name));
                        //添加
                    }
                    adapter = new MyListAdapter(list, getContext());
                    lv.setAdapter(adapter);
                    //设置适配器
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }
}
