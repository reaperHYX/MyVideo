package com.hanyuxi.myvideo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanyuxi.myvideo.R;

/**
 * Created by hanyu on 2015/12/25.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        back();
        register();
    }

    //注册新用户
    private void register() {
        TextView tv_register = (TextView) findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);//跳转界面
            }
        });
    }

    //返回上一页
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
