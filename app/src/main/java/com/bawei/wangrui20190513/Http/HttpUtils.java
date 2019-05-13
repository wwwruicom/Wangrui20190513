package com.bawei.wangrui20190513.Http;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * 封装网络判断
 */
public class HttpUtils {
    //单例模式
    public static HttpUtils getInstance(){
        return httpUtil();
    }
    public static HttpUtils httpUtil(){
        final HttpUtils httpUtils=new HttpUtils();
        return httpUtils;
    }
    //网络判断
    public boolean isConnection(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()){
            return true;
        }else {
            setConnection(context);
            return false;
        }
    };
    //设置网络
    public void setConnection(final Context context){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage("网络未连接");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                context.startActivity(intent);
            }
        });
        builder.show();
    }

}
