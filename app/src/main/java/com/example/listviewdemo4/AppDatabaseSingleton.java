package com.example.listviewdemo4;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseSingleton {
    private static AppDatabase instance = null;

    static AppDatabase getInstance(Context context){
        instance = Room.databaseBuilder(context,AppDatabase.class,"db-name").build();
        return instance;
    }
}
