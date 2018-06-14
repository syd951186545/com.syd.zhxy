package com.syd.zhxy;

import android.app.Application;

import com.syd.zhxy.https.XUtils;
import com.syd.zhxy.utils.Loading;
import com.syd.zhxy.entities.*;

public class MyApp extends Application {

    private User user;
    public void onCreate(){
        super.onCreate();
        Loading.init(this);
        XUtils.init(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
