package com.bawei.wangrui20190513;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.wangrui20190513.adapter.MyBase;
import com.bawei.wangrui20190513.persenter.ListPersenter;
import com.bawei.wangrui20190513.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IView {

    private ListView listview;
    private MyBase myBase;
    ListPersenter listPersenter;
    String page="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    private List<MyBean.Items> data=new ArrayList<>();

    @Override
    public int initview() {
        return R.layout.activity_main;
    }

    @Override
    public void initdata() {
        listPersenter=new ListPersenter(this);
        data = listPersenter.getData(page);
        myBase = new MyBase(data,this);
        listview.setAdapter(myBase);

    }

    @Override
    public void findID() {
        listview = findViewById(R.id.lv);
    }

    @Override
    public void Listener() {

    }

    @Override
    public void IListShow(MyBean myBean) {

    }
}
