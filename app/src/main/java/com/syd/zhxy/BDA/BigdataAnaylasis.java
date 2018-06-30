package com.syd.zhxy.BDA;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.syd.zhxy.ContentAdapter;
import com.syd.zhxy.R;

public class BigdataAnaylasis extends AppCompatActivity implements OnClickListener{
    private LinearLayout ll_canteen;
    private LinearLayout ll_teaching;
    private LinearLayout ll_book;
    private LinearLayout ll_merchant;
    private LinearLayout ll_dormitory;


    private TextView tv_canteen;
    private TextView tv_teaching;
    private TextView tv_book;
    private TextView tv_merchant;
    private TextView tv_dormitory;

    private ViewPager BDAViewPager;

    private List<View> views;
    private ContentAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigdata_analaysis);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();

    }


    private void initEvent() {

// 设置菜单栏的点击事件
        tv_canteen.setOnClickListener(this);
        tv_teaching.setOnClickListener(this);
        tv_merchant.setOnClickListener(this);
        tv_book.setOnClickListener(this);
        tv_dormitory.setOnClickListener(this);
//      BDAViewPager.setOnPageChangeListener((OnPageChangeListener) this);
    }
    private void initView() {

        this.tv_canteen = (TextView) findViewById(R.id.tv_canteen);
        this.tv_teaching = (TextView) findViewById(R.id.tv_teaching);
        this.tv_merchant = (TextView) findViewById(R.id.tv_merchant);
        this.tv_book = (TextView) findViewById(R.id.tv_book);
        this.tv_dormitory = (TextView) findViewById(R.id.tv_dormitory);

        this.BDAViewPager = (ViewPager) findViewById(R.id.viewpager);


        View canteen = View.inflate(BigdataAnaylasis.this,R.layout.bigdata_canteen, null);
        View teaching = View.inflate(BigdataAnaylasis.this,R.layout.bigdata_teaching, null);
        View merchant = View.inflate(BigdataAnaylasis.this,R.layout.bigdata_merchant, null);
        View book = View.inflate(BigdataAnaylasis.this,R.layout.bigdata_book, null);
        View dormitory = View.inflate(BigdataAnaylasis.this,R.layout.bigdata_dormitory, null);



        views = new ArrayList<View>();
        views.add(canteen);
        views.add(teaching);
        views.add(merchant);
        views.add(book);
        views.add(dormitory);

        this.adapter = new ContentAdapter(views);
        BDAViewPager.setAdapter(adapter);


    }




    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_canteen:
                BDAViewPager.setCurrentItem(0);
                tv_canteen.setBackgroundColor(Color.RED);
                tv_teaching.setBackgroundColor(Color.WHITE);
                tv_merchant.setBackgroundColor(Color.WHITE);
                tv_book.setBackgroundColor(Color.WHITE);
                tv_dormitory.setBackgroundColor(Color.WHITE);

                break;
            case R.id.tv_teaching:
                BDAViewPager.setCurrentItem(1);
                tv_canteen.setBackgroundColor(Color.WHITE);
                tv_teaching.setBackgroundColor(Color.RED);
                tv_merchant.setBackgroundColor(Color.WHITE);
                tv_book.setBackgroundColor(Color.WHITE);
                tv_dormitory.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_merchant:
                BDAViewPager.setCurrentItem(2);
                tv_canteen.setBackgroundColor(Color.WHITE);
                tv_teaching.setBackgroundColor(Color.WHITE);
                tv_merchant.setBackgroundColor(Color.RED);
                tv_book.setBackgroundColor(Color.WHITE);
                tv_dormitory.setBackgroundColor(Color.WHITE);
                break;

            case R.id.tv_book:
                BDAViewPager.setCurrentItem(3);
                tv_canteen.setBackgroundColor(Color.WHITE);
                tv_teaching.setBackgroundColor(Color.WHITE);
                tv_merchant.setBackgroundColor(Color.WHITE);
                tv_book.setBackgroundColor(Color.RED);
                tv_dormitory.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_dormitory:
                BDAViewPager.setCurrentItem(4);
                tv_canteen.setBackgroundColor(Color.WHITE);
                tv_teaching.setBackgroundColor(Color.WHITE);
                tv_merchant.setBackgroundColor(Color.WHITE);
                tv_book.setBackgroundColor(Color.WHITE);
                tv_dormitory.setBackgroundColor(Color.RED);
                break;
        }
    }




    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     *
     */
    public class MyPagerChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    tv_canteen.setBackgroundColor(Color.RED);
                    tv_teaching.setBackgroundColor(Color.WHITE);
                    tv_merchant.setBackgroundColor(Color.WHITE);
                    tv_book.setBackgroundColor(Color.WHITE);
                    tv_dormitory.setBackgroundColor(Color.WHITE);
                    break;
                case 1:
                    tv_canteen.setBackgroundColor(Color.WHITE);
                    tv_teaching.setBackgroundColor(Color.RED);
                    tv_merchant.setBackgroundColor(Color.WHITE);
                    tv_book.setBackgroundColor(Color.WHITE);
                    tv_dormitory.setBackgroundColor(Color.WHITE);
                    break;
                case 2:
                    tv_canteen.setBackgroundColor(Color.WHITE);
                    tv_teaching.setBackgroundColor(Color.WHITE);
                    tv_merchant.setBackgroundColor(Color.RED);
                    tv_book.setBackgroundColor(Color.WHITE);
                    tv_dormitory.setBackgroundColor(Color.WHITE);
                    break;
                case 3:
                    tv_canteen.setBackgroundColor(Color.WHITE);
                    tv_teaching.setBackgroundColor(Color.WHITE);
                    tv_merchant.setBackgroundColor(Color.WHITE);
                    tv_book.setBackgroundColor(Color.RED);
                    tv_dormitory.setBackgroundColor(Color.WHITE);
                    break;
                case 4:
                    tv_canteen.setBackgroundColor(Color.WHITE);
                    tv_teaching.setBackgroundColor(Color.WHITE);
                    tv_merchant.setBackgroundColor(Color.WHITE);
                    tv_book.setBackgroundColor(Color.WHITE);
                    tv_dormitory.setBackgroundColor(Color.RED);
                    break;


                default:
                    break;
            }
        }
    }

}
