package com.syd.zhxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        ImageButton searchbook = (ImageButton) findViewById(R.id.borrowbook);
        searchbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, SearchBook.class);
                startActivity(intent);
            }
        });

        ImageButton recharge = (ImageButton) findViewById(R.id.recharge);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Recharge.class);
                startActivity(intent);
            }
        });

        ImageButton mycards = (ImageButton) findViewById(R.id.mycards);
        mycards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Cards.class);
                startActivity(intent);
            }
        });


        Button recharge2 = (Button) findViewById(R.id.recharge2);
        recharge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Recharge.class);
                startActivity(intent);
            }
        });

        Button payment = (Button) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Payment.class);
                startActivity(intent);
            }
        });

        Button cards = (Button) findViewById(R.id.mycards2);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Cards.class);
                startActivity(intent);
            }
        });

        Button book = (Button) findViewById(R.id.searchbook);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, SearchBook.class);
                startActivity(intent);
            }
        });

        Button netpay = (Button) findViewById(R.id.netpayment);
        netpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, NetPayment.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 间隔2秒内,连续按两次退出(主页)
     */
     private long exitTime = 0;
     @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
                 if (keyCode == KeyEvent.KEYCODE_BACK
                         && event.getAction() == KeyEvent.ACTION_DOWN) {
                         if ((System.currentTimeMillis() - exitTime) > 2000) {
                                 //弹出提示，可以有多种方式
                                 Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                                 exitTime = System.currentTimeMillis();
                             } else {
                                 finish();
                                 //退回登陆界面,如果想直接退出写一个销毁所有activity的方法
                             }
                         return true;
                     }

                 return super.onKeyDown(keyCode, event);
             }

}
