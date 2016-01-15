package com.hanyuxi.myvideo.Bean;

/**
 * class summary:频道实体类
 * Created by JackHappiness
 * on 2015/12/27
 * version 1.0
 */
public class ChannelBean {
    /**
     * cid :表示分类，电影，电视，综艺
     * filter : area:大陆|pay_kind:|variety_genre:|releaseyear:
     * sub_channel_type : 3
     * image_state : 0
     * display_type : 0
     * title : 大陆
     * highlight : 0
     * sub_channel_id : 32
     */
    private int cid;
    private String filter;
    private int sub_channel_type;
    private int image_state;
    private int display_type;
    private String title;
    private int highlight;
    private int sub_channel_id;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setSub_channel_type(int sub_channel_type) {
        this.sub_channel_type = sub_channel_type;
    }

    public void setImage_state(int image_state) {
        this.image_state = image_state;
    }

    public void setDisplay_type(int display_type) {
        this.display_type = display_type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHighlight(int highlight) {
        this.highlight = highlight;
    }

    public void setSub_channel_id(int sub_channel_id) {
        this.sub_channel_id = sub_channel_id;
    }

    public String getFilter() {
        return filter;
    }

    public int getSub_channel_type() {
        return sub_channel_type;
    }

    public int getImage_state() {
        return image_state;
    }

    public int getDisplay_type() {
        return display_type;
    }

    public String getTitle() {
        return title;
    }

    public int getHighlight() {
        return highlight;
    }

    public int getSub_channel_id() {
        return sub_channel_id;
    }
}
