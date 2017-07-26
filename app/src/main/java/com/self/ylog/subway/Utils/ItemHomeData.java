package com.self.ylog.subway.Utils;

/**
 * Created by cylog on 2017/5/2.
 */

public class ItemHomeData {

    //item主图片
    public int home_src;
    //item点赞按钮图片
    public int home_thumb;
    //item标题
    public String home_title;
    //item点赞数目
    public String home_thumb_text;
    //item日期
    public String home_date;
    //item时间
    public String home_time;
    //是否点赞
    public Boolean isStared;

    public ItemHomeData(int home_src, String home_title,
                        String home_thumb_text,
                        String home_date, String home_time,
                        Boolean isStared){
        this.home_src=home_src;
        this.home_title=home_title;
        this.home_thumb_text=home_thumb_text;
        this.home_date=home_date;
        this.home_time=home_time;
        this.isStared=isStared;
    }

    public ItemHomeData(){}

    public int getHome_src() {
        return home_src;
    }

    public void setHome_src(int home_src) {
        this.home_src = home_src;
    }

    public int getHome_thumb() {
        return home_thumb;
    }

    public void setHome_thumb(int home_thumb) {
        this.home_thumb = home_thumb;
    }

    public String getHome_title() {
        return home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public String getHome_thumb_text() {
        return home_thumb_text;
    }

    public void setHome_thumb_text(String home_thumb_text) {
        this.home_thumb_text = home_thumb_text;
    }

    public String getHome_date() {
        return home_date;
    }

    public void setHome_date(String home_date) {
        this.home_date = home_date;
    }

    public String getHome_time() {
        return home_time;
    }

    public void setHome_time(String home_time) {
        this.home_time = home_time;
    }

    public Boolean getStared() {
        return isStared;
    }

    public void setStared(Boolean stared) {
        isStared = stared;
    }
}
