package com.hanyuxi.myvideo.Bean;

/**
 * class summary:视频描述类
 * Created by JackHappiness
 * on 2015/12/23
 * version 1.0
 */
public class VideoDetailsBean {
    //视频id
    private String videoId;
    //视频导演
    private String videoDirector;
    //视频主演
    private String videoPerformer;
    //视频简介
    private String videoAbstruct;
    //视频类型
    private String videoType;
    //视频上映时间
    private String videoYears;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoDirector() {
        return videoDirector;
    }

    public void setVideoDirector(String videoDirector) {
        this.videoDirector = videoDirector;
    }

    public String getVideoPerformer() {
        return videoPerformer;
    }

    public void setVideoPerformer(String videoPerformer) {
        this.videoPerformer = videoPerformer;
    }

    public String getVideoAbstruct() {
        return videoAbstruct;
    }

    public void setVideoAbstruct(String videoAbstruct) {
        this.videoAbstruct = videoAbstruct;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoYears() {
        return videoYears;
    }

    public void setVideoYears(String videoYears) {
        this.videoYears = videoYears;
    }
}
