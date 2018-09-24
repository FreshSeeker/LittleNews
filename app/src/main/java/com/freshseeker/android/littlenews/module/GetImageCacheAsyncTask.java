package com.freshseeker.android.littlenews.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.freshseeker.android.littlenews.config.FilePathConfig;
import com.freshseeker.android.littlenews.utils.FileUtil;

import java.io.File;
import java.io.IOException;

public class GetImageCacheAsyncTask extends AsyncTask<String, Void, File> {
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public GetImageCacheAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected File doInBackground(String... params) {
        Log.i("tag", "doInBackground: ");
        String imgUrl = params[0];
        try {
            return Glide.with(context)
                    .load(imgUrl)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(File result) {
        if (result == null) {
            return;
        }

        String s = result.getName();
        Log.i("GetImageCacheAsyncTask", "onPostExecute: "+ s);
        //这里得到的就是我们要的文件了，接下来是保存文件。
        String tPath = FilePathConfig.picSavePath + result.getName() + ".jpg";
        File target = new File(tPath);

        //最后一步就是复制文件咯
        try {
            FileUtil.copy(context, result, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}