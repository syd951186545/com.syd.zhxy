package com.syd.zhxy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DBManager myDBManager ;
    private EditText account;   //学号
    private EditText password;   //密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDBManager = new DBManager(this);


        //点击注册按钮进入注册页面
    public void logonClicked(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
        //点击登录按钮
    public void loginClicked(View view) {
        account=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById(R.id.editText);
        String userName=account.getText().toString();
        String passWord=password.getText().toString();
        if (login(userName,passWord)) {
            Toast.makeText(MainActivity.this, "登陆成功（ZY，111）", Toast.LENGTH_SHORT).show();
         }
        else {
            Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
         }
    }

    //验证登录
    public boolean login(String username,String password) {
        SQLiteDatabase db = myDBManager.getWritableDatabase();
        String sql = "select * from userData where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }



    }
}
