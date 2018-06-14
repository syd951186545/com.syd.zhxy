package com.syd.zhxy.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.syd.zhxy.R;

public class Loading {

    private static Dialog loading;
    private static Context context;

    public static void init(Context con){
        context = con;
    }

    public static void show(){
        if (loading == null){
            loading = new AlertDialog.Builder(context).create();
            loading.setCanceledOnTouchOutside(false);
            Window window = loading.getWindow();
            window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            loading.show();
            window.setContentView(R.layout.layout_loading);
        } else {
            loading.show();
        }
    }

    public static void dismiss(){
        if (loading != null && loading.isShowing()){
            loading.dismiss();
        }
    }

    public static boolean isShowing(){
        if (loading != null){
            return loading.isShowing();
        }
        return false;
    }

    public static void destroy(){
        dismiss();
        if (loading != null){
            loading = null;
            context = null;
        }
    }
}
