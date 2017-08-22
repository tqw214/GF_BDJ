package com.viger.gf_bdj.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyGifView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder;
    private Movie movie;
    //通过线程进行播放gif
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //循环播放gif每一帧
            Canvas canvas = getHolder().lockCanvas();
            canvas.save();
            movie.draw(canvas,0,0);
            //切换每一帧
            movie.setTime((int) (System.currentTimeMillis() % movie.duration()));
            canvas.restore();
            surfaceHolder.unlockCanvasAndPost(canvas);
            handler.postDelayed(runnable,50);
        }
    };

    public MyGifView(Context context) {
        super(context);
        initParams();
    }

    public MyGifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    private void initParams() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //创建
        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open("wo.gif");
            //媒体类
            movie = Movie.decodeStream(inputStream);
            handler.post(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) inputStream.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
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
