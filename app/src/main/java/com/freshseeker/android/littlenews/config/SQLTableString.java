package com.freshseeker.android.littlenews.config;

public class SQLTableString {

    //新闻表名
    public static final String[] newsTableName = {
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
    private static final String newsSQLString = "" +
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
    public static final String[] gankTableName = {
            "Android",
            "Ios",
            "Tuozhan",
            "Qianduan",
            "Allganks",
    };
    //gank表格属性
    private static final String gankSQLString = "" +
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
     *  Gank类表格SQL语句
     */
    public static final String CREATE_ANDROID = "create table Android(" + gankSQLString + ")";
    public static final String CREATE_IOS = "create table Ios(" + gankSQLString + ")";
    public static final String CREATE_TUOZHAN = "create table Tuozhan(" + gankSQLString + ")";
    public static final String CREATE_QIANDUAN = "create table Qianduan(" + gankSQLString + ")";
    public static final String CREATE_ALLGANKS = "create table Allganks(" + gankSQLString + ")";












    //休息频道表名
    public static final String[] restTableName = {
            "Pictures",
            "Videos",
    };
    //休息频道-图片表格属性
    private static final String picSQLString = "" +
            "id integer primary key autoincrement," +
            "_id text," +
            "createdAt text," +
            "desc text," +
            "publishedAt text," +
            "source text," +
            "type text," +
            "url text," +
            "who text";
    //休息频道-视频表格属性
    private static final String videoSQLString = "" +
            "id integer primary key autoincrement," +
            "msg text," +
            "url text," +
            "cover text," +
            "title text," +
            "avatar text," +
            "nickname text";
    /*
     *  休息频道表格SQL语句
     */
    public static final String CREATE_VIDEOS = "create table Videos(" + videoSQLString + ")";
    public static final String CREATE_PICTURES = "create table Pictures(" + picSQLString + ")";






    //创建一个表格用于保存video的编码过的url
    public static final String CREATE_VID_URL = "create table VideoUrl( id integer primary key autoincrement, url text)";

}
