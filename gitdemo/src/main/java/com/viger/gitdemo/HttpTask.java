package com.viger.gitdemo;

import android.os.AsyncTask;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/23.
 */

public class HttpTask extends AsyncTask<String, Void, InputStream> {

    private String url;
    private HttpUtils.OnHttpResultListener onHttpResultListener;

    public HttpTask(String url, HttpUtils.OnHttpResultListener listener) {
        this.url = url;
        this.onHttpResultListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        return HttpUtils.get(url);
    }

    @Override
    protected void onPostExecute(InputStream input) {
        super.onPostExecute(input);
        if(onHttpResultListener != null) {
            onHttpResultListener.onResult(input);
        }
    }

}
