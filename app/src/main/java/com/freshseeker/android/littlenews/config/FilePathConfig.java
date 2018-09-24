package com.freshseeker.android.littlenews.config;

import android.os.Environment;

public class FilePathConfig {
    //用于保存图片的文件夹路径
    public final static String picSavePath = Environment.getExternalStorageDirectory().getPath() + "/DCIM/littleNews/";
}
