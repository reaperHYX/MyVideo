package com.hanyuxi.myvideo.Bean;

/**
 * class summary:意见反馈实体类
 * Created by JackHappiness
 * on 2015/12/24
 * version 1.0
 */
public class SuggestBean {

    /**
     * id : 1
     * userId : gsdghr5454he6hrd
     * suggestContent : 界面需要美化，可玩性需要增加
     * suggestContact : 15136252583
     */

    private int id;
    private String userId;
    private String suggestContent;
    private String suggestContact;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
    }

    public void setSuggestContact(String suggestContact) {
        this.suggestContact = suggestContact;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public String getSuggestContact() {
        return suggestContact;
    }
}
