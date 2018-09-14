package com.example.android.littlenews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.android.littlenews.bean.GankBean;
import com.example.android.littlenews.bean.NewsBean;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        if (navigationItemNumber ==0){

            Observable<NewsBean> observable = request_interface.getNews(
                    APIConfig.getPathUrl(sectionNumber
                    ));

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
                                DataMap.newsInstance().put(String.valueOf(sectionNumber), newsBean);
                                Log.i("---initData0---", "onNext: newsInstance");
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

        }else if (navigationItemNumber == 1){
            Observable<GankBean> observable = request_interface.getGank(
                    APIConfig.getPathUrl(sectionNumber));

            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<GankBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.i("---initData1---", "onSubscribe: navigationItemNumber "+MainActivity.navigationItemNumber);
                        }

                        @Override
                        public void onNext(GankBean gankBean) {

                            if (gankBean != null) {
                                Log.i("---initData1---", "onNext: ");
                                //将得到的newsBean对象保存
                                DataMap.gankInstance().put(String.valueOf(sectionNumber), gankBean);
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
