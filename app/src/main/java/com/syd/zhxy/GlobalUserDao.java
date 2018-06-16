package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.syd.zhxy.entities.User;
import com.syd.zhxy.https.XUtils;

/**
 *用于手机注册登录
 */
public class GlobalUserDao {

    private MyDBHelper DBHelper;

    public GlobalUserDao(Context context) {
        DBHelper = new MyDBHelper(context);
    }


    /**
     * 第一次登陆时返回的User类保存在本地数据库作为全局User
     *
     * @param globaluser User类
     *@return 1 表示成功添加
     */

    public long addDate(User globaluser) {
        // 虚拟设备调试,数据库文件利用DDMS可以查看，在 data/data/包名/databases 目录下即可查看
        SQLiteDatabase WritableDatabase = DBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if(globaluser.getAccount()!=null){ contentValues.put("account",globaluser.getAccount());}
        if(globaluser.getPassword()!=null)  {contentValues.put("password", globaluser.getPassword());}
        if(globaluser.getPhoneNum()!=null)  {contentValues.put("phone_num", globaluser.getPhoneNum());}
        if(globaluser.getUserName()!=null)  {contentValues.put("user_name", globaluser.getUserName());}

        if(-1!=WritableDatabase.insert("MyUserTable",null,contentValues)){
            XUtils.show("成功保存本地用户"+globaluser.getPhoneNum());
            WritableDatabase.close();
            return 1;
        }else {
            XUtils.show("插入本地用户时失败"+globaluser.getPhoneNum());
            return -1;
        }




//        // 返回,显示数据添加在第几行
//        // 加了现在连续添加了3行数据,突然删掉第三行,然后再添加一条数据返回的是4不是3
//        // 因为自增长
//        if(passcodes.length()==4){
//            long rowid = WritableDatabase.insert("Login_table",
//                null, contentValues);
//            WritableDatabase.close();
//            return rowid;
//        }else {return -1;}

    }



    /**
     * 查询本地数据库中是否存在全局user
     * @return User
     */
    public User alterUser() {

        SQLiteDatabase readableDatabase = DBHelper.getReadableDatabase();
        // 查询比较特别,涉及到 cursor
        Cursor cursor = readableDatabase.query("MyUserTable",
                new String[]{"*"}, null, null, null,
                null, null);

        if (cursor.moveToFirst()) {

            String account=cursor.getString(cursor.getColumnIndex("account"));
            String password=cursor.getString(cursor.getColumnIndex("password"));
            String phone_num=cursor.getString(cursor.getColumnIndex("phone_num"));
            String user_name=cursor.getString(cursor.getColumnIndex("user_name"));
            String token=cursor.getString(cursor.getColumnIndex("token"));
            XUtils.show("查询操作有数据:"+user_name+phone_num);

            User globaluser = new User();
            globaluser.setAccount(account);
            globaluser.setPassword(password);
            globaluser.setPhoneNum(phone_num);
            globaluser.setUserName(user_name);
            globaluser.setToken(token);

            cursor.close();
            readableDatabase.close();
            return globaluser;
        }else{
            XUtils.show("没有数据");
            cursor.close();
            readableDatabase.close();
            return null;
        }




    }
}
