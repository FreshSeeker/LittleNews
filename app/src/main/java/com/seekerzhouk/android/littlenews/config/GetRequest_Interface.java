package com.seekerzhouk.android.littlenews.config;


import com.seekerzhouk.android.littlenews.bean.GankBean;
import com.seekerzhouk.android.littlenews.bean.NewsBean;
import com.seekerzhouk.android.littlenews.bean.RestBean;
import com.seekerzhouk.android.littlenews.bean.TransformBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetRequest_Interface {
    @GET
    Observable<NewsBean> getNews(@Url String url);

    @GET
    Observable<GankBean> getGank(@Url String url);

    @GET
    Observable<RestBean> getRest(@Url String url);

    @GET
    Observable<TransformBean> getTransform(@Url String url);
}
