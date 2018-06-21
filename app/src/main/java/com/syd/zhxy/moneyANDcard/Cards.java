package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.syd.zhxy.ApplyCard;
import com.syd.zhxy.R;

public class Cards extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);

        Button netpay = (Button) findViewById(R.id.addcard);
        netpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cards.this, ApplyCard.class);
                startActivity(intent);

//                Button addcard = findViewById(R.id.addcard);
//                addcard.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        RequestParams params = new RequestParams();
//                        params.addBodyParameter("user.phoneNum", phones);
//                        XUtils.send(XUtils.BANKACCOUNT, params, new BasicRequestCallBack<Result<User>>() {
//                            @Override
//                            public void success(Result<User> data) {
//                                if (1==data.state) {
//                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//
//                                }else{XUtils.show("登陆失败");}
//                            }
//                        }, true);
//                    }else{
//                        Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
//                    }

            }
        });

    }


}
