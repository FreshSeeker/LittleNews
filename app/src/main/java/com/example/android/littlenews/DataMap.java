package com.example.android.littlenews;

import com.example.android.littlenews.bean.GankBean;
import com.example.android.littlenews.bean.NewsBean;

import java.util.HashMap;

class DataMap {
    // 1. 创建静态内部类
    private static class Singleton {
        // 在静态内部类里创建单例
        private static HashMap<String, NewsBean> newsInstance = new HashMap<>();
        private static HashMap<String, GankBean> gankInstance = new HashMap<>();
    }

    // 私有构造函数
    private DataMap() {
    }

    // 延迟加载、按需创建
    public static HashMap<String, NewsBean> newsInstance() {
        return Singleton.newsInstance;
    }
    public static HashMap<String, GankBean> gankInstance() {
        return Singleton.gankInstance;
    }


    private static DataMap newsInstance = null;


}
