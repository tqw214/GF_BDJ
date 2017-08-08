package com.viger.gf_bdj.http.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/7.
 */

public class HttpUtils {

    public static String get(String urlStr) {
        String result = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            if(connection.getResponseCode() == 200) {
                InputStream inStream = connection.getInputStream();
                result = new String(StreamTool.readInputStream(inStream));
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String post(String urlStr, Map<String, Object> paramMap) throws Exception {
        StringBuffer sb = null;
        StringBuilder params = new StringBuilder();
        int i=0;
        for(String key : paramMap.keySet()) {
            Object value = paramMap.get(key);
            params.append(key);
            params.append("=");
            params.append(value);
            if(i < paramMap.size() -1) {
                params.append("&");
            }
            i++;
        }

        URL url = new URL(urlStr);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setUseCaches(false);
        httpConn.setRequestProperty("Charset", "UTF-8");
        httpConn.connect();
        DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
        dos.writeBytes(params.toString());
        dos.flush();
        dos.close();
        int resultCode = httpConn.getResponseCode();
        sb = new StringBuffer();
        if(HttpURLConnection.HTTP_OK == resultCode) {
            String readLine = new String();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            while((readLine = responseReader.readLine())!=null) {
                sb.append(readLine).append("\n");
            }
            responseReader.close();
            return sb.toString();
        }
        return null;
    }

    public interface OnHttpResultListener {
        public void onResult(String result);
    }

}
