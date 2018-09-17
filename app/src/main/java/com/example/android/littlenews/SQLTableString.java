package com.example.android.littlenews;

public class SQLTableString {

    //新闻表名
    public static String[] newsTableName = {
            "Social",
            "Guonei",
            "World",
            "Huabian",
            "Tiyu",
            "Nba",
            "Football",
            "Keji"
    };

    //新闻表格属性
    private static String newsSQLString = "" +
            "id integer primary key autoincrement," +
            "ctime text," +
            "title text," +
            "description text," +
            "picUrl text," +
            "url text";

    /*
     * 新闻类表格SQL语句
     */
    public static final String CREATE_SOSIAL = "create table Social(" + newsSQLString + ")";
    public static final String CREATE_GUONEI = "create table Guonei(" + newsSQLString + ")";
    public static final String CREATE_WORLD = "create table World(" + newsSQLString + ")";
    public static final String CREATE_HUABIAN = "create table Huabian(" + newsSQLString + ")";
    public static final String CREATE_TIYU = "create table Tiyu(" + newsSQLString + ")";
    public static final String CREATE_NBA = "create table Nba(" + newsSQLString + ")";
    public static final String CREATE_FOOTBALL = "create table Football(" + newsSQLString + ")";
    public static final String CREATE_KEJI = "create table Keji(" + newsSQLString + ")";


    //gank表名
    public static String[] gankTableName = {
            "Android",
            "Ios",
            "Tuozhan",
            "Qianduan",
            "Allganks",
    };

    //gank表格属性
    private static String gankSQLString = "" +
            "id integer primary key autoincrement," +
            "_id text," +
            "createdAt text," +
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text," +
            "image text";

    /*
     *  Gank类表格.其中Image只保存第一张。
     */
    public static final String CREATE_ANDROID = "create table Android(" + gankSQLString + ")";
    public static final String CREATE_IOS = "create table Ios(" + gankSQLString + ")";
    public static final String CREATE_TUOZHAN = "create table Tuozhan(" + gankSQLString + ")";
    public static final String CREATE_QIANDUAN = "create table Qianduan(" + gankSQLString + ")";
    public static final String CREATE_ALLGANKS = "create table Allganks(" + gankSQLString + ")";

}
