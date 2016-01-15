package com.hanyuxi.myvideo.Bean;

import java.util.List;

/**
 * class summary:
 * Created by JackHappiness
 * on 2015/12/27
 * version 1.0
 */
public class VarietyBean {
    private String status;
    private int image_state;
    private String pg;
    private String pz;
    private int total;
    private List<VideoBean> results;

    public List<VideoBean> getResults() {
        return results;
    }

    public void setResults(List<VideoBean> results) {
        this.results = results;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage_state(int image_state) {
        this.image_state = image_state;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public void setPz(String pz) {
        this.pz = pz;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public int getImage_state() {
        return image_state;
    }

    public String getPg() {
        return pg;
    }

    public String getPz() {
        return pz;
    }

    public int getTotal() {
        return total;
    }

}
