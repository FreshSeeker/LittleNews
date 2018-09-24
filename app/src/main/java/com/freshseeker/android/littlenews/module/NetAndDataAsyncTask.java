package com.freshseeker.android.littlenews.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.freshseeker.android.littlenews.module.InitData;

public class NetAndDataAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private int navigationItemNumber;
    private int sectionNumber;

    public NetAndDataAsyncTask(Context context, int navNumber, int secNumber) {
        this.mContext = context;
        this.navigationItemNumber = navNumber;
        this.sectionNumber = secNumber;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        Boolean isLoaded;
        try {
            InitData.initData(mContext, navigationItemNumber, sectionNumber);
            isLoaded = true;
        } catch (Exception e){
            e.printStackTrace();
            isLoaded = false;
        }
        Log.i("NetAndDataAsyncTask", "doInBackground: "+isLoaded);
        return isLoaded;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
       if (aBoolean){
//           Toast.makeText(mContext, "加载完成！", Toast.LENGTH_SHORT).show();
       }
    }
}
