package com.seekerzhouk.android.littlenews.config;

public class SQLTableString {

    //数据库名称
    public static final String tableStore = "TableStore.db";

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
    public static final String[] newsTableAttributes = {
            "id",
            "ctime",
            "title",
            "description",
            "picUrl",
            "url"
    };
    private static final String newsSQLString = "" +
            newsTableAttributes[0] + " integer primary key autoincrement," +
            newsTableAttributes[1] + " text," +
            newsTableAttributes[2] + " text," +
            newsTableAttributes[3] + " text," +
            newsTableAttributes[4] + " text," +
            newsTableAttributes[5] + " text";
    /*
     * 新闻类表格SQL语句
     */
    public static final String CREATE_SOSIAL = "create table " + newsTableName[0] + "(" + newsSQLString + ")";
    public static final String CREATE_GUONEI = "create table " + newsTableName[1] + "(" + newsSQLString + ")";
    public static final String CREATE_WORLD = "create table " + newsTableName[2] + "(" + newsSQLString + ")";
    public static final String CREATE_HUABIAN = "create table " + newsTableName[3] + "(" + newsSQLString + ")";
    public static final String CREATE_TIYU = "create table " + newsTableName[4] + "(" + newsSQLString + ")";
    public static final String CREATE_NBA = "create table " + newsTableName[5] + "(" + newsSQLString + ")";
    public static final String CREATE_FOOTBALL = "create table " + newsTableName[6] + "(" + newsSQLString + ")";
    public static final String CREATE_KEJI = "create table " + newsTableName[7] + "(" + newsSQLString + ")";


    //gank表名
    public static final String[] gankTableName = {
            "Android",
            "Ios",
            "Tuozhan",
            "Qianduan",
            "Allganks",
    };
    //gank表格属性
    public static final String[] gankTableAttributes = {
            "id",
            "_id",
            "createdAt",
            "desc",
            "publishedAt",
            "source",
            "type",
            "url",
            "who",
            "image"
    };
    private static final String gankSQLString = "" +
            gankTableAttributes[0] + " integer primary key autoincrement," +
            gankTableAttributes[1] + " text," +
            gankTableAttributes[2] + " text," +
            gankTableAttributes[3] + " text," +
            gankTableAttributes[4] + " text," +
            gankTableAttributes[5] + " text," +
            gankTableAttributes[6] + " text," +
            gankTableAttributes[7] + " text," +
            gankTableAttributes[8] + " text," +
            gankTableAttributes[9] + " text";
    /*
     *  Gank类表格SQL语句
     */
    public static final String CREATE_ANDROID = "create table " + gankTableName[0] + "(" + gankSQLString + ")";
    public static final String CREATE_IOS = "create table " + gankTableName[1] + "(" + gankSQLString + ")";
    public static final String CREATE_TUOZHAN = "create table " + gankTableName[2] + "(" + gankSQLString + ")";
    public static final String CREATE_QIANDUAN = "create table " + gankTableName[3] + "(" + gankSQLString + ")";
    public static final String CREATE_ALLGANKS = "create table " + gankTableName[4] + "(" + gankSQLString + ")";


    //休息频道表名
    public static final String[] restTableName = {
            "Pictures",
            "Videos",
    };
    //休息频道-图片表格属性
    public static final String[] picTableAttributes = {
            "id",
            "_id",
            "createdAt",
            "desc",
            "publishedAt",
            "source",
            "type",
            "url",
            "who"
    };
    private static final String picSQLString = "" +
            picTableAttributes[0] + " integer primary key autoincrement," +
            picTableAttributes[1] + " text," +
            picTableAttributes[2] + " text," +
            picTableAttributes[3] + " text," +
            picTableAttributes[4] + " text," +
            picTableAttributes[5] + " text," +
            picTableAttributes[6] + " text," +
            picTableAttributes[7] + " text," +
            picTableAttributes[8] + " text";


    //休息频道-视频表格属性
    public static final String[] videoTableAttributes = {
            "id",
            "msg",
            "url",
            "cover",
            "title",
            "avatar",
            "nickname"
    };
    private static final String videoSQLString = "" +
            videoTableAttributes[0] + " integer primary key autoincrement," +
            videoTableAttributes[1] + " text," +
            videoTableAttributes[2] + " text," +
            videoTableAttributes[3] + " text," +
            videoTableAttributes[4] + " text," +
            videoTableAttributes[5] + " text," +
            videoTableAttributes[6] + " text";
    /*
     *  休息频道表格SQL语句
     */
    public static final String CREATE_VIDEOS = "create table " + restTableName[0] + "(" + picSQLString + ")";
    public static final String CREATE_PICTURES = "create table " + restTableName[1] + "(" + videoSQLString + ")";


    //创建一个表格用于保存video的编码过的url
    public static final String transferTable = "VideoUrl";
    public static final String[] transferAttributes = {
            "id",
            "url"
    };
    public static final String CREATE_VID_URL = "create table " + transferTable + "(" +
            transferAttributes[0] + " integer primary key autoincrement," +
            transferAttributes[1] + " text)";

}
