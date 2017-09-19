package com.self.ylog.subway.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Feedback extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIconCancel;
    /**
     * @control 主界面控件
     * */
    private EditText mEditTextFeedbackContent;
    private EditText mEditTextFeedbackContact;
    private Button mButtonFeedbackSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feedback);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mIconCancel =(ImageView) findViewById(R.id.icon_cancel);
        mIconCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Feedback.this.finish();
            }
        });
        mEditTextFeedbackContent =(EditText) findViewById(R.id.edittext_feedback_content);
        mEditTextFeedbackContact =(EditText) findViewById(R.id.edittext_feedback_contact);
        mButtonFeedbackSubmit =(Button) findViewById(R.id.button_feedback_submit);
        mButtonFeedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitMessage();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Feedback.this.finish();
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

    /**
     * 提交反馈信息
     * */
    private void submitMessage(){
        //反馈信息和联系方式
        String feedback_content;
        String feedback_contact;
        feedback_content= mEditTextFeedbackContent.getText().toString();
        feedback_contact= mEditTextFeedbackContact.getText().toString();
        //联网提交反馈信息
    }
}
