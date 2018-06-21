package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.syd.zhxy.R;

public class add_bankcard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_bankcard);


        EditText pay_pass = (EditText) findViewById(R.id.pay_pass);
        String topay_pass = pay_pass.getText().toString().trim();
        if( "123456" == topay_pass){
            Intent intent = new Intent(add_bankcard.this,add_bankcard2.class);
            startActivity(intent);

        }







    }
}
