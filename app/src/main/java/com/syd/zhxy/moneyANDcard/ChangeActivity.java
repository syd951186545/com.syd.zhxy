package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syd.zhxy.R;

public class ChangeActivity extends AppCompatActivity {

    //声明控件：显示余额的text 和 充值按钮button
    private TextView leftMoneyText;
    private Button rechargeButtom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        leftMoneyText=(TextView)findViewById(R.id.leftMoney);
        rechargeButtom=(Button)findViewById(R.id.recharge);

        //显示余额  加载该页面的同时 查出数据库中该用户的零钱余额，并显示在这个text上
//        leftMoneyText.setText("");

        //充值按钮的单机方法,跳转到充值界面
        rechargeButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChangeActivity.this,RechargeActivity.class);
                startActivity(intent);
            }
        });

    }
}
