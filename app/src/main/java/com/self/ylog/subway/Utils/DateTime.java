package com.self.ylog.subway.Utils;

import java.util.Date;

/**
 * Created by cylog on 2017/5/3.
 */


public class DateTime {
    private Date mDate;
    private int month;
    private int day;
    private int hour;
    private int minutes;
    private String date;
    private String time;

    public DateTime(){
        mDate=new Date();
        mDate.setTime(System.currentTimeMillis());
        this.month=mDate.getMonth()+1;
        this.day=mDate.getDay();
        date=month+"-"+day;
        this.hour=mDate.getHours();
        this.minutes=mDate.getMinutes();
        time=hour+":"+minutes;
    }

    public DateTime(int month,int day,int hour,int minutes){
        this.month=mDate.getMonth();
        this.day=mDate.getDay();
        this.hour=mDate.getHours();
        this.minutes=mDate.getMinutes();
        date=month+"-"+day;
        time=hour+":"+minutes;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}