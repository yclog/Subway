package com.self.ylog.subway.Utils;

import android.content.Context;

/**
 * Created by deer on 2017/8/14.
 */

public class LayoutParam {
    private static LayoutParam mLayoutParam;
    private int HomeHeaderHeight;
    private int HomeHeaderBottom;

    private LayoutParam(){}

    public static synchronized LayoutParam getInstance(){
        if(mLayoutParam == null){
            mLayoutParam = new LayoutParam();
        }
        return mLayoutParam;
    }

    public int getHomeHeaderBottom() {
        return HomeHeaderBottom;
    }

    public void setHomeHeaderBottom(int homeHeaderBottom) {
        HomeHeaderBottom = homeHeaderBottom;
    }

    public int getHomeHeaderHeight() {
        return HomeHeaderHeight;
    }

    public void setHomeHeaderHeight(int homeHeaderHeight) {
        HomeHeaderHeight = homeHeaderHeight;
    }
}
