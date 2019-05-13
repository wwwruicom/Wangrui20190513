package com.bawei.wangrui20190513;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * BaseActivity 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract int initview();
    public abstract void initdata();
    public abstract void findID();
    public abstract void Listener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initview());

        findID();
        initdata();
        Listener();
    }
}
