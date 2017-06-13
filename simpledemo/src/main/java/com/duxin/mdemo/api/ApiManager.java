package com.duxin.mdemo.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * company : 青苗
 * Created by 杜新 on 2017/6/13.
 */

public class ApiManager {

    private static ApiManager apiManager;

    public static ApiManager getInstence() {

        if (apiManager == null) {
            synchronized (ApiManager.class) {
                if (apiManager == null) {
                    apiManager = new ApiManager();
                }
            }
        }

        return apiManager;
    }

    private static BDJApi bdjApi;

    public BDJApi getVideoService() {
        if (bdjApi == null) {
            synchronized (new Object()) {
                if (bdjApi == null) {
                    bdjApi = new Retrofit.Builder()
                            .baseUrl("http://www.budejie.com/")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(BDJApi.class);
                }
            }
        }
        return bdjApi;
    }

}
