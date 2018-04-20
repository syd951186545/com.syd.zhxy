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
        //手机注册号phones和验证码passcodes
        String sql1 = "create table if not exists ["+login_table+"] "+"("+"phones"+" varchar primary key , "
                +"passcodes"+" integer"+")";
        //认证用户学号Id,密码password,姓名name,权限authentication.
        String sql2 = "create table if not exists ["+identification_table+"] "+"("+"Ids"+" varchar primary key , "
                +"names"+"varchar, "
                +"passwords"+"varchar, "
                +"authentications"+" varchar)";
        Log.i("info","create table = "+login_table) ;
        Log.i("info","create table = "+identification_table) ;
        db.execSQL(sql1);
        db.execSQL(sql2);
//        //初始化school表中人员信息
//        ArrayList<Person> persons = new ArrayList<>();
//
//        Person person1 = new Person("20175301", "sunyd", "student");
//        Person person2 = new Person("20175302", "yuyu", "student");
//        Person person3 = new Person("00000001", "cheng", "teacher");
//
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
