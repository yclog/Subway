package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Wallet extends AppCompatActivity implements View.OnClickListener{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIconBack;
    private RelativeLayout mPersonalWalletPayment;
    private RelativeLayout mPersonalWalletBalance;
    private RelativeLayout mPersonalWalletCoupon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_wallet);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mPersonalWalletPayment =(RelativeLayout) findViewById(R.id.personal_wallet_payment);
        mPersonalWalletPayment.setOnClickListener(this);
        mPersonalWalletBalance =(RelativeLayout) findViewById(R.id.textview_personal_wallet_balance);
        mPersonalWalletBalance.setOnClickListener(this);
        mPersonalWalletCoupon =(RelativeLayout) findViewById(R.id.personal_wallet_coupon);
        mPersonalWalletCoupon.setOnClickListener(this);
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Wallet.this.finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.personal_wallet_payment:
                mIntent=new Intent(getContext(),PersonalActivity_Wallet_Payment.class);
                startActivity(mIntent);
                break;
            case R.id.textview_personal_wallet_balance:
                mIntent=new Intent(getContext(),PersonalActivity_Wallet_Balance.class);
                startActivity(mIntent);
                break;
            case R.id.personal_wallet_coupon:
                mIntent=new Intent(getContext(),PersonalActivity_Wallet_Coupon.class);
                startActivity(mIntent);
                break;
        }
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Wallet.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取Context
     * */
    public Context getContext(){
        mContext=this;
        return mContext;
    }
}
