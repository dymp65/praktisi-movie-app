package com.example.myapplication;

import com.example.myapplication.sqlite.AppDatabase;

public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.createDatabase(this);
    }
}
