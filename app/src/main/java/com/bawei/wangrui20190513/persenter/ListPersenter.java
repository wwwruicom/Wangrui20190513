package com.bawei.wangrui20190513.persenter;

import com.bawei.wangrui20190513.MyBean;
import com.bawei.wangrui20190513.model.IModel;
import com.bawei.wangrui20190513.model.MyModel;
import com.bawei.wangrui20190513.view.IView;
import com.google.gson.Gson;

import java.util.List;

public class ListPersenter {
    private IView iView;
    private IModel iModel;
    private List<MyBean.Items> items;

    public ListPersenter(IView iView) {
        this.iView = iView;
        iModel=new MyModel();
    }
    public List<MyBean.Items>  getData(String page){
        iModel.getData(page, new MyModel.Callbacks() {
            @Override
            public void setList(String json) {
                Gson gson=new Gson();
                MyBean myBean = gson.fromJson(json, MyBean.class);
                items = myBean.getItems();
            }
        });
            return items;
    }
}
