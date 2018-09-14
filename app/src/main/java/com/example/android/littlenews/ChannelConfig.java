package com.example.android.littlenews;

import java.util.HashMap;
import java.util.Map;

public class ChannelConfig {

    //新闻频道
    public final static String[] channels = {
            "社会",
            "国内",
            "国际",
            "娱乐",
            "体育",
            "NBA",
            "足球",
            "科技",
    };

    private final static Map<String,String> channelMap = new HashMap<String,String>(){
        {
            put(channels[0],"social");
            put(channels[1],"guonei");
            put(channels[2],"world");
            put(channels[3],"huabian");
            put(channels[4],"tiyu");
            put(channels[5],"nba");
            put(channels[6],"football");
            put(channels[7],"keji");
        }
    };

    public static String getEnChannel(int position){
        return channelMap.get(channels[position]);
    }

    //干货频道
    public static String[] ganks = {
            "Android",
            "iOS ",
            "拓展资源",
            "前端",
            "all",
    };
}
