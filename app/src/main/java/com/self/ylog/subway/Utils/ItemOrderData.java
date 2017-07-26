package com.self.ylog.subway.Utils;

/**
 * Created by cylog on 2017/5/2.
 */

public class ItemOrderData {
    //乘车类型
    public String order_type;
    //订单状态
    public String order_status;
    //订单日期
    public String order_date;
    //订单时间
    public String order_time;
    //始发站
    public String order_start;
    //终点站
    public String order_end;

    public ItemOrderData(String order_type,String order_status,
                         String order_date,String order_time,
                         String order_start,String order_end){
        this.order_type=order_type;
        this.order_status=order_status;
        this.order_date=order_date;
        this.order_time=order_time;
        this.order_start=order_start;
        this.order_end=order_end;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_start() {
        return order_start;
    }

    public void setOrder_start(String order_start) {
        this.order_start = order_start;
    }

    public String getOrder_end() {
        return order_end;
    }

    public void setOrder_end(String order_end) {
        this.order_end = order_end;
    }
}
