package com.seekerzhouk.android.littlenews.config;

public class APIConfig {
    //新闻API
    private static final String newsBaseUrl = "http://api.tianapi.com/";

    private static final String key = "/?key=210518c5d394dd7a986577cd5bacedda";

    private static final String num = "&num=20";

    private static String getNewsUrl(int sectionNumber){
        return ChannelConfig.getEnChannel(sectionNumber) + key + num;
    }



    //干货API
    private static final String gankBaseUrl = "http://gank.io/api/data/";

    private static final String count = "/10";

    private static final String page = "/1";

    private static String getGankUrl(int sectionNumber){

        return ChannelConfig.ganks[sectionNumber] + count + page;
    }


    //Rest API
    private static final String restBaseUrl = "http://gank.io/api/data/";

    private static final String rcount = "/20";

    private static final String rpage = "/1";

    private static String getRestUrl(int sectionNumber){

        return ChannelConfig.rest[sectionNumber] + rcount + rpage;
    }

    //统一获取baseUrl的方法
    public static String getBaseUrl(int navigationItemNumber){
        if (navigationItemNumber ==0){
            return newsBaseUrl;
        }else if (navigationItemNumber ==1){
            return gankBaseUrl;
        }else {
            return restBaseUrl;
        }
    }
    //统一获取pathUrl的方法
    public static String getPathUrl(int navigationItemNumber, int sectionNumber){

        if (navigationItemNumber ==0){
            return getNewsUrl(sectionNumber);

        }else if (navigationItemNumber ==1){
            return getGankUrl(sectionNumber);

        }else {
            return getRestUrl(sectionNumber);
        }
    }


    public static String transferBaseUrl = "https://api.lylares.com/video/douying/";
    public static String transferPathUrl = "?AppKey=8n4HdUBXVe&url=";
}
