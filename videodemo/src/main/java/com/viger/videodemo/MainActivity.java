package com.viger.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaController mediaController = new MediaController(this);
        videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setVideoPath("http://bvideo.spriteapp.cn/video/2016/0529/574ab115bfe65cut_wpd.mp4");
        videoView.setMediaController(mediaController);

        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();

    }
}
