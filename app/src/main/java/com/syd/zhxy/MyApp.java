package com.syd.zhxy;

import android.app.Application;

import com.syd.zhxy.https.XUtils;
import com.syd.zhxy.utils.Loading;
import com.syd.zhxy.entities.*;
import com.syd.zhxy.GlobalUserDao;

public class MyApp extends Application {

    private User GlobalUser;
    public  boolean hasUser = false;
    public void onCreate(){
        super.onCreate();
        Loading.init(this);
        XUtils.init(this);
        GlobalUserDao gu = new GlobalUserDao(this);

        if(gu.alterUser()!=null){
            GlobalUser = gu.alterUser();
            hasUser = true;
        }else{GlobalUser = null;
            XUtils.show("没有本地用户");
        }
    }
    public void onTerminate() {
        super.onTerminate();
        hasUser = false;
    }


    public User getUser() {
        return GlobalUser;
    }

    public void setUser(User user) {
        this.GlobalUser = user;
    }
}
