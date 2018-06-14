package com.syd.zhxy.https;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.syd.zhxy.utils.Loading;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BasicRequestCallBack<T> extends RequestCallBack<String> {

    private Type type;

    public BasicRequestCallBack(){
        Type superClass = this.getClass().getGenericSuperclass();
        this.type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        Loading.dismiss();
        if (responseInfo != null){
            String json = responseInfo.result;
            if (json.matches("^\\{.*\\}$")) {
                T t = JSON.parseObject(json, type);
                if (t != null) {
                    success(t);
                } else {
                    XUtils.show("无数据");
                }
            } else {
                XUtils.show("数据格式错误");
            }
        } else {
            XUtils.show("数据加载失败");
        }
    }

    @Override
    public void onFailure(HttpException e, String s) {
        Loading.dismiss();
        XUtils.show("网络请求错误");
        Log.e("college", "===error===" + s);
        e.printStackTrace();
        failure();
    }

    public abstract void success(T data);

    public void failure(){

    }
}
