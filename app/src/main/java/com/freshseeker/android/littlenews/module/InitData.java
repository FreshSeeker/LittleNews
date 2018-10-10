package com.freshseeker.android.littlenews.module;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.freshseeker.android.littlenews.bean.GankBean;
import com.freshseeker.android.littlenews.bean.NewsBean;
import com.freshseeker.android.littlenews.bean.RestBean;
import com.freshseeker.android.littlenews.config.APIConfig;
import com.freshseeker.android.littlenews.config.GetRequest_Interface;
import com.freshseeker.android.littlenews.config.MyDataBaseHelper;
import com.freshseeker.android.littlenews.config.SQLTableString;
import com.freshseeker.android.littlenews.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitData {

    /**
     * 访问网络，将得到的数据保存到SQLite。
     *
     * @param context 上下文
     * @param navigationItemNumber navigation序号
     * @param sectionNumber Tab的位置
     */

    @SuppressLint("CheckResult")
    public static void initData(final Context context, final int navigationItemNumber, final int sectionNumber) {

        //RxJava2 + Retrofit2 作网络请求
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        if (navigationItemNumber == 0) {//新闻API的网络请求，得到 NewsBean对象
            Observable<NewsBean> observable = request_interface.getNews(APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe(new Observer<NewsBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(NewsBean newsBean) {
                            if (newsBean != null) {
                                //SQLite数据表格
                                MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, SQLTableString.tableStore, null, 1);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                //先清空表中数据，
                                db.delete(SQLTableString.newsTableName[sectionNumber], null, null);
                                //让id重新从1开始
                                String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.newsTableName[sectionNumber] + "'";
                                db.execSQL(string);
                                //再存进新的数据
                                for (int i = 0; i < newsBean.getNewslist().size(); i++) {
                                    values.put(SQLTableString.newsTableAttributes[1], newsBean.getNewslist().get(i).getCtime());
                                    values.put(SQLTableString.newsTableAttributes[2], newsBean.getNewslist().get(i).getTitle());
                                    values.put(SQLTableString.newsTableAttributes[3], newsBean.getNewslist().get(i).getDescription());
                                    values.put(SQLTableString.newsTableAttributes[4], newsBean.getNewslist().get(i).getPicUrl());
                                    values.put(SQLTableString.newsTableAttributes[5], newsBean.getNewslist().get(i).getUrl());
                                    db.insert(SQLTableString.newsTableName[sectionNumber], null, values);
                                    values.clear();
                                }
                                dbHelper.close();
                                db.close();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onComplete() {
                            //EventBus 发送消息告诉fragment数据已经储存完成。
                            EventBus.getDefault().post(new MessageEvent(navigationItemNumber, sectionNumber));
                        }
                    });

        } else if (navigationItemNumber == 1) {//干货集中营的网络请求
            Observable<GankBean> observable = request_interface.getGank(APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe(new Observer<GankBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(GankBean gankBean) {
                            if (gankBean != null) {
                                //SQLite数据表格
                                MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, SQLTableString.tableStore, null, 1);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                //先清空表中数据，
                                db.delete(SQLTableString.gankTableName[sectionNumber], null, null);
                                //让id重新从1开始
                                String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.gankTableName[sectionNumber] + "'";
                                db.execSQL(string);
                                //再存进新的数据
                                for (int i = 0; i < gankBean.getResults().size(); i++) {
                                    values.put(SQLTableString.gankTableAttributes[1], gankBean.getResults().get(i).get_id());
                                    values.put(SQLTableString.gankTableAttributes[2], gankBean.getResults().get(i).getCreatedAt());
                                    values.put(SQLTableString.gankTableAttributes[3], gankBean.getResults().get(i).getDesc());
                                    values.put(SQLTableString.gankTableAttributes[4], gankBean.getResults().get(i).getPublishedAt());
                                    values.put(SQLTableString.gankTableAttributes[5], gankBean.getResults().get(i).getSource());
                                    values.put(SQLTableString.gankTableAttributes[6], gankBean.getResults().get(i).getType());
                                    values.put(SQLTableString.gankTableAttributes[7], gankBean.getResults().get(i).getUrl());
                                    values.put(SQLTableString.gankTableAttributes[8], gankBean.getResults().get(i).getWho());
                                    if (gankBean.getResults().get(i).getImages() != null) {
                                        values.put(SQLTableString.gankTableAttributes[9], gankBean.getResults().get(i).getImages().get(0));//只保存第一张图片
                                    }
                                    db.insert(SQLTableString.gankTableName[sectionNumber], null, values);
                                    values.clear();
                                }
                                dbHelper.close();
                                db.close();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onComplete() {
                            //EventBus 发送消息告诉fragment数据已经储存完成。
                            EventBus.getDefault().post(new MessageEvent(navigationItemNumber, sectionNumber));
                        }
                    });
        } else if (navigationItemNumber == 2) {//休息频道的网络请求

            Observable<RestBean> observable = request_interface.getRest(APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe(new Observer<RestBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(RestBean restBean) {

                            if (restBean != null) {

                                if (sectionNumber == 0) {
                                    //SQLite数据表格
                                    MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, SQLTableString.tableStore, null, 1);
                                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    //先清空表中数据，
                                    db.delete(SQLTableString.restTableName[sectionNumber], null, null);
                                    //让id重新从1开始
                                    String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.restTableName[sectionNumber] + "'";
                                    db.execSQL(string);

                                    //再存进新的数据
                                    for (int i = 0; i < restBean.getResults().size(); i++) {
                                        values.put(SQLTableString.picTableAttributes[1], restBean.getResults().get(i).get_id());
                                        values.put(SQLTableString.picTableAttributes[2], restBean.getResults().get(i).getCreatedAt());
                                        values.put(SQLTableString.picTableAttributes[3], restBean.getResults().get(i).getDesc());
                                        values.put(SQLTableString.picTableAttributes[4], restBean.getResults().get(i).getPublishedAt());
                                        values.put(SQLTableString.picTableAttributes[5], restBean.getResults().get(i).getSource());
                                        values.put(SQLTableString.picTableAttributes[6], restBean.getResults().get(i).getType());
                                        values.put(SQLTableString.picTableAttributes[7], restBean.getResults().get(i).getUrl());
                                        values.put(SQLTableString.picTableAttributes[8], restBean.getResults().get(i).getWho());

                                        db.insert(SQLTableString.restTableName[sectionNumber], null, values);
                                        values.clear();
                                    }
                                    dbHelper.close();
                                    db.close();
                                } else {
                                    //SQLite数据表格
                                    MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, SQLTableString.tableStore, null, 1);
                                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    //先清空表中数据，
                                    db.delete(SQLTableString.transferTable, null, null);
                                    //让id重新从1开始
                                    String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.transferTable + "'";
                                    db.execSQL(string);

                                    //再存进新的数据
                                    for (int i = 0; i < restBean.getResults().size(); i++) {
                                        values.put(SQLTableString.transferAttributes[1], restBean.getResults().get(i).getUrl());
                                        db.insert(SQLTableString.transferTable, null, values);
                                        values.clear();
                                    }
                                    dbHelper.close();
                                    db.close();
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onComplete() {
                            //EventBus 发送消息告诉fragment数据已经储存完成。
                            EventBus.getDefault().post(new MessageEvent(navigationItemNumber, sectionNumber));
                        }
                    });
        }

    }

}

