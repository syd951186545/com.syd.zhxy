package com.syd.zhxy;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.http.RequestParams;
import com.syd.zhxy.entities.Result;
import com.syd.zhxy.entities.User;
import com.syd.zhxy.https.BasicRequestCallBack;
import com.syd.zhxy.https.XUtils;
import com.syd.zhxy.MyApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private GlobalUserDao gu;
    private EditText phone;   //手机号
    private EditText passcode;   //验证码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        gu = new GlobalUserDao(MainActivity.this);
        phone = (EditText) findViewById(R.id.telepnum);
        passcode = (EditText) findViewById(R.id.yanzhengma);
        if (((MyApp)getApplication()).hasUser){
            XUtils.show("记住了本地用户不用再登陆了");
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }


        getPermission();
        //点击手机登录按钮
        Button loginButton = (Button) findViewById(R.id.registerButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phones = phone.getText().toString().trim();
                String passcodes = passcode.getText().toString().trim();
                boolean status = false;
                if (TextUtils.isEmpty(phones) || TextUtils.isEmpty(passcodes)) {
                    Toast.makeText(MainActivity.this, "手机号或验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isPhoneNumber(phones)) {
                    Toast.makeText(MainActivity.this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                //验证码暂时随便判断的
                if(passcodes.length()==4){
                        RequestParams params = new RequestParams();
                        params.addBodyParameter("user.phoneNum", phones);
                        XUtils.send(XUtils.LOGIN, params, new BasicRequestCallBack<Result<User>>() {
                            @Override
                            public void success(Result<User> data) {
                                if (1==data.state) {

                                    ((MyApp)getApplication()).setUser(data.data);
                                    XUtils.show(data.data.getPhoneNum());

                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent);

                                }else{XUtils.show("登陆失败");}
                            }
                        }, true);
                    }else{
                        Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    }


//                if(loginDao.alterDate(phones)){
//                        Toast.makeText(MainActivity.this,"用户已注册",Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                        startActivity(intent);
//                    }else{
//                        long addLong = loginDao.addDate(phones, passcodes);
//                        if(addLong==-1){
//                            Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
//                        }else{
//
//                            Toast.makeText(MainActivity.this,"恭喜成为第"+addLong+"个注册用户",Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                            startActivity(intent);
//                        }
//                    }
              }
            });

        Button sendMessageButton=(Button)findViewById(R.id.sendMessage);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XUtils.show("验证码已发送");

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
    //Android版本大于6.0动态申请权限
    public void getPermission(){

        if (Build.VERSION.SDK_INT >= 23) {
            if(!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(intent);

            }else{return ;}
        }else {
            //andriod<6.0 do nothing
        }
        return ;
    }
}


