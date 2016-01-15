package com.hanyuxi.myvideo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.hanyuxi.myvideo.Bean.ReturnDataBean;
import com.hanyuxi.myvideo.R;
import com.hanyuxi.myvideo.Utils.Url;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;


/**
 * Created by hanyu on 2015/12/27.
 */
public class RegisterActivity extends Activity {
    private String phoneNum = null;
    private String passWord = null;
    private String smsCode = null;
    private EditText et_register_phone_num;
    private String url = null;
    private EditText et_register_sms_num;
    private EditText et_set_password;
    private int stateCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SMSSDK.initSDK(this, "de16a8721e4d", "5ae97791f8c16f677fc16a918923479e");//启动短信验证SDK
        getTextCode();
        next();
        back();
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		联通：130、131、132、152、155、156、185、186
		电信：133、153、180、189、（1349卫通）
		总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    //获取短信验证码
    private void getTextCode() {
        et_register_phone_num = (EditText) findViewById(R.id.et_register_phone_num);
        et_register_sms_num = (EditText) findViewById(R.id.et_register_sms_num);
        et_set_password = (EditText) findViewById(R.id.et_set_password);
        Button bt_register_get_sms_num = (Button) findViewById(R.id.bt_register_get_sms_num);
        //判断电话号码输入是否正确，如果正确请求短信验证码
        bt_register_get_sms_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNum = et_register_phone_num.getText().toString();//获取电话号码
                passWord = et_set_password.getText().toString();//获取密码
                if (isMobileNO(phoneNum) == false) {
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_right_phonenum, Toast.LENGTH_LONG).show();
                } else if (passWord.isEmpty()) {
                    //如果密码为空提示
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_passWord, Toast.LENGTH_LONG).show();
                } else {
                    SMSSDK.getVerificationCode("86", phoneNum.trim(), new OnSendMessageHandler() {
                        @Override
                        public boolean onSendMessage(String s, String s1) {
                            return false;
                        }
                    });
                    Toast.makeText(RegisterActivity.this, R.string.toast_sms_has_send, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //点击下一步按钮的操作
    private void next() {

        //监听下一步按钮
        Button bt_register_next = (Button) findViewById(R.id.bt_register_next);
        bt_register_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsCode = et_register_sms_num.getText().toString();//获取验证码
                //拼接url
                url = Url.URL + "/ShopApp/userAction?action=register&userPhone=" + phoneNum + "&userPassWord=" + passWord + "&smsCode=" + smsCode;
                if (phoneNum.isEmpty()) {
                    //如果手机号为空提示
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_right_phonenum, Toast.LENGTH_LONG).show();
                } else if (passWord.isEmpty()) {
                    //如果密码为空提示
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_passWord, Toast.LENGTH_LONG).show();
                } else if (smsCode.isEmpty()) {
                    //如果验证码为空提示
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_smscode, Toast.LENGTH_LONG).show();
                } else {
                    Ion.with(RegisterActivity.this)
                            .load(url)
                            .as(new TypeToken<ReturnDataBean>() {
                            })
                            .setCallback(new FutureCallback<ReturnDataBean>() {
                                @Override
                                public void onCompleted(Exception e, ReturnDataBean result) {
                                    stateCode = result.getStateCode();
                                    Log.e("返回码", stateCode + "");
                                }
                            });
                    //判断返回值是否正确
                    if (stateCode == 200) {
                        Toast.makeText(RegisterActivity.this, R.string.toast_register_success, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, RegisterCompleteActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, R.string.toast_register_fail, Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }

    //返回
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
