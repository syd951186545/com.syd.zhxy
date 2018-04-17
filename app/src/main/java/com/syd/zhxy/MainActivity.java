package com.syd.zhxy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDBHelper helper ;
    private EditText account;   //学号
    private EditText password;   //密码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper= new MyDBHelper(this);

        //点击注册按钮进入注册页面
        Button bt_signin = (Button) findViewById(R.id.bt_signin);
        bt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //点击登录按钮
        Button bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account=(EditText)findViewById(R.id.editText2);
                password=(EditText)findViewById(R.id.editText);
                String userName=account.getText().toString();
                String passWord=password.getText().toString();
                if (check_login(userName,passWord)) {
                Toast.makeText(MainActivity.this, "登陆成功（ZY，111）", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
        }

    });


    }
    //验证登录
    private boolean check_login(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from userData where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
}
