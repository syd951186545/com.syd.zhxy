package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.syd.zhxy.R;

public class BankcardPage extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_bank_card);
        Button addBankcard = (Button) findViewById(R.id.add_bankcard_button);
        addBankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BankcardPage.this,add_bankcard2.class);
                startActivity(intent);


            }
        });

    }
}
