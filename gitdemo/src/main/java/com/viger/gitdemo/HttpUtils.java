package com.viger.gitdemo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/23.
 */

public class HttpUtils {

    public static final String URL_STR = "";

    //返回网络流数据
    public static InputStream get(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8 * 1000);
            conn.setReadTimeout(8 * 1000);
            conn.setDoInput(true);
            //conn.connect();
            if(conn.getResponseCode() == 200) {
                return conn.getInputStream();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface OnHttpResultListener {
        public void onResult(InputStream result);
    }

}
