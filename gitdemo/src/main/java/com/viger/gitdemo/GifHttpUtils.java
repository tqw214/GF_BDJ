package com.viger.gitdemo;

/**
 * Created by Administrator on 2017/8/23.
 */

public class GifHttpUtils {

    public static void downloadGif(HttpUtils.OnHttpResultListener onHttpResultListener) {
        HttpTask httpTask = new HttpTask("http://", onHttpResultListener);
        httpTask.execute();
    }

}
