package com.syd.zhxy;

import android.app.Application;

import com.syd.zhxy.entities.User;
import com.syd.zhxy.https.XUtils;
import com.syd.zhxy.utils.Loading;

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
            XUtils.show("本地用户未被记录");
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
