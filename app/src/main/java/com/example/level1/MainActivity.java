package com.example.level1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends MainActivity1 {

    private Button mBtnNot;
    private int mWinWidth;
    private int mWinHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

        DisplayMetrics displayMetrics= getResources().getDisplayMetrics();
        mWinWidth = displayMetrics.widthPixels;
        mWinHeight = displayMetrics.heightPixels;
    }

    private void initView(){
        mBtnNot = findViewById(R.id.btn_main_not);
    }

    private void initEvent(){
        mBtnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = new Random().nextInt(mWinWidth-v.getWidth());
                float y = new Random().nextInt(mWinHeight-v.getHeight());
                v.setX(x);
                v.setY(y);
            }
        });
    }



    @Override
    public boolean onkeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}