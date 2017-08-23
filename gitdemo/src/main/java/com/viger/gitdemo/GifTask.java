package com.viger.gitdemo;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by Administrator on 2017/8/23.
 */

public class GifTask extends AsyncTask<String, Void, Bitmap> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

}
