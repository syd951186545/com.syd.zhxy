package com.syd.zhxy.moneyANDcard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.syd.zhxy.R;

import java.util.ArrayList;
import java.util.List;


public class RechargeActivity extends AppCompatActivity {

    private Button nextButton,chooseCardsButton;
    private EditText inputMoneyEdit;
    private ImageView cancelImage;
    //显示的数组
    private String arr[]=new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        nextButton=(Button)findViewById(R.id.chongzhiNext);
        inputMoneyEdit=(EditText)findViewById(R.id.zhuangzhangjine);
        chooseCardsButton = (Button) findViewById(R.id.cards);
        cancelImage=(ImageView)findViewById(R.id.qingkong);

       //选择银行卡
        chooseCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RechargeActivity.this);
                builder.setIcon(R.drawable.cancel);
                builder.setTitle("选择银行卡：");
                //指定下拉列表的显示数据
                final String[] cardslist = {"中国银行", "交通银行", "工商银行", "农业银行", "中国邮政"};
                //设置一个下拉的列表选择项
                builder.setItems(cardslist, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(RechargeActivity.this, "选择的城市为：" + cardslist[i], Toast.LENGTH_SHORT).show();
                        chooseCardsButton.setText(cardslist[i]);
                    }
                });
                builder.show();
            }
        });

        //清空当前输入的金额
        cancelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputMoneyEdit.setText("");
            }
        });

        //输入时弹出数字键盘
        inputMoneyEdit.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        //下一步按钮
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if((inputMoneyEdit.getText().toString().trim()).equals("")){
                   Toast.makeText(RechargeActivity.this,"请填写输入金额",Toast.LENGTH_SHORT).show();
               }else if(chooseCardsButton.getText().toString().trim().equals("选择银行卡")){
                   Toast.makeText(RechargeActivity.this,"请选择银行卡",Toast.LENGTH_SHORT).show();
               }else{
                   AlertDialog.Builder builder1 = new AlertDialog.Builder(RechargeActivity.this);
                   builder1.setTitle("请输入密码：");
                   builder1.setAdapter(new KeyboardAdapter(), new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) { }
                   });
                   builder1.show();
               }
            }
        });

    }

    //生成小键盘,并且赋值1-0
    public List<String> getList(){
        List<String> list=new ArrayList<String>();
        for(int i=1;i<=10;i++){
            list.add(""+i%10);
        }
        return list;
    }


    //适配器，该部分代码作用：生成小键盘，用户输入密码
     class KeyboardAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int i) {
            return getList().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view;
            if(convertView == null){
                //获取并加载到 一个新的布局 这个布局就是我们写好的适配效果
                view = LayoutInflater.from(RechargeActivity.this).inflate(R.layout.passwordkeyboard,null);
            }else{
                view = convertView;
            }

            final Button button1=(Button)view.findViewById(R.id.keyONE);
            final Button button2=(Button)view.findViewById(R.id.keyTwo);
            final Button button3=(Button)view.findViewById(R.id.keyThree);
            final Button button4=(Button)view.findViewById(R.id.keyFour);
            final Button button5=(Button)view.findViewById(R.id.keyFive);
            final Button button6=(Button)view.findViewById(R.id.keySix);
            final Button button7=(Button)view.findViewById(R.id.keySeven);
            final Button button8=(Button)view.findViewById(R.id.keyEight);
            final Button button9=(Button)view.findViewById(R.id.keyNine);
            final Button button0=(Button)view.findViewById(R.id.keyZero);
            final TextView textView1=(TextView)view.findViewById(R.id.password1);
            final TextView textView2=(TextView)view.findViewById(R.id.password2);
            final TextView textView3=(TextView)view.findViewById(R.id.password3);
            final TextView textView4=(TextView)view.findViewById(R.id.password4);
            final TextView textView5=(TextView)view.findViewById(R.id.password5);
            final TextView textView6=(TextView)view.findViewById(R.id.password6);

            Button nextStepButton=view.findViewById(R.id.afterPassword);
            ImageView backOneNumImage=(ImageView)view.findViewById(R.id.backOneNum);

            button1.setText(getList().get(0));
            button2.setText(getList().get(1));
            button3.setText(getList().get(2));
            button4.setText(getList().get(3));
            button5.setText(getList().get(4));
            button6.setText(getList().get(5));
            button7.setText(getList().get(6));
            button8.setText(getList().get(7));
            button9.setText(getList().get(8));
            button0.setText(getList().get(9));
            backOneNumImage.setImageResource(R.drawable.tuige);

            final int[] count = {0};

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button1.getText().toString());break;
                        case 2: textView2.setText(button1.getText().toString());break;
                        case 3: textView3.setText(button1.getText().toString());break;
                        case 4: textView4.setText(button1.getText().toString());break;
                        case 5: textView5.setText(button1.getText().toString());break;
                        case 6: textView6.setText(button1.getText().toString());break;
                    }
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button2.getText().toString());break;
                        case 2: textView2.setText(button2.getText().toString());break;
                        case 3: textView3.setText(button2.getText().toString());break;
                        case 4: textView4.setText(button2.getText().toString());break;
                        case 5: textView5.setText(button2.getText().toString());break;
                        case 6: textView6.setText(button2.getText().toString());break;
                    }
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button3.getText().toString());break;
                        case 2: textView2.setText(button3.getText().toString());break;
                        case 3: textView3.setText(button3.getText().toString());break;
                        case 4: textView4.setText(button3.getText().toString());break;
                        case 5: textView5.setText(button3.getText().toString());break;
                        case 6: textView6.setText(button3.getText().toString());break;
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button4.getText().toString());break;
                        case 2: textView2.setText(button4.getText().toString());break;
                        case 3: textView3.setText(button4.getText().toString());break;
                        case 4: textView4.setText(button4.getText().toString());break;
                        case 5: textView5.setText(button4.getText().toString());break;
                        case 6: textView6.setText(button4.getText().toString());break;
                    }
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button5.getText().toString());break;
                        case 2: textView2.setText(button5.getText().toString());break;
                        case 3: textView3.setText(button5.getText().toString());break;
                        case 4: textView4.setText(button5.getText().toString());break;
                        case 5: textView5.setText(button5.getText().toString());break;
                        case 6: textView6.setText(button5.getText().toString());break;
                    }
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button6.getText().toString());break;
                        case 2: textView2.setText(button6.getText().toString());break;
                        case 3: textView3.setText(button6.getText().toString());break;
                        case 4: textView4.setText(button6.getText().toString());break;
                        case 5: textView5.setText(button6.getText().toString());break;
                        case 6: textView6.setText(button6.getText().toString());break;
                    }
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button7.getText().toString());break;
                        case 2: textView2.setText(button7.getText().toString());break;
                        case 3: textView3.setText(button7.getText().toString());break;
                        case 4: textView4.setText(button7.getText().toString());break;
                        case 5: textView5.setText(button7.getText().toString());break;
                        case 6: textView6.setText(button7.getText().toString());break;
                    }
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button8.getText().toString());break;
                        case 2: textView2.setText(button8.getText().toString());break;
                        case 3: textView3.setText(button8.getText().toString());break;
                        case 4: textView4.setText(button8.getText().toString());break;
                        case 5: textView5.setText(button8.getText().toString());break;
                        case 6: textView6.setText(button8.getText().toString());break;
                    }
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button9.getText().toString());break;
                        case 2: textView2.setText(button9.getText().toString());break;
                        case 3: textView3.setText(button9.getText().toString());break;
                        case 4: textView4.setText(button9.getText().toString());break;
                        case 5: textView5.setText(button9.getText().toString());break;
                        case 6: textView6.setText(button9.getText().toString());break;
                    }
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    switch(count[0]){
                        case 1: textView1.setText(button0.getText().toString());break;
                        case 2: textView2.setText(button0.getText().toString());break;
                        case 3: textView3.setText(button0.getText().toString());break;
                        case 4: textView4.setText(button0.getText().toString());break;
                        case 5: textView5.setText(button0.getText().toString());break;
                        case 6: textView6.setText(button0.getText().toString());break;
                    }
                }
            });

            //点击删除当前一位的密码
            backOneNumImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(count[0]){
                        case 1: textView1.setText("");break;
                        case 2: textView2.setText("");break;
                        case 3: textView3.setText("");break;
                        case 4: textView4.setText("");break;
                        case 5: textView5.setText("");break;
                        case 6: textView6.setText("");break;
                    }
                    count[0]--;
                }
            });

            //输入密码之后下一步
            nextStepButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent();

                }
            });

            return view;
        }
    }

}
