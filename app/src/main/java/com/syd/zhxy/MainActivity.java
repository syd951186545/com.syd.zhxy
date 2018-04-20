package com.syd.zhxy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// 第一个界面需要改成,手机号注册并直接跳转到主界面
// 这些关联都得改
//
//
public class MainActivity extends AppCompatActivity {

    private LoginDao loginDao;
    private EditText phone;   //手机号
    private EditText passcode;   //验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        loginDao = new LoginDao(MainActivity.this);
        phone = (EditText) findViewById(R.id.editTextid);
        passcode = (EditText) findViewById(R.id.editTextpw);


        //点击登录按钮
        Button loginButton = (Button) findViewById(R.id.button1);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   Intent intent = new Intent(MainActivity.this, Homepage.class);
                   startActivity(intent);
                }
                //               else {
//                    Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
//                }

            });

            //验证登录
//            public boolean login(String username, String password) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                String sql = "select * from userData where name=? and password=?";
//                Cursor cursor = db.rawQuery(sql, new String[]{username, password});
//                if (cursor.moveToFirst()) {
//                    cursor.close();
//                    return true;
//                }
//                return false;
//            }
//        });


        //点击注册按钮
        Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });


    }
}


