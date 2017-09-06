package com.self.ylog.subway.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.self.ylog.subway.Activity.PersonalActivity_AboutUs;
import com.self.ylog.subway.Activity.PersonalActivity_Coupon;
import com.self.ylog.subway.Activity.PersonalActivity_Feedback;
import com.self.ylog.subway.Activity.PersonalActivity_Info;
import com.self.ylog.subway.Activity.PersonalActivity_Notification;
import com.self.ylog.subway.Activity.PersonalActivity_Route;
import com.self.ylog.subway.Activity.PersonalActivity_Pointsmall;
import com.self.ylog.subway.Activity.PersonalActivity_Setting;
import com.self.ylog.subway.Activity.PersonalActivity_Wallet;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.LoginState;
import com.self.ylog.subway.View.CircleImageView;

/**
 * Created by boy on 2017/4/12.
 */

public class PersonalFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    /**
     * 定义控件item
     * @control titlebar内控件
     * @control subheader内控件
     * @control menu点击include控件
     * */
    private ImageView mTitlebar_Personal_Notification;
    private ImageView mTitlebar_Personal_Setting;
    private CircleImageView mSubhead_Personal_Avatar;
    private TextView mSubhead_Personal_NickName;
    private TextView mSubhead_Personal_Info;
    private RelativeLayout mPersonal_Menu_Wallet;
    private RelativeLayout mPersonal_Menu_Order;
    private RelativeLayout mPersonal_Menu_Vip;
    private RelativeLayout mPersonal_Menu_Coupon;
    private RelativeLayout mPersonal_Menu_PointsMall;
    private RelativeLayout mPersonal_Menu_Collect;
    private RelativeLayout mPersonal_Menu_MyNotification;
    private RelativeLayout mPersonal_Menu_Feedback;
    private RelativeLayout mPersonal_Menu_AboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_personal,container,false);
        initView(view);
        ComfirmLoginState();
        return view;
    }

    /**
     *  初始化控件，ID绑定
     *  view.findViewById
     *  @param view onCreateView返回值视图层次参数View
     * */
    public void initView(View view){
        //Titlebar控件
        initTitlebarView(view);
        //Subheader控件
        initSubHeaderView(view);
        //Menu控件
        initMenuView(view);
    }

    /**
     * Titlebar控件
     * */
    public void initTitlebarView(View view){
        mTitlebar_Personal_Notification=(ImageView) view.findViewById(R.id.titlebar_personal_notification);
        mTitlebar_Personal_Notification.setOnClickListener(this);
        mTitlebar_Personal_Setting=(ImageView) view.findViewById(R.id.titlebar_personal_setting);
        mTitlebar_Personal_Setting.setOnClickListener(this);
    }

    /**
     * Subheader控件
     * */
    public void initSubHeaderView(View view){
        mSubhead_Personal_Avatar=(CircleImageView) view.findViewById(R.id.subhead_personal_avatar);
        mSubhead_Personal_NickName=(TextView) view.findViewById(R.id.subhead_personal_nickname);
        mSubhead_Personal_Info=(TextView) view.findViewById(R.id.subhead_personal_info);
        mSubhead_Personal_Info.setOnClickListener(this);
    }

    /**
     * Menu控件
     * */
    public void initMenuView(View view){
        mPersonal_Menu_Wallet=(RelativeLayout) view.findViewById(R.id.personal_menu_wallet);
        mPersonal_Menu_Wallet.setOnClickListener(this);
        mPersonal_Menu_Order=(RelativeLayout) view.findViewById(R.id.personal_menu_order);
        mPersonal_Menu_Order.setOnClickListener(this);
        mPersonal_Menu_Vip=(RelativeLayout) view.findViewById(R.id.personal_menu_vip);
        mPersonal_Menu_Vip.setOnClickListener(this);
        mPersonal_Menu_Coupon=(RelativeLayout) view.findViewById(R.id.personal_menu_coupon);
        mPersonal_Menu_Coupon.setOnClickListener(this);
        mPersonal_Menu_PointsMall=(RelativeLayout) view.findViewById(R.id.personal_menu_pointsmall);
        mPersonal_Menu_PointsMall.setOnClickListener(this);
        mPersonal_Menu_Collect=(RelativeLayout) view.findViewById(R.id.personal_menu_collet);
        mPersonal_Menu_Collect.setOnClickListener(this);
        mPersonal_Menu_MyNotification=(RelativeLayout) view.findViewById(R.id.personal_menu_mynotification);
        mPersonal_Menu_MyNotification.setOnClickListener(this);
        mPersonal_Menu_Feedback=(RelativeLayout) view.findViewById(R.id.personal_menu_feedback);
        mPersonal_Menu_Feedback.setOnClickListener(this);
        mPersonal_Menu_AboutUs=(RelativeLayout) view.findViewById(R.id.personal_menu_aboutus);
        mPersonal_Menu_AboutUs.setOnClickListener(this);
    }

    /**
     * 验证登陆状态
     * */
    private void ComfirmLoginState(){
        //获取登录状态并进行判断
        if (LoginState.getInstance().isLogin()) {
            //在跳转至个人界面时，判断是否已经导入个人设置
            if(isLoadUserData()){
                LoadUserData();
            }
        } else {
            //当前状态为未登录，此时跳转进入登陆界面进行登陆

        }
    }

    /**
     * 在跳转至个人界面时，判断是否已经导入个人设置
     * */
    private boolean isLoadUserData(){
        return true;
    }

    /**
     * 首次登陆后进入当前界面使用在线导入个人信息,同时保存至本地
     * 之后使用本地加载
     * */
    private void LoadUserData(){
        //判断是否第一次登陆后进入个人界面
        if (LoginState.getInstance().isFirstLogin()){
            //此处联网导入个人信息且保存至本地中
        } else {
            //此处读取本地信息
        }
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.titlebar_personal_notification:
                mIntent=new Intent(getContext(), PersonalActivity_Notification.class);
                startActivity(mIntent);
                break;
            case R.id.titlebar_personal_setting:
                mIntent=new Intent(getContext(), PersonalActivity_Setting.class);
                startActivity(mIntent);
                break;
            case R.id.subhead_personal_info:
                mIntent=new Intent(getContext(), PersonalActivity_Info.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_wallet:
                mIntent=new Intent(getContext(), PersonalActivity_Wallet.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_order:
                mIntent=new Intent(getContext(), PersonalActivity_Route.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_vip:
                Toast.makeText(getContext(),"程序员哥哥们正在努力开发中…",Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_menu_coupon:
                mIntent=new Intent(getContext(), PersonalActivity_Coupon.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_pointsmall:
                mIntent=new Intent(getContext(), PersonalActivity_Pointsmall.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_collet:
                Toast.makeText(getContext(),"程序员哥哥们正在努力开发中…",Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_menu_mynotification:
                mIntent=new Intent(getContext(), PersonalActivity_Notification.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_feedback:
                mIntent=new Intent(getContext(), PersonalActivity_Feedback.class);
                startActivity(mIntent);
                break;
            case R.id.personal_menu_aboutus:
                mIntent=new Intent(getContext(), PersonalActivity_AboutUs.class);
                startActivity(mIntent);
                break;
        }
    }
}
