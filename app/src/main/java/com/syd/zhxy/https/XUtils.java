package com.syd.zhxy.https;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.syd.zhxy.utils.Loading;
import com.syd.zhxy.R;
import com.syd.zhxy.utils.Loading;

public class XUtils {

    public static final String URL = "http://192.168.1.183:8080/college_online/";
    public static final String LOGIN = "login";
    

    private static BitmapUtils bitmapUtils;
    private static HttpUtils httpUtils;
    private static DbUtils dbUtils;
    private static HttpHandler handler;
    private static Context mcontext;

    public static void init(Context context) {
        mcontext = context;
        if (bitmapUtils == null) {
            bitmapUtils = new BitmapUtils(context);
            bitmapUtils.configDefaultLoadingImage(R.drawable.loading_data);
            bitmapUtils.configDefaultLoadFailedImage(R.drawable.no_data);
            bitmapUtils.configDiskCacheEnabled(true);
        }
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        if (dbUtils == null) {
            dbUtils = DbUtils.create(context, "college.db");
        }
    }

    public static <T> void send(String url, RequestCallBack<T> callBack, boolean loading) {
        //封装的用于get请求的操作，没有任何的参数
        send(url, null, callBack, loading);
    }

    public static <T> void send(String url, RequestParams params, RequestCallBack<T> callBack, boolean loading) {
        //参数分别为：
        //url,请求的地址
        //params,请求时的参数，
        //callBack,返回结果，
        //loading,是否显示加载页面
        if (loading) {
            Loading.show();
        }
        if (params == null) {
            handler = httpUtils.send(HttpRequest.HttpMethod.GET, URL + url, callBack);
        } else {
            handler = httpUtils.send(HttpRequest.HttpMethod.POST, URL + url, params, callBack);
        }
    }

    public static void cancel() {
        if (handler != null) {
            handler.cancel();
            handler = null;
        }
    }

    public static void display_img(ImageView img, String url) {
        //img是表示显示图片的控件，
        //url表示图片的地址
        bitmapUtils.display(img, url);
    }

    public static void show(String text) {
        Toast.makeText(mcontext, text, Toast.LENGTH_SHORT).show();
    }
}
