package com.self.ylog.subway.Adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by cylog on 2017/4/22.
 */

public class HomeViewpagerAdapter extends PagerAdapter{

    private ArrayList<ImageView> mImageList;
    private ViewPager mViewPager;

    public HomeViewpagerAdapter(ViewPager mViewPager, ArrayList<ImageView> mImageList){
        this.mImageList = mImageList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(mImageList.get(position));
        return mImageList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = mImageList.get(position % mImageList.size());
        ((ViewPager) container).removeView(view);
    }

    @Override
    public int getCount() {
        return mImageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
