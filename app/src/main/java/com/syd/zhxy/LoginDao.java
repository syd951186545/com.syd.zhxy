package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.syd.zhxy.MyDBHelper;

public class LoginDao {

    private MyDBHelper DBHelper;


    public LoginDao(Context context) {
        DBHelper = new MyDBHelper(context);
    }

    // 注册新的电话号码(和验证码)，返回的的是一个long值
    public long addDate(String phone, String passcode) {
        // 虚拟设备调试,数据库文件利用DDMS可以查看，在 data/data/包名/databases 目录下即可查看
        SQLiteDatabase sqLiteDatabase = DBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("phone", phone);
        contentValues.put("name", passcode);

        // 返回,显示数据添加在第几行
        // 加了现在连续添加了3行数据,突然删掉第三行,然后再添加一条数据返回的是4不是3
        // 因为自增长
        long rowid = sqLiteDatabase.insert("Login_table", null, contentValues);

        sqLiteDatabase.close();
        return rowid;
    }



    /**
     * 查询电话号码是否已经注册()
     * @param phone
     * @return
     */
    public String alterDate(String phone) {
        String passcode = null;

        SQLiteDatabase readableDatabase = DBHelper.getReadableDatabase();
        // 查询比较特别,涉及到 cursor
        Cursor cursor = readableDatabase.query("Login_table",
                new String[]{"phones"}, "phones=?", new String[]{phone}, null, null, null);
        if (cursor.moveToNext()) {
            phone = cursor.getString(0);
        }
        cursor.close(); // 记得关闭 corsor
        readableDatabase.close(); // 关闭数据库
        return phone;


    }
}
