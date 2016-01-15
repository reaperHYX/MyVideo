package com.hanyuxi.myvideo.Bean;

/**
 * class summary:欢迎界面实体类
 * Created by JackHappiness
 * on 2015/12/23
 * version 1.0
 */
public class SplashBean {

    /**
     * videoId : 2514
     * splashImage : http://img1.imgtn.bdimg.com/it/u=3776154366,22420801&fm=15&gp=0.jpg
     * splashUrl : http://img1.imgtn.bdimg.com/it/u=3776154366,22420801&fm=15&gp=0.jpg
     * splashMessage : 美服诱惑
     * splashVersion : 2
     */

    private String videoId;
    private String splashImage;
    private String splashUrl;
    private String splashMessage;
    private String splashVersion;

    public String getSplashVersion() {
        return splashVersion;
    }

    public void setSplashVersion(String splashVersion) {
        this.splashVersion = splashVersion;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void setSplashImage(String splashImage) {
        this.splashImage = splashImage;
    }

    public void setSplashUrl(String splashUrl) {
        this.splashUrl = splashUrl;
    }

    public void setSplashMessage(String splashMessage) {
        this.splashMessage = splashMessage;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getSplashImage() {
        return splashImage;
    }

    public String getSplashUrl() {
        return splashUrl;
    }

    public String getSplashMessage() {
        return splashMessage;
    }
}
