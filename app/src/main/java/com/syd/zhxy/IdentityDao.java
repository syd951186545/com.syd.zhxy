package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.syd.zhxy.MyDBHelper;

/**
 *用于用户信息认证
 */
public class IdentityDao {

    private MyDBHelper DBHelper;

    /**
     * 实例化数据库Help类
     * @param context 上下文
     */
    public IdentityDao(Context context) {
        DBHelper=new MyDBHelper(context);
    }


    /**
     * 向认证表中添加用户信息
     * @param Id 学号或工号
     * @param name 姓名
     * @param password 设置密码
     */
    public long addDate(String Id,String name,String password){
        // 数据库文件利用DDMS可以查看，在 data/data/包名/databases 目录下即可查看,虚拟设备调试
        SQLiteDatabase sqLiteDatabase =  DBHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put("Ids",Id);
        contentValues.put("names",name);
        contentValues.put("passwords", password);
        // 返回,显示数据添加在第几行
        // 如果现在连续添加了3行数据,突然删掉第三行,然后再添加一条数据返回的是4不是3
        long rowid=sqLiteDatabase.insert("identification_table",null,contentValues);

        sqLiteDatabase.close();
        return rowid;
    }
    /**
     * 查询匹配数据库中的信息进行认证
     * @param name 姓名
     * @param id 学号
     * @return 如下
     */
    public int alterDate(String name,String id){

        SQLiteDatabase readableDatabase = DBHelper.getReadableDatabase();
        // 查询比较特别,涉及到 cursor
        Cursor cursor = readableDatabase.query("identification_table",
                new String[]{"Ids"}, "names=?", new String[]{name}, null, null, null);
        if(cursor.moveToFirst()){
            String ids=cursor.getString(0);
            cursor.close();
            readableDatabase.close();
            if(ids.equals(id)){return 1;/*认证成功*/}else {return 2;/*学(工)号或用户名错误*/}
        }else{
            cursor.close();
            readableDatabase.close();
            return -1;/*查无此人*/}

    }

}