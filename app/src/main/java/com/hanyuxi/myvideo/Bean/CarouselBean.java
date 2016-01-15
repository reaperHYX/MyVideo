package com.hanyuxi.myvideo.Bean;

/**
 * class summary:轮播实体类
 * Created by JackHappiness
 * on 2015/12/23
 * version 1.0
 */
public class CarouselBean {
    //轮播标题
    private String carouselTitle;
    //轮播视频id
    private String carouselId;
    //轮播封面
    private String carouselImage;
    //轮播直接播放Url
    private String carouselUrl;
    //轮播标签
    private String carouselTag;
    //轮播直播时长
    private String carouselTime;
    public String getCarouselTime() {
        return carouselTime;
    }

    public void setCarouselTime(String carouselTime) {
        this.carouselTime = carouselTime;
    }


    public String getCarouselTitle() {
        return carouselTitle;
    }

    public void setCarouselTitle(String carouselTitle) {
        this.carouselTitle = carouselTitle;
    }

    public String getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(String carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselImage() {
        return carouselImage;
    }

    public void setCarouselImage(String carouselImage) {
        this.carouselImage = carouselImage;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public String getCarouselTag() {
        return carouselTag;
    }

    public void setCarouselTag(String carouselTag) {
        this.carouselTag = carouselTag;
    }
}
