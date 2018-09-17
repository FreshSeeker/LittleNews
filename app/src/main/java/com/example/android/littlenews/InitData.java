package com.example.android.littlenews;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.android.littlenews.bean.GankBean;
import com.example.android.littlenews.bean.NewsBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitData {


    @SuppressLint("CheckResult")
    public static void initData(final Context context, int navigationItemNumber, final int sectionNumber) {

        //RxJava2 + Retrofit2 作网络请求
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        if (navigationItemNumber == 0) {//新闻API的网络请求，得到 NewsBean对象
            Observable<NewsBean> observable = request_interface.getNews(
                    APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                            Log.i("---initData0---", "onSubscribe: ");
                        }

                        @Override
                        public void onNext(NewsBean newsBean) {
                            if (newsBean != null) {
                                //创建SQLite数据表格
                                MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, "TableStore.db", null, 1);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                //先清空表中数据，
                                db.delete(SQLTableString.newsTableName[sectionNumber], null, null);
                                //让id重新从1开始
                                String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.newsTableName[sectionNumber] + "'";
                                db.execSQL(string);
                                //再存进新的数据
                                for (int i = 0; i < newsBean.getNewslist().size(); i++) {
                                    values.put("ctime", newsBean.getNewslist().get(i).getCtime());
                                    values.put("title", newsBean.getNewslist().get(i).getTitle());
                                    values.put("description", newsBean.getNewslist().get(i).getDescription());
                                    values.put("picUrl", newsBean.getNewslist().get(i).getPicUrl());
                                    values.put("url", newsBean.getNewslist().get(i).getUrl());
                                    db.insert(SQLTableString.newsTableName[sectionNumber], null, values);
                                    values.clear();
                                }
                                Log.i("---initData0---", "onNext: ");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

//                            Toast.makeText(context, R.string.loaded_fail, Toast.LENGTH_SHORT).show();
                            Log.i("---initData0---", "onError: ");
                        }

                        @Override
                        public void onComplete() {

//                            Toast.makeText(context, R.string.loaded_str, Toast.LENGTH_SHORT).show();
                            Log.i("---initData0---", "onComplete: ");
                        }
                    });

        } else if (navigationItemNumber == 1) {//干货集中营的网络请求，得到 GankBean 对象
            Observable<GankBean> observable = request_interface.getGank(
                    APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<GankBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.i("---initData1---", "onSubscribe: ");
                        }

                        @Override
                        public void onNext(GankBean gankBean) {

                            if (gankBean != null) {
                                //创建SQLite数据表格
                                MyDataBaseHelper dbHelper = new MyDataBaseHelper(context, "TableStore.db", null, 1);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                //先清空表中数据，
                                db.delete(SQLTableString.gankTableName[sectionNumber], null, null);
                                //让id重新从1开始
                                String string = "update sqlite_sequence set seq=0 where name='" + SQLTableString.gankTableName[sectionNumber] + "'";
                                db.execSQL(string);
                                //再存进新的数据
                                for (int i = 0; i < gankBean.getResults().size(); i++) {
                                    values.put("_id", gankBean.getResults().get(i).get_id());
                                    values.put("createdAt", gankBean.getResults().get(i).getCreatedAt());
                                    values.put("desc", gankBean.getResults().get(i).getDesc());
                                    values.put("publishedAt", gankBean.getResults().get(i).getPublishedAt());
                                    values.put("source", gankBean.getResults().get(i).getSource());
                                    values.put("type", gankBean.getResults().get(i).getType());
                                    values.put("url", gankBean.getResults().get(i).getUrl());
                                    values.put("who", gankBean.getResults().get(i).getWho());
                                    if(gankBean.getResults().get(i).getImages() != null){
                                        values.put("image", gankBean.getResults().get(i).getImages().get(0));//只保存第一张图片
                                    }
                                    db.insert(SQLTableString.gankTableName[sectionNumber], null, values);
                                    values.clear();
                                }
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
//                            Toast.makeText(context, R.string.loaded_fail, Toast.LENGTH_SHORT).show();
                            Log.i("---initData1---", "onError: ");
                        }

                        @Override
                        public void onComplete() {
//                            Toast.makeText(context, R.string.loaded_str, Toast.LENGTH_SHORT).show();
                            Log.i("---initData1---", "onComplete: ");
                        }
                    });
        }

    }
}
