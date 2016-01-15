package com.hanyuxi.myvideo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.hanyuxi.myvideo.Bean.VedioPlayBean;
import com.hanyuxi.myvideo.R;

import java.util.ArrayList;

/**
 * Created by hanyu on 2016/1/8.
 */
public class VideoPlayActivity extends Activity {
    private String url = "";
    private VideoView vv_play;
    private VedioPlayBean bean = new VedioPlayBean();
    private TextView tv_video_play_1,tv_video_play_2,tv_video_play_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        getData();
        initView();
    }

    private void getData() {
        Intent intent = getIntent();
        bean = (VedioPlayBean) intent.getSerializableExtra("videoBean");
        url=bean.getHls_url();
        Log.e("video play",url);
    }

    //加载控件
    private void initView() {
        Uri uri = Uri.parse(url);
        vv_play = (VideoView) findViewById(R.id.vv_play);
        vv_play.setMediaController(new MediaController(this));
        vv_play.setVideoURI(uri);
        vv_play.requestFocus();
        tv_video_play_1= (TextView) findViewById(R.id.tv_video_play_1);
        tv_video_play_2= (TextView) findViewById(R.id.tv_video_play_2);
        tv_video_play_3= (TextView) findViewById(R.id.tv_video_play_3);
        tv_video_play_1.setText(getString(R.string.tv_video_play_1)+bean.getPlay_channel());
        tv_video_play_2.setText(getString(R.string.tv_video_play_2)+bean.getF_pgmtime());
        tv_video_play_3.setText(getString(R.string.tv_video_play_3)+bean.getTitle()+"\n"+bean.getTag());
    }
}
