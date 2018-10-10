package com.freshseeker.android.littlenews.module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freshseeker.android.littlenews.bean.TransformBean;
import com.freshseeker.android.littlenews.config.APIConfig;
import com.freshseeker.android.littlenews.config.GetRequest_Interface;
import com.freshseeker.android.littlenews.config.MyDataBaseHelper;
import com.freshseeker.android.littlenews.config.SQLTableString;
import com.freshseeker.android.littlenews.event.ServiceEvent;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoData {

    public static void loadData(Context context){

        //SQLite数据表格
        MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, SQLTableString.tableStore, null, 1);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(SQLTableString.restTableName[1], null, null);
        //让id重新从1开始
        String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.restTableName[1] + "'";
        db.execSQL(string);

        //查询出VideoUrl表格中所有url
        Cursor cursor = db.query(SQLTableString.transferTable,
                null, null, null,
                null, null, null, null);

        final int[] count = {0};

        if (cursor.moveToFirst()) {
            do{
                String url = cursor.getString(cursor.getColumnIndex(SQLTableString.transferAttributes[1]));

                final Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIConfig.transferBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
                Observable<TransformBean> observable = request_interface.getTransform(APIConfig.transferPathUrl + url);

                observable.subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe(new Observer<TransformBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                            }

                            @Override
                            public void onNext(TransformBean transformBean) {
                                ContentValues values = new ContentValues();
                                if (transformBean != null) {
                                    values.put(SQLTableString.videoTableAttributes[1], transformBean.getMsg());
                                    values.put(SQLTableString.videoTableAttributes[2], transformBean.getUrl());
                                    values.put(SQLTableString.videoTableAttributes[3], transformBean.getVinfo().getCover());
                                    values.put(SQLTableString.videoTableAttributes[4], transformBean.getVinfo().getTitle());
                                    values.put(SQLTableString.videoTableAttributes[5], transformBean.getUserinfo().getAvatar());
                                    values.put(SQLTableString.videoTableAttributes[6], transformBean.getUserinfo().getNickname());
                                    db.insert(SQLTableString.restTableName[1], null, values);
                                    values.clear();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                count[0] = count[0] +1;
                                if (count[0] == 20){
                                    //EventBus 发送消息
                                    EventBus.getDefault().post(new ServiceEvent(true));
                                }
                            }
                        });
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

}
