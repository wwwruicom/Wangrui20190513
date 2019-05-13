package com.bawei.wangrui20190513.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangrui20190513.MyBean;
import com.bawei.wangrui20190513.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyBase extends BaseAdapter {
    List<MyBean.Items> list=new ArrayList<>();
    Context context;

    public MyBase(List<MyBean.Items> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)){
            case 1:
                ViewHolderOne viewHolderOne=new ViewHolderOne();
                if (convertView == null) {
                    convertView=View.inflate(context, R.layout.oneimage,null);
                    viewHolderOne.textView1=convertView.findViewById(R.id.title);
                    viewHolderOne.textView2=convertView.findViewById(R.id.desc);
                    viewHolderOne.imageView=convertView.findViewById(R.id.img);
                    convertView.setTag(viewHolderOne);
                }else {
                    viewHolderOne= (ViewHolderOne) convertView.getTag();
                }
                viewHolderOne.textView1.setText(list.get(position).getTitle());
                viewHolderOne.textView2.setText(list.get(position).getDesc());
                Glide.with(context).load(list.get(position).getImage()).into(viewHolderOne.imageView);
                break;
            case 2:
                ViewHolderTwo viewHolderTwo=new ViewHolderTwo();
                if (convertView == null) {
                    convertView=View.inflate(context, R.layout.noimage,null);
                    viewHolderTwo.textView1=convertView.findViewById(R.id.title);
                    convertView.setTag(viewHolderTwo);
                }else {
                    viewHolderTwo= (ViewHolderTwo) convertView.getTag();
                }
                viewHolderTwo.textView1.setText(list.get(position).getTitle());
                break;
            case 3:
                ViewHolderThree viewHolderThree=new ViewHolderThree();
                if (convertView == null) {
                    convertView=View.inflate(context, R.layout.threeimages,null);
                    viewHolderThree.imageView1=convertView.findViewById(R.id.img1);
                    viewHolderThree.imageView2=convertView.findViewById(R.id.img2);
                    viewHolderThree.imageView3=convertView.findViewById(R.id.img3);
                    convertView.setTag(viewHolderThree);
                }else {
                    viewHolderThree= (ViewHolderThree) convertView.getTag();
                }
                Glide.with(context).load(list.get(position).getImages().get(0)).into(viewHolderThree.imageView1);
                Glide.with(context).load(list.get(position).getImages().get(1)).into(viewHolderThree.imageView2);
                Glide.with(context).load(list.get(position).getImages().get(2)).into(viewHolderThree.imageView3);
                break;
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTitle()==null&&list.get(position).getDesc()==null&&list.get(position).getImage()==null){
            return 3;
        }else if (list.get(position).getTitle()!=null&&list.get(position).getDesc()==null&&list.get(position).getImage()==null){
            return 2;
        }else if (list.get(position).getTitle()!=null&&list.get(position).getDesc()!=null&&list.get(position).getImage()!=null){
            return 1;
        }
        return 0;
    }

    private class ViewHolderOne {
        TextView textView1;
        TextView textView2;
        ImageView imageView;
    }

    private class ViewHolderTwo {
        TextView textView1;
    }

    private class ViewHolderThree {
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
    }
}
