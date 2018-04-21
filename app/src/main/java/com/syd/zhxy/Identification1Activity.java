package com.syd.zhxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Identification1Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification1);

        Button identify = (Button) findViewById(R.id.identification1Button);
        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Identification1Activity.this, Identification2Activity.class);
                startActivity(intent);


            }
        });

    }
}
