package com.teamcognito.pushnotification.APIInterface;

import com.google.gson.JsonObject;
import com.teamcognito.pushnotification.model.UpdateFBTokenParameter;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("fcmdevice")
    Call<ResponseBody> update(@Body UpdateFBTokenParameter updateFBTokenParameter);

}


