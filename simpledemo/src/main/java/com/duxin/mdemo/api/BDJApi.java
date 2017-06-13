package com.duxin.mdemo.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * company : 青苗
 * Created by 杜新 on 2017/6/13.
 */

public interface BDJApi {

    @GET("video/{page}")
    Observable<ResponseBody> getVideoData(@Path("page") int page);

}
