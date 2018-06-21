package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.syd.zhxy.R;

public class WalletPage extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.wallet);

        ImageButton bankcardButton =(ImageButton) findViewById(R.id.bankcard_button);
        bankcardButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(WalletPage.this,BankcardPage.class);
                startActivity(intent);

            }
        });

        ImageButton recharge = (ImageButton) findViewById(R.id.rechargex);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletPage.this, RechargeActivity.class);
                startActivity(intent);
            }
        });
        ImageButton changess = (ImageButton) findViewById(R.id.changess);
        changess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletPage.this, ChangeActivity.class);
                startActivity(intent);
            }
        });


    }
}
