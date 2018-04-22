package com.syd.zhxy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by yyj on 2018/4/14.
 */

public class MyDBHelper extends SQLiteOpenHelper{

    //数据库名称
    private static final String DATABASE_NAME = "ZHXYDB.db";
    //数据库的版本号
    private static final int DATABASE_VERSION = 1;
    //数据库中的表单
    private final String login_table = "login_table" ;
    private final String identification_table = "identification_table" ;



    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //手机注册号phones和验证码passcodes(没接入发验证码API暂时把验证码=密码),未认证前的id为自增长数
        db.execSQL("create table login_table (Ids integer primary key autoincrement, "
                + "phones varchar(20), passcodes varchar(20))");

        //认证用户学号Id,密码password,姓名name,权限authentication.
        db.execSQL("create table identification_table (Ids varchar(20) primary key ," +
                " names varchar(20), passwords varchar(20),authentications varchar(20))");

        db.execSQL("create table book (bookiIds varchar(20) primary key ," +
                " names varchar(20), passwords varchar(20))");
//        db.beginTransaction();  //开始事务
//        try {
//            for (Person personx : persons) {
//                db.execSQL("INSERT INTO "+identification_table+" VALUES(?, ?, ?)", new Object[]{personx.Id, personx.name, personx.authentication});
//            }
//            db.setTransactionSuccessful();  //设置事务成功完成
//        } finally {
//            db.endTransaction();    //结束事务
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新数据库版本
        //TODO

    }
}
