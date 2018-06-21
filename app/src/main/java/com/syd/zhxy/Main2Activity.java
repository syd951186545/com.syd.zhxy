package com.syd.zhxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.syd.zhxy.Views.CircleView;
import com.syd.zhxy.https.XUtils;
import com.syd.zhxy.moneyANDcard.Cards;
import com.syd.zhxy.moneyANDcard.RechargeActivity;
import com.syd.zhxy.moneyANDcard.WalletPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main2Activity extends AppCompatActivity implements OnClickListener,OnPageChangeListener{

    // 底部菜单4个Linearlayout
    private LinearLayout ll_homepage;
    private LinearLayout ll_message;
    private LinearLayout ll_address;
    private LinearLayout ll_information;
    private LinearLayout ll_main;

    // 底部菜单4个ImageView
    private ImageView iv_homepage;
    private ImageView iv_address;
    private ImageView iv_message;
    private ImageView iv_information;
    private ImageView iv_main;

    // 底部菜单4个菜单标题
    private TextView tv_homepage;
    private TextView tv_address;
    private TextView tv_message;
    private TextView tv_information;
    private TextView tv_main;

    // 中间内容区域
    private ViewPager viewPager;

    // ViewPager适配器ContentAdapter
    private ContentAdapter adapter;

    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();

        ll_information.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://oa.jlu.edu.cn/defaultroot/PortalInformation!jldxList.action?channelId=179577"));
                startActivity(intent);
            }
        });


    }

    private void initEvent() {
        // 设置按钮监听
        ll_homepage.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_message.setOnClickListener(this);
        ll_information.setOnClickListener(this);
        ll_main.setOnClickListener(this);

        //设置ViewPager滑动监听
        viewPager.setOnPageChangeListener(this);

    }

    private void initView() {

        // 底部菜单Linearlayout
        this.ll_homepage = (LinearLayout) findViewById(R.id.ll_homepage);
        this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
        this.ll_message = (LinearLayout) findViewById(R.id.ll_message);
        this.ll_information = (LinearLayout) findViewById(R.id.ll_information);
        this.ll_main = (LinearLayout) findViewById(R.id.ll_main);

        // 底部菜单ImageView
        this.iv_homepage = (ImageView) findViewById(R.id.iv_homepage);
        this.iv_address = (ImageView) findViewById(R.id.iv_address);
        this.iv_message = (ImageView) findViewById(R.id.iv_message);
        this.iv_information = (ImageView) findViewById(R.id.iv_information);
        this.iv_main = (ImageView) findViewById(R.id.iv_main);

        // 底部菜单菜单标题
        this.tv_homepage = (TextView) findViewById(R.id.tv_homepage);
        this.tv_address = (TextView) findViewById(R.id.tv_address);
        this.tv_message = (TextView) findViewById(R.id.tv_message);
        this.tv_information = (TextView) findViewById(R.id.tv_information);
        this.tv_main = (TextView) findViewById(R.id.tv_main);

        // 中间内容区域ViewPager
        this.viewPager = (ViewPager) findViewById(R.id.vp_content);

        // 适配器
        View page_01 = View.inflate(Main2Activity.this, R.layout.page_01, null);
        View page_02 = View.inflate(Main2Activity.this, R.layout.page_02, null);
        View homepage = View.inflate(Main2Activity.this, R.layout.homepage,null);
        View page_04 = View.inflate(Main2Activity.this, R.layout.page_04, null);
        View my_page = View.inflate(Main2Activity.this, R.layout.my_page, null);

        //**************************主界面homepage监控代码*************************
        ImageButton map = (ImageButton) homepage.findViewById(R.id.baidumap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "功能正在维护中,请手动打开应用定位权限", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Main2Activity.this, BaiDuMap.class);
                startActivity(intent);
            }
        });

        ImageButton borrowbook = (ImageButton) homepage.findViewById(R.id.borrowbook);
        borrowbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SearchBook.class);
                startActivity(intent);
            }
        });

        Button borrowbook2 = (Button) homepage.findViewById(R.id.borrowbook2);
        borrowbook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SearchBook.class);
                startActivity(intent);
            }
        });

        ImageButton recharge = (ImageButton) homepage.findViewById(R.id.recharge1);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, RechargeActivity.class);
                startActivity(intent);
            }
        });

        ImageButton mycards = (ImageButton) homepage.findViewById(R.id.mycards);
        mycards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Cards.class);
                startActivity(intent);
            }
        });

        Button recharge2 = (Button) homepage.findViewById(R.id.recharge2);
        recharge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, RechargeActivity.class);
                startActivity(intent);
            }
        });

        Button payment = (Button) homepage.findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Payment.class);
                startActivity(intent);
            }
        });

        Button cards = (Button) homepage.findViewById(R.id.mycards2);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Cards.class);
                startActivity(intent);
            }
        });

        Button book = (Button) homepage.findViewById(R.id.searchbook);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SearchBook.class);
                startActivity(intent);
            }
        });

        Button netpay = (Button) homepage.findViewById(R.id.netpayment);
        netpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, NetPayment.class);
                startActivity(intent);
            }
        });
        Button timetable = (Button) homepage.findViewById(R.id.timetable);
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, TimeTable.class);
                startActivity(intent);
            }
        });
        CircleView cirview = (CircleView) homepage.findViewById(R.id.userimg);
        String url = "URI";//此处未执行,展示默认图
        XUtils.display_img(cirview, url);

        ImageButton ivcode =(ImageButton)homepage.findViewById(R.id.ivcode);
        ivcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,Ivcode.class);
                startActivity(intent);
            }
        });


        //**************************Mypage子界面监控代码**************************************
        //个人主页mypage界面:
        Button wallet =(Button)my_page.findViewById(R.id.walletbutton);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,WalletPage.class);
                startActivity(intent);
            }
        });
        Button cardss =(Button)my_page.findViewById(R.id.cardss);
        cardss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,Cards.class);
                startActivity(intent);
            }
        });
        Button setting =(Button)my_page.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this,Setting.class);
                startActivity(intent);
            }
        });


        //添加页面到适配器中
        views = new ArrayList<View>();

        views.add(page_01);
        views.add(page_02);
        views.add(homepage);
        views.add(page_04);
        views.add(my_page);

        this.adapter = new ContentAdapter(views);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_message:
                iv_message.setImageResource(R.drawable.message);
                tv_message.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(0);
                break;

            case R.id.ll_address:
                iv_address.setImageResource(R.drawable.address);
                tv_address.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_homepage:
                iv_homepage.setImageResource(R.drawable.homepage);
                tv_homepage.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_information:
                iv_information.setImageResource(R.drawable.information);
                tv_information.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(3);
                break;
            case R.id.ll_main:
                iv_main.setImageResource(R.drawable.main);
                tv_main.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(4);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_homepage.setImageResource(R.drawable.homepage);
        iv_address.setImageResource(R.drawable.address);
        iv_message.setImageResource(R.drawable.message);
        iv_information.setImageResource(R.drawable.information);
        iv_main.setImageResource(R.drawable.main);
        // TextView置为白色

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartBotton();
        //当前view被选择的时候,改变底部菜单图片，文字颜色
        switch (arg0) {
            case 0:
                iv_message.setImageResource(R.drawable.message);
                tv_message.setTextColor(0xff1B940A);

                break;
            case 1:
                iv_address.setImageResource(R.drawable.address);
                tv_address.setTextColor(0xff1B940A);
                break;
            case 2:
                iv_homepage.setImageResource(R.drawable.homepage);
                tv_homepage.setTextColor(0xff1B940A);
                break;
            case 3:
                iv_information.setImageResource(R.drawable.information);
                tv_information.setTextColor(0xff1B940A);
            case 4:
                iv_main.setImageResource(R.drawable.main);
                tv_main.setTextColor(0xff1B940A);
                break;

            default:
                break;
        }
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
                //退回登陆界面,可以考虑把登陆界面销毁
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }



    /**
     * 添加到销毁队列
     * 方法暂时没调用,写出以备后续使用
     *
     * @param activity 要销毁的activity
     */
    private static Map<String, Activity> destoryMap = new HashMap<>();

    public static void addDestoryActivity(Activity activity, String activityName) {
        destoryMap.put(activityName, activity);
    }

    /**
     * 销毁指定Activity
     */
    public static void destoryActivity(String activityName) {
        Set<String> keySet = destoryMap.keySet();
        if (keySet.size() > 0) {
            for (String key : keySet) {
                if (activityName.equals(key)) {
                    destoryMap.get(key).finish();
                }
            }
        }
    }

}