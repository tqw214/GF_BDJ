package com.viger.gitdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/8/23.
 */

public class MyGifView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder mHolder;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Canvas canvas = mHolder.lockCanvas();
            canvas.save();

            mHolder.unlockCanvasAndPost(canvas);
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
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //创建
        handler.post(runnable);
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
