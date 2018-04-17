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
    //数据库表单
    private final String login_table = "login_user" ;
    private final String school_allpeople_table = "school_allpeople" ;


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次调用数据库时初始化,生成1.学校人员信息数据表,2.注册用户存储表
        String sql1 = "create table if not exists ["+login_table+"] "+"("+"ID"+" integer primary key , "
                +"name"+"varchar, "
                +"password"+" integer"
                +"authentication"+"varchar"+")";
        String sql2 = "create table if not exists ["+school_allpeople_table+"] "+"("+"ID"+" integer primary key , "
                +"name"+"varchar, "
                +"authentication"+" varchar)";
        Log.i("info","create table = "+login_table) ;
        Log.i("info","create table = "+school_allpeople_table) ;
        db.execSQL(sql1);
        db.execSQL(sql2);
        //初始化school表中人员信息
        ArrayList<Person> persons = new ArrayList<>();

        Person person1 = new Person(20175301, "孙玉东", "学生");
        Person person2 = new Person(20175302, "于尤婧", "学生");
        Person person3 = new Person(00000001, "程老师", "老师");

        db.beginTransaction();  //开始事务
        try {
            for (Person personx : persons) {
                db.execSQL("INSERT INTO "+school_allpeople_table+" VALUES(?, ?, ?)", new Object[]{personx.Id, personx.name, personx.authentication});
            }
            db.setTransactionSuccessful();  //设置事务成功完成
        } finally {
            db.endTransaction();    //结束事务
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新数据库版本
        //TODO


    }
}
