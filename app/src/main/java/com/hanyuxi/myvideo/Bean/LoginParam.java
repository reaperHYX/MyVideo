package com.hanyuxi.myvideo.Bean;

/**
 * class summary:登陆参数
 * Created by JackHappiness
 * on 2015/12/23
 * version 1.0
 */
public class LoginParam {
    private String userPhone;
    private String userPassWord;
    private String smsCode;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
