package com.viger.gf_bdj.http.utils;

import android.os.AsyncTask;
import com.viger.gf_bdj.http.IHttpCommand;
import com.viger.gf_bdj.http.IRequestParam;
/**
 * Created by Administrator on 2017/8/8.
 */

public class HttpTask extends AsyncTask<String, Void, String> {

    private String url;
    private IRequestParam requestParam;
    private HttpUtils.OnHttpResultListener onHttpResultListener;
    private IHttpCommand httpCommand;

    public HttpTask(String url, IRequestParam requestParam,
                    IHttpCommand httpCommand, HttpUtils.OnHttpResultListener onHttpResultListener) {
        this.url = url;
        this.requestParam = requestParam;
        this.httpCommand = httpCommand;
        this.onHttpResultListener = onHttpResultListener;
    }


    @Override
    protected String doInBackground(String... strings) {
        return httpCommand.execute(url, requestParam);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(this.onHttpResultListener != null) {
            onHttpResultListener.onResult(s);
        }
    }
}
