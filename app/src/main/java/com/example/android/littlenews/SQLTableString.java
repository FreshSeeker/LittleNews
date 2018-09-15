package com.example.android.littlenews;

import java.util.List;

public class SQLTableString {

    /*
     * 新闻类表格
     */
    public static final String CREATE_SOSIAL = "create table Social(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_GUONEI = "create table Guonei(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_WORLD = "create table World(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_HUABIAN = "create table Huabian(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_TIYU = "create table Tiyu(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_NBA = "create table Nba(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_FOOTBALL = "create table Football(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";
    public static final String CREATE_KEJI = "create table Keji(" +
            "id integer primary key autoincrement,"+
            "ctime text,"+
            "title text," +
            "description text," +
            "picUrl text," +
            "url text)";

    /*
     *  Gank类表格.其中Image只保存第一张。
     */
    public static final String CREATE_ANDROID = "create table Android(" +
            "id integer primary key autoincrement," +
            "_id text,"+
            "createdAt text,"+
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text)";
    public static final String CREATE_IOS = "create table Ios(" +
            "id integer primary key autoincrement," +
            "_id text,"+
            "createdAt text,"+
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text)";
    public static final String CREATE_TUOZHAN = "create table Tuozhan(" +
            "id integer primary key autoincrement," +
            "_id text,"+
            "createdAt text,"+
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text)";
    public static final String CREATE_QIANDUAN = "create table Qianduan(" +
            "id integer primary key autoincrement," +
            "_id text,"+
            "createdAt text,"+
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text)";
    public static final String CREATE_ALLGANKS = "create table Allganks(" +
            "id integer primary key autoincrement," +
            "_id text," +
            "createdAt text,"+
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text)";

    static String[] newsTableName = {
            "Social",
            "Guonei",
            "World",
            "Huabian",
            "Tiyu",
            "Nba",
            "Football",
            "Keji"
    };


}
