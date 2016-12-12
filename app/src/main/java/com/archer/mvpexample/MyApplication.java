package com.archer.mvpexample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alanaliaga on 12/12/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
//        Realm.deleteRealm(realmConfiguration); // Clean slate
//        Realm.setDefaultConfiguration(realmConfiguration); // Make this Realm the default
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}






























