package com.self.ylog.subway.Utils;

/**
 * Created by cylog on 2017/5/2.
 */

public class ItemNewsData {
    //item主图片
    public int news_src;
    //item标题
    public String news_title;
    //item点赞按钮图片
    public int news_thumb;
    //item点赞数目
    public String news_thumb_num;
    //item评论按钮图片
    public int news_comment;
    //item评论数目
    public String news_comment_num;
    //item日期
    public String news_date;
    //item时间
    public String news_time;
    //是否点赞
    public Boolean isStared;
    //新闻类型
    public String type;

    public ItemNewsData(int news_src,String news_title,
                        String news_thumb_num, String news_comment_num,
                        String news_date,String news_time,
                        Boolean isStared,String type){
        this.news_src=news_src;
        this.news_title=news_title;
        this.news_thumb_num=news_thumb_num;
        this.news_comment_num=news_comment_num;
        this.news_date=news_date;
        this.news_time=news_time;
        this.isStared=isStared;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNews_src() {
        return news_src;
    }

    public void setNews_src(int news_src) {
        this.news_src = news_src;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public int getNews_thumb() {
        return news_thumb;
    }

    public void setNews_thumb(int news_thumb) {
        this.news_thumb = news_thumb;
    }

    public String getNews_thumb_num() {
        return news_thumb_num;
    }

    public void setNews_thumb_num(String news_thumb_num) {
        this.news_thumb_num = news_thumb_num;
    }

    public int getNews_comment() {
        return news_comment;
    }

    public void setNews_comment(int news_comment) {
        this.news_comment = news_comment;
    }

    public String getNews_comment_num() {
        return news_comment_num;
    }

    public void setNews_comment_num(String news_comment_num) {
        this.news_comment_num = news_comment_num;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public Boolean getStared() {
        return isStared;
    }

    public void setStared(Boolean stared) {
        isStared = stared;
    }
}
