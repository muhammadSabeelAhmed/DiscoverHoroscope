package com.discoveritech.discoverhoroscope;


import com.discoveritech.discoverhoroscope.GeneralClasses.Horoscope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    //    @FormUrlEncoded
//    @POST("sms")
//    Call<Messages> PostSMS(@Field("data") JSONObject data, @Header("Authorization") String authHeader);
    @POST(".")
    Call<Horoscope> getHoroscope(@Query("sign") String email,
                                 @Query("day") String password);

}
