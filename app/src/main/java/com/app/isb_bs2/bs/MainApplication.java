package com.app.isb_bs2.bs;

import android.app.Application;

import com.nifty.cloud.mb.core.NCMB;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.SyncConfiguration;
import io.realm.SyncUser;
import io.realm.log.LogLevel;
import io.realm.log.RealmLog;

/**
 * Created by sayi65 on 2017/04/20.
 */

public class MainApplication extends Application {


    public static final String AUTH_URL = "http://127.0.0.1:9080/auth";
    public static final String syncServerURL = "realm://127.0.0.1:9080/default";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmLog.setLevel(LogLevel.TRACE);


    }



}

