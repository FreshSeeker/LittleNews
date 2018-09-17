package com.example.android.littlenews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class NetAndDataTask extends AsyncTask<Void, Integer, Boolean> {

    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private int navigationItemNumber;
    private int sectionNumber;

    NetAndDataTask(Context context, int navNumber, int secNumber) {
        this.mContext = context;
        this.navigationItemNumber = navNumber;
        this.sectionNumber = secNumber;
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
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
