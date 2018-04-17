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
    //数据库管理者
    private DBManager DBManager;



    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DBManager.initDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新数据库版本
        //TODO

    }
}
