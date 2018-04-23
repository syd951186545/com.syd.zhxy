package com.syd.zhxy;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private LoginDao loginDao;
    private EditText phone;   //手机号
    private EditText passcode;   //验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        loginDao = new LoginDao(MainActivity.this);
        phone = (EditText) findViewById(R.id.telepnum);
        passcode = (EditText) findViewById(R.id.yanzhengma);



        //点击手机登录按钮
        Button loginButton = (Button) findViewById(R.id.registerButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phones=phone.getText().toString().trim();
                String passcodes=passcode.getText().toString().trim();
                boolean status = false;
                if(TextUtils.isEmpty(phones)||TextUtils.isEmpty(passcodes)) {
                    Toast.makeText(MainActivity.this, "手机号或验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isPhoneNumber(phones)){
                        Toast.makeText(MainActivity.this,"请输入正确手机号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(loginDao.alterDate(phones)){
                        Toast.makeText(MainActivity.this,"用户已注册",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }else{
                        long addLong = loginDao.addDate(phones, passcodes);
                        if(addLong==-1){
                            Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"恭喜成为第"+addLong+"个注册用户",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                        }
                    }
                }
        });

        Button sendMessageButton=(Button)findViewById(R.id.sendMessage);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"验证码已发送到您的手机",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //模式匹配电话号码格式
    public static boolean isPhoneNumber(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        if (phoneNo.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (!PhoneNumberUtils.isISODigit(phoneNo.charAt(i))) {
                    return false;
                }
            }
            Pattern p = Pattern.compile("^((13[^4,\\D])" + "|(134[^9,\\D])" +
                    "|(14[5,7])" +
                    "|(15[^4,\\D])" +
                    "|(17[3,6-8])" +
                    "|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(phoneNo);
            return m.matches();
        }
        return false;
    }
}


