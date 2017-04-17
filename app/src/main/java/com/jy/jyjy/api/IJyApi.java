package com.jy.jyjy.api;

import com.jy.jyjy.api.bean.CookieInfo;
import com.jy.jyjy.api.bean.NewsDetailInfo;
import com.jy.jyjy.api.bean.NewsInfo;
import com.jy.jyjy.api.bean.PhotoInfo;
import com.jy.jyjy.api.bean.PhotoSetInfo;
import com.jy.jyjy.api.bean.SpecialInfo;
import com.jy.jyjy.local.table.BeautyPhotoInfo;
import com.jy.jyjy.local.table.VideoInfo;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by long on 2016/8/22.
 * API 接口
 */
public interface IJyApi {

    /**
     * 测试cookie
     http://store.famdr.net/web/myTest
     *

     */
    @Headers(RetrofitService.CACHE_CONTROL_NETWORK)
    @GET("/web/myTest")
    Observable<CookieInfo> getCookieInfo();

}
