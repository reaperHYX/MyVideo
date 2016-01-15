package com.hanyuxi.myvideo.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hanyuxi.myvideo.R;

/**
 * Created by hanyu on 2015/12/27.
 */
public class RegisterCompleteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complete);
        back();
        complete();
    }

    //注册完成跳转
    private void complete() {
        Button bt_register_complete = (Button) findViewById(R.id.bt_register_complete);
        bt_register_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCompleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void back() {
        RelativeLayout relativeLayoutBack = (RelativeLayout) findViewById(R.id.rl_back);
        relativeLayoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//返回上一页
            }
        });
    }
}
