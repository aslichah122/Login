package com.example.rpl2016_01.login;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by RPL2016-01 on 11/8/2019.
 */

public class App extends Application {
    public void onCreate(){
        super.onCreate();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okhttpClient=new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();
        AndroidNetworking.initialize(this,okhttpClient);
    }
}
