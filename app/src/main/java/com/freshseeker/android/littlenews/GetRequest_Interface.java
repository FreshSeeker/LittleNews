package com.freshseeker.android.littlenews;


import com.freshseeker.android.littlenews.bean.GankBean;
import com.freshseeker.android.littlenews.bean.NewsBean;
import com.freshseeker.android.littlenews.bean.RestBean;
import com.freshseeker.android.littlenews.bean.TransformBean;

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
