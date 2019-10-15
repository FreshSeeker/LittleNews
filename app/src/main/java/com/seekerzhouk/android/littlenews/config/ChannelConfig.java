package com.seekerzhouk.android.littlenews.config;

import java.util.HashMap;
import java.util.Map;

public class ChannelConfig {

    //新闻频道
    public final static String[] channels = {
            "社会",
            "国内",
            "国际",
            "VR科技",
            "移动互联",
            "娱乐",
            "体育",
            "足球"
    };

    private final static Map<String,String> channelMap = new HashMap<String,String>(){
        {
            put(channels[0],"social");
            put(channels[1],"guonei");
            put(channels[2],"world");
            put(channels[3],"vr");
            put(channels[4],"mobile");
            put(channels[5],"huabian");
            put(channels[6],"tiyu");
            put(channels[7],"football");
        }
    };

    public static String getEnChannel(int position){
        return channelMap.get(channels[position]);
    }

    //干货频道
    public static String[] ganks = {
            "Android",
            "iOS",
            "拓展资源",
            "前端",
            "all",
    };

    //休息频道
    public static String[] rest = {
            "福利",
            "休息视频",
    };
}
