package com.viger.gf_bdj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/26.
 */

public class LaunchActivity extends Activity {

    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    private ScheduledExecutorService scheduledExecutorService;
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        Log.d("tag", "start app==>");
        objectAnimator = ObjectAnimator.ofFloat(ivSplash, "alpha", 0.0f, 1.0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(LaunchActivity.this, "动画结束监听进入主页", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
    }

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LaunchActivity.this, "定时器进入主页", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
