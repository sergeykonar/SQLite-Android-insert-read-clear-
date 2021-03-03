package com.example.contentprovider;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static String TAG = "Database";

    public DBHelper(Context context){
        super(context, "mytable", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate()");
       db.execSQL("create table mytable ("
               + "id integer primary key autoincrement, "
               +  "name text,"
               + "email text"

               + ");"
       );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
