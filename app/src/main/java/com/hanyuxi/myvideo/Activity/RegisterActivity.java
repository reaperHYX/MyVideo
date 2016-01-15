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
        SMSSDK.initSDK(this, "de16a8721e4d", "5ae97791f8c16f677fc16a918923479e");//����������֤SDK
        getTextCode();
        next();
        back();
    }

    /**
     * ��֤�ֻ���ʽ
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
		��ͨ��130��131��132��152��155��156��185��186
		���ţ�133��153��180��189����1349��ͨ��
		�ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ3��5��8������λ�õĿ���Ϊ0-9
		*/
        String telRegex = "[1][358]\\d{9}";//"[1]"�����1λΪ����1��"[358]"����ڶ�λ����Ϊ3��5��8�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    //��ȡ������֤��
    private void getTextCode() {
        et_register_phone_num = (EditText) findViewById(R.id.et_register_phone_num);
        et_register_sms_num = (EditText) findViewById(R.id.et_register_sms_num);
        et_set_password = (EditText) findViewById(R.id.et_set_password);
        Button bt_register_get_sms_num = (Button) findViewById(R.id.bt_register_get_sms_num);
        //�жϵ绰���������Ƿ���ȷ�������ȷ���������֤��
        bt_register_get_sms_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNum = et_register_phone_num.getText().toString();//��ȡ�绰����
                passWord = et_set_password.getText().toString();//��ȡ����
                if (isMobileNO(phoneNum) == false) {
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_right_phonenum, Toast.LENGTH_LONG).show();
                } else if (passWord.isEmpty()) {
                    //�������Ϊ����ʾ
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

    //�����һ����ť�Ĳ���
    private void next() {

        //������һ����ť
        Button bt_register_next = (Button) findViewById(R.id.bt_register_next);
        bt_register_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsCode = et_register_sms_num.getText().toString();//��ȡ��֤��
                //ƴ��url
                url = Url.URL + "/ShopApp/userAction?action=register&userPhone=" + phoneNum + "&userPassWord=" + passWord + "&smsCode=" + smsCode;
                if (phoneNum.isEmpty()) {
                    //����ֻ���Ϊ����ʾ
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_right_phonenum, Toast.LENGTH_LONG).show();
                } else if (passWord.isEmpty()) {
                    //�������Ϊ����ʾ
                    Toast.makeText(RegisterActivity.this, R.string.toas_please_input_passWord, Toast.LENGTH_LONG).show();
                } else if (smsCode.isEmpty()) {
                    //�����֤��Ϊ����ʾ
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
                                    Log.e("������", stateCode + "");
                                }
                            });
                    //�жϷ���ֵ�Ƿ���ȷ
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

    //����
    public void back() {
        RelativeLayout relativeLayoutBack = (RelativeLayout) findViewById(R.id.rl_back);
        relativeLayoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//������һҳ
            }
        });
    }
}
