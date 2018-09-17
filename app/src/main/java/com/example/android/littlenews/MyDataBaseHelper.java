package com.example.android.littlenews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLTableString.CREATE_SOSIAL);
        db.execSQL(SQLTableString.CREATE_GUONEI);
        db.execSQL(SQLTableString.CREATE_WORLD);
        db.execSQL(SQLTableString.CREATE_HUABIAN);
        db.execSQL(SQLTableString.CREATE_TIYU);
        db.execSQL(SQLTableString.CREATE_NBA);
        db.execSQL(SQLTableString.CREATE_FOOTBALL);
        db.execSQL(SQLTableString.CREATE_KEJI);

        db.execSQL(SQLTableString.CREATE_ANDROID);
        db.execSQL(SQLTableString.CREATE_IOS);
        db.execSQL(SQLTableString.CREATE_TUOZHAN);
        db.execSQL(SQLTableString.CREATE_QIANDUAN);
        db.execSQL(SQLTableString.CREATE_ALLGANKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
