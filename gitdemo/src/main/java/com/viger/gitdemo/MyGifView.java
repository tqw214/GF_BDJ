package com.viger.gitdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/23.
 */

public class MyGifView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder mHolder;
    private Movie mMovie;
    private float gifScale = 2.0f;

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Canvas canvas = mHolder.lockCanvas();
            canvas.save();
            canvas.scale(gifScale,gifScale);
            //绘制图片
            mMovie.draw(canvas,0,0);
            //切换每一帧
            mMovie.setTime((int) (System.currentTimeMillis() % mMovie.duration()));
            canvas.restore();
            //解锁画布
            mHolder.unlockCanvasAndPost(canvas);
            mHandler.postDelayed(mRunnable, 50);
            Log.d("tag","run==>"+(int) (System.currentTimeMillis() % mMovie.duration()));
        }
    };

    public MyGifView(Context context) {
        this(context, null);
    }

    public MyGifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        GifHttpUtils.downloadGif(new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(InputStream result) {
                //Bitmap bitmap = BitmapFactory.decodeStream(result);
               // mMovie = Movie.decodeStream(result);
            }
        });
    }

    private void playGif(byte[] bytes) {
        mMovie = Movie.decodeByteArray(bytes, 0, bytes.length);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //创建
        try {
            InputStream inputStream = getResources().getAssets().open("wo.gif");
            mMovie = Movie.decodeStream(inputStream);
            int width = (int) (mMovie.width() * gifScale);
            int height = (int) (mMovie.height() * gifScale);
            this.setMeasuredDimension(width, height);
            mHandler.post(mRunnable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        //更新

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //销毁

    }
}
