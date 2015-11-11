package com.njajal.tryretrofit;

import com.njajal.tryretrofit.POJO.Status;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

/**
 * Created by ali on 10/11/15.
 */
public interface RestTry {
    @GET("/pinger/ping")
    void getStatus(Callback<Status> cb);

}
