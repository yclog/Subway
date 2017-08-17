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
import com.self.ylog.subway.Fragment.BottonMenuFragment;
import com.self.ylog.subway.Fragment.HomeFragment;
import com.self.ylog.subway.Fragment.LifeFragment;
import com.self.ylog.subway.Fragment.PersonalFragment;
import com.self.ylog.subway.Fragment.SubwayFragment;
import com.self.ylog.subway.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Home extends AppCompatActivity implements View.OnClickListener{

    private ImageView bottom_one;
    private ImageView bottom_two;
    private ImageView bottom_three;
    private ImageView bottom_four;

    private TextView menu_txt_one;
    private TextView menu_txt_two;
    private TextView menu_txt_three;
    private TextView menu_txt_four;

    private RelativeLayout bottom_menu_one_Layout,bottom_menu_two_Layout,bottom_menu_three_Layout,bottom_menu_four_Layout;

    private List<Fragment> fragList;
    private ViewPager Bottom_Navigation_Pager;
    private BottonMenuFragment BottomNavigationFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_BottomNavigationViewPager();
    }

    //初始化底部按钮导航ViewPager
    public void init_BottomNavigationViewPager(){
        //初始化底部导航按钮Icon与TextView
        init_BottomNavigation_IconTextView();
        //初始化底部导航按钮layout
        init_BottomNavigation_Layout();
        /*
        * 初始化viewpager控件
        * */
        Bottom_Navigation_Pager =(ViewPager) findViewById(R.id.main_viewpager);
        fragList=new ArrayList<Fragment>();
        /*
        * 为fragmentViewpagerList添加fragment
        * */
        fragList.add(new HomeFragment());
        fragList.add(new SubwayFragment());
        fragList.add(new LifeFragment());
        fragList.add(new PersonalFragment());
        /*
        * 添加Viewpager滑动监听事件
        * */
        Bottom_Navigation_Pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //Viewpager重写方法
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //翻页时事件
            }
            @Override
            public void onPageSelected(int position) {
                //该方法为当前选定页面事件
                change_menu_state(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                //该方法为翻页状态变化事件
            }
        });
        /*
        * viewapager设置adapter
        * */
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getSupportFragmentManager(),fragList);
        Bottom_Navigation_Pager.setAdapter(adapter);
    }

    //初始化底部按钮ImageView
    public void init_BottomNavigation_IconTextView(){
        /*
        * 初始化底部按钮控件
        * */
        bottom_one=(ImageView) findViewById(R.id.bottom_notification_one);
        bottom_two=(ImageView) findViewById(R.id.bottom_notification_two);
        bottom_three=(ImageView) findViewById(R.id.bottom_notification_three);
        bottom_four=(ImageView) findViewById(R.id.bottom_notification_four);
        /*
        * 设置第一个按钮的图标为点击状态
        * **/
        bottom_one.setImageResource(R.mipmap.bottom_navigation_home_clic);
        /**
         * 初始化底部栏TextView控件
         * */
        menu_txt_one=(TextView) findViewById(R.id.menu_txt_one);
        menu_txt_two=(TextView) findViewById(R.id.menu_txt_two);
        menu_txt_three=(TextView) findViewById(R.id.menu_txt_three);
        menu_txt_four=(TextView) findViewById(R.id.menu_txt_four);
        /**
         * 设置第一个按钮的图标文字为点击状态
         * */
        menu_txt_one.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    //设置底部按钮点击事件
    public void init_BottomNavigation_Layout(){
         /*
        * 初始化底部按钮控件所在的布局
        * */
        bottom_menu_one_Layout=(RelativeLayout)findViewById(R.id.bottom_menu_one_Layout);
        bottom_menu_two_Layout=(RelativeLayout)findViewById(R.id.bottom_menu_two_Layout);
        bottom_menu_three_Layout=(RelativeLayout)findViewById(R.id.bottom_menu_three_Layout);
        bottom_menu_four_Layout=(RelativeLayout)findViewById(R.id.bottom_menu_four_Layout);
         /*
        * 底部菜单栏设置点击事件
        * */
        bottom_menu_one_Layout.setOnClickListener(this);
        bottom_menu_two_Layout.setOnClickListener(this);
        bottom_menu_three_Layout.setOnClickListener(this);
        bottom_menu_four_Layout.setOnClickListener(this);
    }

    //设置点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_menu_one_Layout:
                Bottom_Navigation_Pager.setCurrentItem(0);
                break;
            case R.id.bottom_menu_two_Layout:
                Bottom_Navigation_Pager.setCurrentItem(1);
                break;
            case R.id.bottom_menu_three_Layout:
                Bottom_Navigation_Pager.setCurrentItem(2);
                break;
            case R.id.bottom_menu_four_Layout:
                Bottom_Navigation_Pager.setCurrentItem(3);
        }
    }

    //点击底部menu icon图片和字体颜色
    public void change_menu_state(int position) {
        switch (position + 1) {
            case 1: {
                bottom_one.setImageResource(R.mipmap.bottom_navigation_home_clic);
                bottom_two.setImageResource(R.mipmap.bottom_navigation_subway);
                bottom_three.setImageResource(R.mipmap.bottom_navigation_life);
                bottom_four.setImageResource(R.mipmap.bottom_navigation_personal);
                menu_txt_one.setTextColor(getResources().getColor(R.color.colorPrimary));
                menu_txt_two.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_three.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_four.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 2: {
                bottom_one.setImageResource(R.mipmap.bottom_navigation_home);
                bottom_two.setImageResource(R.mipmap.bottom_navigation_subway_clic);
                bottom_three.setImageResource(R.mipmap.bottom_navigation_life);
                bottom_four.setImageResource(R.mipmap.bottom_navigation_personal);
                menu_txt_one.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_two.setTextColor(getResources().getColor(R.color.colorPrimary));
                menu_txt_three.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_four.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 3: {
                bottom_one.setImageResource(R.mipmap.bottom_navigation_home);
                bottom_two.setImageResource(R.mipmap.bottom_navigation_subway);
                bottom_three.setImageResource(R.mipmap.bottom_navigation_life_clic);
                bottom_four.setImageResource(R.mipmap.bottom_navigation_personal);
                menu_txt_one.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_two.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_three.setTextColor(getResources().getColor(R.color.colorPrimary));
                menu_txt_four.setTextColor(getResources().getColor(R.color.secondary_text));
                break;
            }
            case 4: {
                bottom_one.setImageResource(R.mipmap.bottom_navigation_home);
                bottom_two.setImageResource(R.mipmap.bottom_navigation_subway);
                bottom_three.setImageResource(R.mipmap.bottom_navigation_life);
                bottom_four.setImageResource(R.mipmap.bottom_navigation_personal_clic);
                menu_txt_one.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_two.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_three.setTextColor(getResources().getColor(R.color.secondary_text));
                menu_txt_four.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            }
        }
    }
}
