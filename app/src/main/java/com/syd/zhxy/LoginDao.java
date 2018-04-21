package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LoginDao {

    private MyDBHelper DBHelper;

    public LoginDao(Context context) {
        DBHelper = new MyDBHelper(context);
    }


    //用手机号和验证码,新用户就默认注册,老用户就默认登陆,验证码API没接入,(暂时固定4位密码)
    public long login(String phone, String passcode){
        if(alterDate(phone)==null){
            long rowid=addDate(phone,passcode);//输出提示,数据被插入在第几行
            return rowid;
        }else{
            return 0;//输出提示,号码已注册,直接登录
        }

    }

    // 注册新的电话号码(和验证码)，返回的的是一个行号不是主键
    public long addDate(String phones, String passcodes) {
        // 虚拟设备调试,数据库文件利用DDMS可以查看，在 data/data/包名/databases 目录下即可查看
        SQLiteDatabase WritableDatabase = DBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("phones", phones);
        contentValues.put("passcodes", passcodes);

        // 返回,显示数据添加在第几行
        // 加了现在连续添加了3行数据,突然删掉第三行,然后再添加一条数据返回的是4不是3
        // 因为自增长
        if(passcodes.length()==4){
            long rowid = WritableDatabase.insert("Login_table",
                null, contentValues);
            WritableDatabase.close();
            return rowid;
        }else {return -1;}

    }



    /**
     * 查询电话号码是否已经注册()
     * @param phone
     * @return
     */
    public Boolean alterDate(String phone) {

        SQLiteDatabase readableDatabase = DBHelper.getReadableDatabase();
        // 查询比较特别,涉及到 cursor
        Cursor cursor = readableDatabase.query("Login_table",
                new String[]{"passcodes"}, "phones=?", new String[]{phone}, null,
                null, null);
        if (cursor.moveToFirst()) {
            cursor.close();
            readableDatabase.close();
            return true;
        }else{
            cursor.close();
            readableDatabase.close();
            return false;
        }




    }
}
