package com.hanyuxi.myvideo.Bean;

/**
 * class summary:版本控制实体类
 * Created by JackHappiness
 * on 2015/12/24
 * version 1.0
 */
public class VersionBean {

    /**
     * id : 1
     * appVersion : 1.2
     * appMessage : 界面美化，修复一些错误
     * appUrl : http://shouji.360tpcdn.com/151125/22e4419f0c1e6fe60581da3a0d708f17/com.qihoo.appstore_300030510.apk
     * appUpdateTime : 2015-14-24
     */

    private int id;
    private String appVersion;
    private String appMessage;
    private String appUrl;
    private String appUpdateTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setAppMessage(String appMessage) {
        this.appMessage = appMessage;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public void setAppUpdateTime(String appUpdateTime) {
        this.appUpdateTime = appUpdateTime;
    }

    public int getId() {
        return id;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppMessage() {
        return appMessage;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getAppUpdateTime() {
        return appUpdateTime;
    }
}
