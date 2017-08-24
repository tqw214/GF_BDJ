package com.viger.gitdemo;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2017/8/23.
 */

public class GifHttpUtils {

    public static void downloadGif(HttpUtils.OnHttpResultListener onHttpResultListener) {
        HttpTask httpTask = new HttpTask("http://", onHttpResultListener);
        httpTask.execute();
    }

    /**
     * bitmap转byte
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        return bos.toByteArray();
    }

}
