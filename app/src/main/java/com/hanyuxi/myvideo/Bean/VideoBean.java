package com.hanyuxi.myvideo.Bean;

/**
 * class summary:视频类
 * Created by JackHappiness
 * on 2015/12/23
 * version 1.0
 */
public class VideoBean {
    /**
     * subtitle : 1.2亿
     * img : http://r4.ykimg.com/050C0000563079EF67BC3C140F0A61EB
     * title : 好笑头条君 第一季
     * paid : 0
     * stripe : 更新至12-25
     * tid : ec9350f04fb211e59e2a
     * is_vv : 1
     * type : 2
     * url
     * pay_type
     *sub_channel_id 频道id
     */
    private String url;
    private String pay_type;
    private String subtitle;
    private String img;
    private String title;
    private int paid;
    private String stripe;
    private String tid;
    private int is_vv;
    private int type;
   private int sub_channel_id;

    public int getSub_channel_id() {
        return sub_channel_id;
    }

    public void setSub_channel_id(int sub_channel_id) {
        this.sub_channel_id = sub_channel_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public void setStripe(String stripe) {
        this.stripe = stripe;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setIs_vv(int is_vv) {
        this.is_vv = is_vv;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public int getPaid() {
        return paid;
    }

    public String getStripe() {
        return stripe;
    }

    public String getTid() {
        return tid;
    }

    public int getIs_vv() {
        return is_vv;
    }

    public int getType() {
        return type;
    }
}
