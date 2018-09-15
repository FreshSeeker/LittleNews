package com.example.android.littlenews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class NetAndDataTask extends AsyncTask<Void, Integer, Boolean> {

    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private int navigationItemNumber;
    private int sectionNumber;
    NewsAdapter newsAdapter;

    public NetAndDataTask(Context context,int navNumber,int secNumber,NewsAdapter adapter) {
        this.mContext = context;
        this.navigationItemNumber = navNumber;
        this.sectionNumber = secNumber;
        this.newsAdapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        Boolean isLoaded;
        try {
            InitData.initData(mContext, navigationItemNumber, sectionNumber);
            isLoaded = true;
        } catch (Exception e){
            isLoaded = false;
        }
        Log.i("NetAndDataTask", "doInBackground: "+isLoaded);
        return isLoaded;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
