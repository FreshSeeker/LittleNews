package com.example.android.littlenews;


import com.example.android.littlenews.bean.GankBean;
import com.example.android.littlenews.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GetRequest_Interface {
    @GET
    Observable<NewsBean> getNews(@Url String url);

    @GET
    Observable<GankBean> getGank(@Url String url);
}
