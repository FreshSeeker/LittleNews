package com.example.android.littlenews;

import android.util.Log;

import com.example.android.littlenews.bean.NewsBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TSS {

    public static Object ttt(int secNumber) {

        final Object[] aaa = new Object[1];

        //RxJava2 + Retrofit2 作网络请求
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);

        //新闻API的网络请求，得到 NewsBean对象
        Observable<Object> observable = request_interface.getObject(
                APIConfig.getPathUrl(secNumber));

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.i("---initData0---", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Object object) {
                        aaa[0] = object;
                        Log.i("---initData0---", "onNext: " + object);
                        NewsBean newsBean = (NewsBean) aaa[0];

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


        return aaa[0];
    }


}
