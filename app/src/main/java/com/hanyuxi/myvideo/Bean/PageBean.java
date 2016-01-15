package com.hanyuxi.myvideo.Bean;

import java.util.List;

/**
 * class summary:分页实体类
 * Created by JackHappiness
 * on 2015/12/22
 * version 1.0
 */
public class PageBean<T> {
    //当前页码
    private String currentPage;
    //总记录数
    private String totalRecord;
    //每页的数量
    private String countPage;
    //查询页的数据
    private List<T> beanList;
    //获取总页数
    public int getTotalPage(){
       // int
        return 1;
    }
    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(String totalRecord) {
        this.totalRecord = totalRecord;
    }

    public String getCountPage() {
        return countPage;
    }

    public void setCountPage(String countPage) {
        this.countPage = countPage;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
