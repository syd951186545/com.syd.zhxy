package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private MyDBHelper helper;
    private SQLiteDatabase db ;
    //初始化用到的表
    private final String login_table = "login_user" ;
    private final String school_allpeople_table = "school_allpeople" ;

    //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
    //所以要确保context已初始化,把实例化DBManager的步骤放在Activity的onCreate里
    public DBManager(Context context){
        helper = new MyDBHelper(context);

    }

    //将这两个打开数据库方法封装在了DBManager中,直接调用
    public SQLiteDatabase getWritableDatabase(){
        db = helper.getWritableDatabase();
        return db;
    }

    //将这两个打开数据库方法封装在了DBManager中,直接调用
    public SQLiteDatabase getReadableDatabase(){
        db = helper.getReadableDatabase();
        return db;

    }

    public void initDB(SQLiteDatabase db) {
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
    //插值
    public void add(String table_name,ArrayList<Person> persons) {
        db.beginTransaction();  //开始事务
        try {
            for (Person person : persons) {
                db.execSQL("INSERT INTO "+table_name+" VALUES(null, ?, ?, ?)", new Object[]{person.Id, person.name, person.authentication});
            }
            db.setTransactionSuccessful();  //设置事务成功完成
        } finally {
            db.endTransaction();    //结束事务
        }
    }


    //更新
    public  void update(Person person){
        ContentValues cv = new ContentValues() ;
        cv.put("authentication",person.authentication);
        db.update(login_table,cv,"name = ?",
                new String[]{person.name});
    }




}
