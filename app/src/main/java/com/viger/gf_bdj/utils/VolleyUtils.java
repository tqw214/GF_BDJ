package com.viger.gf_bdj.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2017/8/16.
 */

public class VolleyUtils {

    public static RequestQueue queue = null;

    public static void loadImage(Context context, NetworkImageView imageView, String url) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
        }
        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache(){

            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });
        imageView.setImageUrl(url, imageLoader);
    }

}
