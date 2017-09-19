package com.self.ylog.subway.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.self.ylog.subway.Adapter.FragmentPagerAdapter;
import com.self.ylog.subway.Fragment.HomeFragment;
import com.self.ylog.subway.Fragment.LifeFragment;
import com.self.ylog.subway.Fragment.PersonalFragment;
import com.self.ylog.subway.Fragment.SubwayFragment;
import com.self.ylog.subway.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylog on 2017/4/27.
 * MainFunction:Complete the App main Viewpager Layout sliding logic ,and add ClickLisenter method to
 *          control Navigation bottom button.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * Naviagtion Button icon
     * */
    private ImageView mBottomOne;
    private ImageView mBottomTwo;
    private ImageView mBottomThree;
    private ImageView mBottomFour;
    /**
     * Navation Button text
     * */
    private TextView mMenuTxtOne;
    private TextView mMenuTxtTwo;
    private TextView mMenuTxtThree;
    private TextView mMenuTxtFour;

    /**
     * Use Layout to replace Button make it more flexible
     * mBottomMenuOneLayout:HomeFragment Navigation Buttom
     * mBottomMenuTwoLayout:SubwayFragment Navigation Button
     * mBottomMenuThreeLayout:LifeFragment Navigation Button
     * mBottomMenuFourLayout:PersonalFragment Navigation Button
     * */
    private RelativeLayout mBottomMenuOneLayout,mBottomMenuTwoLayout,mBottomMenuThreeLayout,mBottomMenuFourLayout;

    /**
     * fraglist:Save all Fragment obeject
     * Navigation_ViewPager:Handle the Main Navigation View
     * */
    private List<Fragment> mFragList;
    private ViewPager mNavigationViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigationViewPager();
    }

    //初始化底部按钮导航ViewPager
    public void initBottomNavigationViewPager(){
        //初始化底部导航按钮Icon与TextView
        initBottomNavigationIconTextView();
        //初始化底部导航按钮layout
        initBottomNavigationLayout();
        /**
         * 初始化viewpager控件
         * */
        mNavigationViewPager =(ViewPager) findViewById(R.id.main_viewpager);
        mFragList =new ArrayList<Fragment>();
        /**
        * 为fragmentViewpagerList添加fragment
        * */
        mFragList.add(new HomeFragment());
        mFragList.add(new SubwayFragment());
        mFragList.add(new LifeFragment());
        mFragList.add(new PersonalFragment());
        /**
        * 添加Viewpager滑动监听事件
        * */
        mNavigationViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //Viewpager重写方法
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //翻页时事件
            }
            @Override
            public void onPageSelected(int position) {
                //该方法为当前选定页面事件
                changeMenuState(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                //该方法为翻页状态变化事件
            }
        });
        /**
        * viewapager设置adapter
        * */
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getSupportFragmentManager(), mFragList);
        mNavigationViewPager.setAdapter(adapter);
    }

    //初始化底部按钮ImageView
    public void initBottomNavigationIconTextView(){
        /*
        * 初始化底部按钮控件
        * */
        mBottomOne =(ImageView) findViewById(R.id.bottom_notification_one);
        mBottomTwo =(ImageView) findViewById(R.id.bottom_notification_two);
        mBottomThree =(ImageView) findViewById(R.id.bottom_notification_three);
        mBottomFour =(ImageView) findViewById(R.id.bottom_notification_four);
        /*
        * 设置第一个按钮的图标为点击状态
        * **/
        mBottomOne.setImageResource(R.mipmap.bottom_navigation_home_clic);
        /**
         * 初始化底部栏TextView控件
         * */
        mMenuTxtOne =(TextView) findViewById(R.id.menu_txt_one);
        mMenuTxtTwo =(TextView) findViewById(R.id.menu_txt_two);
        mMenuTxtThree =(TextView) findViewById(R.id.menu_txt_three);
        mMenuTxtFour =(TextView) findViewById(R.id.menu_txt_four);
        /**
         * 设置第一个按钮的图标文字为点击状态
         * */
        mMenuTxtOne.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    //设置底部按钮点击事件
    public void initBottomNavigationLayout(){
         /*
        * 初始化底部按钮控件所在的布局
        * */
        mBottomMenuOneLayout=(RelativeLayout)findViewById(R.id.bottom_menu_one_Layout);
        mBottomMenuTwoLayout=(RelativeLayout)findViewById(R.id.bottom_menu_two_Layout);
        mBottomMenuThreeLayout=(RelativeLayout)findViewById(R.id.bottom_menu_three_Layout);
        mBottomMenuFourLayout=(RelativeLayout)findViewById(R.id.bottom_menu_four_Layout);
         /*
        * 底部菜单栏设置点击事件
        * */
        mBottomMenuOneLayout.setOnClickListener(this);
        mBottomMenuTwoLayout.setOnClickListener(this);
        mBottomMenuThreeLayout.setOnClickListener(this);
        mBottomMenuFourLayout.setOnClickListener(this);
    }

    //设置点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_menu_one_Layout:
                mNavigationViewPager.setCurrentItem(0,false);
                break;
            case R.id.bottom_menu_two_Layout:
                mNavigationViewPager.setCurrentItem(1,false);
                break;
            case R.id.bottom_menu_three_Layout:
                mNavigationViewPager.setCurrentItem(2,false);
                break;
            case R.id.bottom_menu_four_Layout:
                mNavigationViewPager.setCurrentItem(3,false);
        }
    }

    //点击底部Navigation Button的同时改变menu icon图片和字体颜色
    public void changeMenuState(int position) {
        switch (position + 1) {
            case 1: {
                mBottomOne.setImageResource(R.mipmap.bottom_navigation_home_clic);
                mBottomTwo.setImageResource(R.mipmap.bottom_navigation_subway);
                mBottomThree.setImageResource(R.mipmap.bottom_navigation_life);
                mBottomFour.setImageResource(R.mipmap.bottom_navigation_personal);
                mMenuTxtOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                mMenuTxtTwo.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtThree.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtFour.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 2: {
                mBottomOne.setImageResource(R.mipmap.bottom_navigation_home);
                mBottomTwo.setImageResource(R.mipmap.bottom_navigation_subway_clic);
                mBottomThree.setImageResource(R.mipmap.bottom_navigation_life);
                mBottomFour.setImageResource(R.mipmap.bottom_navigation_personal);
                mMenuTxtOne.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                mMenuTxtThree.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtFour.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 3: {
                mBottomOne.setImageResource(R.mipmap.bottom_navigation_home);
                mBottomTwo.setImageResource(R.mipmap.bottom_navigation_subway);
                mBottomThree.setImageResource(R.mipmap.bottom_navigation_life_clic);
                mBottomFour.setImageResource(R.mipmap.bottom_navigation_personal);
                mMenuTxtOne.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtTwo.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                mMenuTxtFour.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 4: {
                mBottomOne.setImageResource(R.mipmap.bottom_navigation_home);
                mBottomTwo.setImageResource(R.mipmap.bottom_navigation_subway);
                mBottomThree.setImageResource(R.mipmap.bottom_navigation_life);
                mBottomFour.setImageResource(R.mipmap.bottom_navigation_personal_clic);
                mMenuTxtOne.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtTwo.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtThree.setTextColor(getResources().getColor(R.color.secondary_text));
                mMenuTxtFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
        }
    }
}
