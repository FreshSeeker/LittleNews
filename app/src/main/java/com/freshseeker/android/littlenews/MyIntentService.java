package com.freshseeker.android.littlenews;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.Log;

import com.freshseeker.android.littlenews.bean.TransformBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyIntentService extends IntentService {

    private MyDataBaseHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("MyIntentService", "onHandleIntent: 我被调用了");
        //SQLite数据表格
        dbHelper = new MyDataBaseHelper(this, "TableStore.db", null, 1);
        db = dbHelper.getWritableDatabase();

        db.delete(SQLTableString.restTableName[1], null, null);
        //让id重新从1开始
        String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.restTableName[1] + "'";
        db.execSQL(string);

        //查询出VideoUrl表格中所有url
        cursor = db.query("VideoUrl",
                null, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do{
                String url = cursor.getString(cursor.getColumnIndex("url"));

                final Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.lylares.com/video/douying/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
                Observable<TransformBean> observable = request_interface.getTransform("?AppKey=8n4HdUBXVe&url=" + url);

                observable.subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<TransformBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.i("---initData99---", "onSubscribe: ");
                            }

                            @Override
                            public void onNext(TransformBean transformBean) {
                                Log.i("---initData99---", "onNext: restBean = " + transformBean);
                                ContentValues values = new ContentValues();
                                if (transformBean != null) {
                                    values.put("msg", transformBean.getMsg());
                                    values.put("url", transformBean.getUrl());
                                    values.put("cover", transformBean.getVinfo().getCover());
                                    values.put("title", transformBean.getVinfo().getTitle());
                                    values.put("avatar", transformBean.getUserinfo().getAvatar());
                                    values.put("nickname", transformBean.getUserinfo().getNickname());

                                    db.insert(SQLTableString.restTableName[1], null, values);
                                    values.clear();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("---initData99---", "onError: -----------------------------------");

                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                Log.i("---initData99---", "onComplete: ");
                            }
                        });
            }while (cursor.moveToNext());
        }
        cursor.close();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//
//        dbHelper.close();
//        db.close();
    }
}