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
    private ImageView mTitlebarPersonalNotification;
    private ImageView mTitlebarPersonalSetting;
    private CircleImageView mSubHeadPersonalAvatar;
    private TextView mSubHeadPersonalNickName;
    private TextView mSubHeadPersonalInfo;
    private RelativeLayout mPersonalMenuWallet;
    private RelativeLayout mPersonalMenuOrder;
    private RelativeLayout mPersonalMenuVip;
    private RelativeLayout mPersonalMenuCoupon;
    private RelativeLayout mPersonalMenuPointsMall;
    private RelativeLayout mPersonalMenuCollect;
    private RelativeLayout mPersonalMenuMyNotification;
    private RelativeLayout mPersonalMenuFeedback;
    private RelativeLayout mPersonalMenuAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_personal,container,false);
        initView(view);
        comfirmLoginState();
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
        mTitlebarPersonalNotification =(ImageView) view.findViewById(R.id.titlebar_personal_notification);
        mTitlebarPersonalNotification.setOnClickListener(this);
        mTitlebarPersonalSetting =(ImageView) view.findViewById(R.id.titlebar_personal_setting);
        mTitlebarPersonalSetting.setOnClickListener(this);
    }

    /**
     * Subheader控件
     * */
    public void initSubHeaderView(View view){
        mSubHeadPersonalAvatar =(CircleImageView) view.findViewById(R.id.subhead_personal_avatar);
        mSubHeadPersonalNickName =(TextView) view.findViewById(R.id.subhead_personal_nickname);
        mSubHeadPersonalInfo =(TextView) view.findViewById(R.id.subhead_personal_info);
        mSubHeadPersonalInfo.setOnClickListener(this);
    }

    /**
     * Menu控件
     * */
    public void initMenuView(View view){
        mPersonalMenuWallet =(RelativeLayout) view.findViewById(R.id.personal_menu_wallet);
        mPersonalMenuWallet.setOnClickListener(this);
        mPersonalMenuOrder =(RelativeLayout) view.findViewById(R.id.personal_menu_order);
        mPersonalMenuOrder.setOnClickListener(this);
        mPersonalMenuVip =(RelativeLayout) view.findViewById(R.id.personal_menu_vip);
        mPersonalMenuVip.setOnClickListener(this);
        mPersonalMenuCoupon =(RelativeLayout) view.findViewById(R.id.personal_menu_coupon);
        mPersonalMenuCoupon.setOnClickListener(this);
        mPersonalMenuPointsMall =(RelativeLayout) view.findViewById(R.id.personal_menu_pointsmall);
        mPersonalMenuPointsMall.setOnClickListener(this);
        mPersonalMenuCollect =(RelativeLayout) view.findViewById(R.id.personal_menu_collet);
        mPersonalMenuCollect.setOnClickListener(this);
        mPersonalMenuMyNotification =(RelativeLayout) view.findViewById(R.id.personal_menu_mynotification);
        mPersonalMenuMyNotification.setOnClickListener(this);
        mPersonalMenuFeedback =(RelativeLayout) view.findViewById(R.id.personal_menu_feedback);
        mPersonalMenuFeedback.setOnClickListener(this);
        mPersonalMenuAboutUs =(RelativeLayout) view.findViewById(R.id.personal_menu_aboutus);
        mPersonalMenuAboutUs.setOnClickListener(this);
    }

    /**
     * 验证登陆状态
     * */
    private void comfirmLoginState(){
        //获取登录状态并进行判断
        if (LoginState.getInstance().isLogin()) {
            //在跳转至个人界面时，判断是否已经导入个人设置
            if(isLoadUserData()){
                loadUserData();
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
    private void loadUserData(){
        //判断是否第一次登陆后进入个人界面
        if (LoginState.getInstance().ismIsFirstLogin()){
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
