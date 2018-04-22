package com.syd.zhxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        ImageButton searchbook = (ImageButton) findViewById(R.id.searchbook);
        searchbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, SearchBook.class);
                startActivity(intent);
            }
        });

        ImageButton payment = (ImageButton) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, payment.class);
                startActivity(intent);
            }
        });
    }

// 用来计算返回键的点击间隔时间
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
