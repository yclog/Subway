package com.self.ylog.subway.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.self.ylog.subway.Activity.HomeActivity_LiveStream;
import com.self.ylog.subway.Activity.HomeActivity_Museum;
import com.self.ylog.subway.Activity.HomeActivity_Road;
import com.self.ylog.subway.Activity.HomeActivity_Scan;
import com.self.ylog.subway.Activity.HomeActivity_Ticket;
import com.self.ylog.subway.Activity.HomeActivity_TimeTable;
import com.self.ylog.subway.Activity.HomeActivity_Transportation;
import com.self.ylog.subway.Activity.HomeActivity_WiFi;
import com.self.ylog.subway.Adapter.HomeViewpagerAdapter;
import com.self.ylog.subway.Adapter.RecyclerViewHomeAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemHomeData;
import com.self.ylog.subway.Utils.LayoutParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by boy on 2017/4/12.
 */

public class HomeFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    private static int HomePagerNum=4;
    private static int TimerMessage=0;

    //viewpager
    private ViewPager mHomeAdViewPager;
    private ArrayList<ImageView> ImageList;
    //RecyclerView
    private RecyclerView mHomeRecyclerView;
    private RecyclerViewHomeAdapter mHomeRecyclerViewAdapter;
    private List<ItemHomeData> mDataList;
    //viewpager设置定时转换
    private int CurrentItem;
    private Timer mTimer;
    private TimerTask mTimertask;
    //subheadr控件
    private RelativeLayout mHomeTicket;
    private RelativeLayout mHomeTransportion;
    private RelativeLayout mHomeMuseum;
    private RelativeLayout mHomeStationinfo;
    private RelativeLayout mHomeTimetable;
    private RelativeLayout mHomeRoad;
    private RelativeLayout mHomeWifi;
    private RelativeLayout mHomeLivestream;
    //titlebar控件
    private ImageView mTitlebar_Scan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        init_TitleBarView(view);
        //实例化主界面Home_RecyclerView
        init_RecyclerView(view);
        return view;
    }

    public void init_TitleBarView(View view){
        mTitlebar_Scan=(ImageView) view.findViewById(R.id.titlebar_scan);
        mTitlebar_Scan.setOnClickListener(this);
    }

    public void init_HeaderView(View view){
        //实例化主界面宣传栏Home_Ad_ViewPager
        init_HomeViewPagerAd(view);
        //实例化子界面内控件
        init_subheaderview(view);
    }

    public void init_subheaderview(View view){
        /**
         * subheader内控件实例化
         * 为每个subheader itemview设置点击事件
         * */
        mHomeTicket =(RelativeLayout) view.findViewById(R.id.home_ticket);
        mHomeTicket.setOnClickListener(this);
        mHomeTransportion =(RelativeLayout) view.findViewById(R.id.home_transportion);
        mHomeTransportion.setOnClickListener(this);
        mHomeMuseum =(RelativeLayout) view.findViewById(R.id.home_museum);
        mHomeMuseum.setOnClickListener(this);
        mHomeStationinfo =(RelativeLayout) view.findViewById(R.id.home_stationinfo);
        mHomeTimetable =(RelativeLayout) view.findViewById(R.id.home_timetable);
        mHomeTimetable.setOnClickListener(this);
        mHomeRoad =(RelativeLayout) view.findViewById(R.id.home_road);
        mHomeRoad.setOnClickListener(this);
        mHomeWifi =(RelativeLayout) view.findViewById(R.id.home_wifi);
        mHomeWifi.setOnClickListener(this);
        mHomeLivestream =(RelativeLayout) view.findViewById(R.id.home_livestream);
        mHomeLivestream.setOnClickListener(this);
    }

    /**
     * 主页滚动viewpager广告栏实例化
     * */
    public void init_HomeViewPagerAd(View view){
        CurrentItem=1;
        mHomeAdViewPager =(ViewPager) view.findViewById(R.id.Home_Ad_ViewPager);
        ImageList=new ArrayList<ImageView>();
        //实例化ImageView对象
        for (int i = 0; i < HomePagerNum+2; i++) {
            ImageView mImageView=new ImageView(getContext());
            ViewGroup.LayoutParams mViewPagerParams=
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,160);
            mImageView.setLayoutParams(mViewPagerParams);
            mImageView.setScaleType(ImageView.ScaleType.CENTER);
            /**
             * 为ImageList添加ImageView
             * */
            switch (i){
                case 1:
                case 5:mImageView.setImageResource(R.drawable.sample_ad_one);break;
                case 2:mImageView.setImageResource(R.drawable.sample_ad_two);break;
                case 3:mImageView.setImageResource(R.drawable.sample_ad_three);break;
                case 0:
                case 4:mImageView.setImageResource(R.drawable.sample_ad_four);break;
            }
            ImageList.add(mImageView);
        }

        mHomeAdViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                //循环控制
                CurrentItem=position;
                if (position==0)
                    mHomeAdViewPager.setCurrentItem(4,false);
                else if (position==5)
                    mHomeAdViewPager.setCurrentItem(1,false);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /**
         * Home_Ad_ViewPager设置Adapter
         * */
        HomeViewpagerAdapter adapter=new HomeViewpagerAdapter(mHomeAdViewPager,ImageList);
        mHomeAdViewPager.setAdapter(adapter);
        mHomeAdViewPager.setCurrentItem(CurrentItem);
        Time_PagerScroll();
    }

    /**
     * 主页滚动viewpager广告栏定时自动滚动
     * */
    public void Time_PagerScroll(){
        mTimertask = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(TimerMessage);
            }
        };
        mTimer = new Timer();
        mTimer.schedule(mTimertask,0,8000);
    }

    public void init_RecyclerView(View view){
        initDataList();
        mHomeRecyclerView=(RecyclerView) view.findViewById(R.id.Home_RecyclerView);
        mHomeRecyclerViewAdapter =new RecyclerViewHomeAdapter(getContext(),mDataList);
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mHomeRecyclerView.setAdapter(mHomeRecyclerViewAdapter);
        setHeader(mHomeRecyclerView);
    }

    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.subheader_home, view, false);
        mHomeRecyclerViewAdapter.setFitstHeaderView(header);
        init_HeaderView(header);
    }

    //初始化主界面新闻卡片数据
    public void initDataList(){
        mDataList=new ArrayList<ItemHomeData>();
        for (int i = 0; i <5 ; i++) {
            mDataList.add(new ItemHomeData(R.color.colorPrimary,"RecyclerView","50","05-04","19:57",true));
        }
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.titlebar_scan:
                mIntent=new Intent(getContext(), HomeActivity_Scan.class);
                startActivity(mIntent);
                break;
            case R.id.home_ticket:
                mIntent=new Intent(getContext(), HomeActivity_Ticket.class);
                startActivity(mIntent);
                break;
            case R.id.home_transportion:
                mIntent=new Intent(getContext(), HomeActivity_Transportation.class);
                startActivity(mIntent);
                break;
            case R.id.home_museum:
                mIntent=new Intent(getContext(), HomeActivity_Museum.class);
                startActivity(mIntent);
                break;
            case R.id.home_timetable:
                mIntent=new Intent(getContext(), HomeActivity_TimeTable.class);
                startActivity(mIntent);
                break;
            case R.id.home_road:
                mIntent=new Intent(getContext(), HomeActivity_Road.class);
                startActivity(mIntent);
                break;
            case R.id.home_wifi:
                mIntent=new Intent(getContext(), HomeActivity_WiFi.class);
                startActivity(mIntent);
                break;
            case R.id.home_livestream:
                mIntent=new Intent(getContext(), HomeActivity_LiveStream.class);
                startActivity(mIntent);
                break;
        }
    }

    //同意处理时间
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //设定viewPager当前页面
            if (msg.what==TimerMessage)
            mHomeAdViewPager.setCurrentItem(CurrentItem++);
        }
    };

}
