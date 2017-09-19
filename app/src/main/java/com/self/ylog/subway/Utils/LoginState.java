package com.self.ylog.subway.Utils;

/**
 * Created by deer on 2017/8/17.
 */

public class LoginState {
    private static LoginState mLoginState;
    private static boolean STATE_LOGIN =true;
    private static boolean STATE_UNLOGIN =false;
    private boolean mCurrentState =STATE_UNLOGIN;
    private boolean mIsFirstLogin =false;

    public static synchronized LoginState getInstance(){
        if (mLoginState == null) {
            mLoginState=new LoginState();
        }
        return mLoginState;
    }

    public boolean isLogin(){
        if (LoginState.getInstance().getLoginState()){
            return STATE_LOGIN;
        } else {
            return STATE_UNLOGIN;
        }
    }

    public boolean getLoginState(){
        return mCurrentState;
    }

    public void setLoginState(boolean mState){
        if (mState)
            mCurrentState = STATE_LOGIN;
        else
            mCurrentState = STATE_UNLOGIN;
    }

    public static LoginState getmLoginState() {
        return mLoginState;
    }

    public static void setmLoginState(LoginState mLoginState) {
        LoginState.mLoginState = mLoginState;
    }

    public boolean ismIsFirstLogin() {
        return mIsFirstLogin;
    }

    public void setmIsFirstLogin(boolean mIsFirstLogin) {
        this.mIsFirstLogin = mIsFirstLogin;
    }
}
