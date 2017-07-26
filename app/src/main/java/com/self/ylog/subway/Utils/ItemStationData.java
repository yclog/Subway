package com.self.ylog.subway.Utils;

/**
 * Created by cylog on 2017/5/14.
 */

public class ItemStationData {
    //地铁站状态
    private String station_status;
    //地铁站
    private String station_state;
    //上部分线View
    private Boolean ishow_up;
    //下部分线View
    private Boolean ishow_dowm;
    //线路标号
    private int subway_label;

    public ItemStationData(String station_status, String station_state, Boolean ishow_up, Boolean ishow_dowm, int subway_label) {
        this.station_status = station_status;
        this.station_state = station_state;
        this.ishow_up = ishow_up;
        this.ishow_dowm = ishow_dowm;
        this.subway_label = subway_label;
    }

    public String getStation_status() {
        return station_status;
    }

    public void setStation_status(String station_status) {
        this.station_status = station_status;
    }

    public String getStation_state() {
        return station_state;
    }

    public void setStation_state(String station_state) {
        this.station_state = station_state;
    }

    public Boolean getIshow_up() {
        return ishow_up;
    }

    public void setIshow_up(Boolean ishow_up) {
        this.ishow_up = ishow_up;
    }

    public Boolean getIshow_dowm() {
        return ishow_dowm;
    }

    public void setIshow_dowm(Boolean ishow_dowm) {
        this.ishow_dowm = ishow_dowm;
    }

    public int getSubway_label() {
        return subway_label;
    }

    public void setSubway_label(int subway_label) {
        this.subway_label = subway_label;
    }

}
