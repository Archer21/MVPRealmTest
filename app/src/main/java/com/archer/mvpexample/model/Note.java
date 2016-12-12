package com.archer.mvpexample.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by alanaliaga on 11/12/16.
 */

public class Note extends RealmObject{
    private String title;
    private String date;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }

}





























