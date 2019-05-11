package com.example.yklianxi2.MyFrag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yklianxi2.Listvv;
import com.example.yklianxi2.MyAdapter.LvAdapter;
import com.example.yklianxi2.MyBean.ImageBean;
import com.example.yklianxi2.MyBean.LvBean;
import com.example.yklianxi2.MyHttpUtil.httpUtil;
import com.example.yklianxi2.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class Frag01 extends Fragment {

    private Banner banner;
    private ListView lv;
    private ArrayList<ImageBean> imageBeans;
    private ArrayList<LvBean> lvBeans;
    private LvAdapter adapter;
    private PullToRefreshScrollView rl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);
        banner = view.findViewById(R.id.banner);
        lv = view.findViewById(R.id.lv);
        rl = view.findViewById(R.id.rl);

        rl.setMode(PullToRefreshBase.Mode.BOTH);
        rl.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                httpUtil.getAsy("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5", new httpUtil.getAcc() {
                    @Override
                    public void getS(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray result = object.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject o = (JSONObject) result.get(i);
                                String imageUrl = o.getString("imageUrl");
                                String name = o.getString("name");
                                lvBeans.add(new LvBean(imageUrl,name));
                            }
                            adapter.notifyDataSetChanged();
                            rl.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                httpUtil.getAsy("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5", new httpUtil.getAcc() {
                    @Override
                    public void getS(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray result = object.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject o = (JSONObject) result.get(i);
                                String imageUrl = o.getString("imageUrl");
                                String name = o.getString("name");
                                lvBeans.add(new LvBean(imageUrl,name));
                            }
                            adapter.notifyDataSetChanged();
                            rl.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
/*
                httpUtil.getAsy("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5", new httpUtil.getAcc() {
                    @Override
                    public void getS(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray result = object.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject o = (JSONObject) result.get(i);
                                String imageUrl = o.getString("imageUrl");
                                String name = o.getString("name");
                                lvBeans.add(new LvBean(imageUrl,name));
                            }
                            adapter.notifyDataSetChanged();
                            lv.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
*/
        httpUtil.getAsy("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=5", new httpUtil.getAcc() {
            @Override
            public void getS(String s) {
                try {
                    imageBeans = new ArrayList<>();
                    lvBeans = new ArrayList<>();
                    JSONObject object = new JSONObject(s);
                    JSONArray result = object.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject o = (JSONObject) result.get(i);
                        String imageUrl = o.getString("imageUrl");
                        String name = o.getString("name");
                        lvBeans.add(new LvBean(imageUrl,name));
                        imageBeans.add(new ImageBean(imageUrl));
                        banner.setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                ImageBean bean= (ImageBean) path;
                                Glide.with(getContext()).load(bean.getImageUrl()).into(imageView);
                            }
                        });
                    }
                    adapter = new LvAdapter(lvBeans, getContext());
                    lv.setAdapter(adapter);
                    banner.setDelayTime(3000);
                    banner.setImages(imageBeans);
                    banner.isAutoPlay(true);
                    banner.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }
}
