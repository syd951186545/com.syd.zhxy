package com.syd.zhxy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import static android.support.v7.appcompat.R.styleable.View;

//注册功能
public class Main2Activity extends AppCompatActivity {

    private DBManager myDBMangager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new MyDBHelper(this);
        EditText registerId=(EditText)findViewById(R.id.registerid);
        EditText registerPw=(EditText)findViewById(R.id.redisterpw);
        final String newid=registerId.getText().toString();
        final String password=registerId.getText().toString();
        Button register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckIsDataAlreadyInDBorNot(newid)){
                    Toast.makeText(Main2Activity.this,"该用户已被注册，注册失败",Toast.LENGTH_SHORT).show();
                    }
                    else{if(register(newid,password)){
                        Toast.makeText(Main2Activity.this,"注册成功",Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });



    }
    public boolean register(String username,String password){
        SQLiteDatabase db = DBManager.getWritableDatabase();
        /*String sql = "insert into userData(name,password) value(?,?)";
        Object obj[]={username,password};
        db.execSQL(sql,obj);*/
        ContentValues values=new ContentValues();
        values.put("name",username);
        values.put("password",password);
        db.insert("userData",null,values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }
    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase db=DBManager.getWritableDatabase();
        String Query = "Select * from userData where name =?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });
        if (cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

};

//        public void logon(View view){
//        EditText registerId=(EditText)findViewById(R.id.registerid);
//        EditText registerPw=(EditText)findViewById(R.id.redisterpw);
//        String newid=registerId.getText().toString();
//        String password=registerId.getText().toString();
//        if(CheckIsDataAlreadyInDBorNot(newid)){
//            Toast.makeText(this,"该用户已被注册，注册失败",Toast.LENGTH_SHORT).show();
//        }
//        else{
//            if(register(newid,password)){
//                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

