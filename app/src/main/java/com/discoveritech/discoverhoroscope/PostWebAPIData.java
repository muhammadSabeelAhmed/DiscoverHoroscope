package com.discoveritech.discoverhoroscope;

import android.util.Log;

import com.discoveritech.discoverhoroscope.GeneralClasses.Horoscope;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostWebAPIData {
    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
    public static String date_range = "";
    public static String current_date = "";
    public static String description = "";
    public static String compatibility;
    public static String mood;
    public static String color;
    public static String lucky_number;
    public static String lucky_time;
    public static String failureTimeout = "";
    public static String message = "";

    public void getHoroscope(String sign, String day) {
        Call<Horoscope> call = apiInterface.getHoroscope(sign, day);
        call.enqueue(new Callback<Horoscope>() {
            @Override
            public void onResponse(Call<Horoscope> call, Response<Horoscope> response) {
                if (response.isSuccessful()) {
                    date_range = response.body().getDate_range();
                    current_date = response.body().getCurrent_date();
                    description = response.body().getDescription();
                    compatibility = response.body().getCompatibility();
                    mood = response.body().getMood();
                    if (response.body().getMessage() != null) {
                        message = response.body().getMessage();
                    } else {
                        message = "success";
                    }
                    lucky_number = response.body().getLucky_number();
                    lucky_time = response.body().getLucky_time();
                    Log.d("MyResponse", "Success" + description);
                }
            }

            @Override
            public void onFailure(Call<Horoscope> call, Throwable t) {
                failureTimeout = t.getMessage();
                message = "unsuccess";
                Log.d("MyResponse", "Failure" + failureTimeout);
            }
        });
    }


}
