package com.syd.zhxy.moneyANDcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.syd.zhxy.R;

public class add_bankcard4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bankcard4);
        Button changess = (Button) findViewById(R.id.nextbutton4);
        changess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_bankcard4.this, add_bankcard_success.class);
                startActivity(intent);
            }

        });
    }
}