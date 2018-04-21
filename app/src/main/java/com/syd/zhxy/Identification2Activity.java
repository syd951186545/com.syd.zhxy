package com.syd.zhxy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Identification2Activity extends AppCompatActivity {
    private IdentityDao IdentityDao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification2);

        Button identify = (Button) findViewById(R.id.identifyButton);
        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Identification2Activity.this,"假装认证成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Identification2Activity.this, Homepage.class);
                startActivity(intent);


            }
        });

    }
}

