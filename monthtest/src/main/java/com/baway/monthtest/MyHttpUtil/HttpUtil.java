package com.baway.monthtest.MyHttpUtil;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:请求
 */
public class HttpUtil {
    public static String getString(String surl){
        try {
            URL url = new URL(surl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //请求方法
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            //请求成功
            if (connection.getResponseCode()==200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                String str="";
                //添加
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                reader.close();
                //关闭流
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public interface getASC{
        void getS(String s);
    }
    public static void getASS(String surl,final getASC asc){
        //异步
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getString(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                asc.getS(s);
            }
        }.execute(surl);
        //回调
    }
}
