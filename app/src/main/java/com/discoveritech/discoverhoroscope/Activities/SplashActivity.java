package com.discoveritech.discoverhoroscope.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.discoveritech.discoverhoroscope.GeneralClasses.Global;
import com.discoveritech.discoverhoroscope.GeneralClasses.PreferencesHandler;
import com.discoveritech.discoverhoroscope.R;
import com.skyfishjy.library.RippleBackground;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SplashActivity extends AppCompatActivity {
    public static String currentDateTimeString;
    PreferencesHandler preferencesHandler;
    public int daycheck = 0;
    public static String apiData = "disable";
    private RippleBackground avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        avi = findViewById(R.id.avi);
        avi.startRippleAnimation();
        preferencesHandler = new PreferencesHandler(SplashActivity.this);
        daycheck = Integer.parseInt(preferencesHandler.getCurrentDay());

        currentDateTimeString = java.text.DateFormat.getDateInstance().format(new Date());
        apiData = "disable";
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!preferencesHandler.getCurrentDate().equals(currentDateTimeString)) {
                    preferencesHandler.setCurrentDate(currentDateTimeString);
                    daycheck++;
                    if (daycheck > 2) {
                        daycheck = 1;
                    }
                    preferencesHandler.setCurrentDay(String.valueOf(daycheck));
                }
                if (preferencesHandler.getUemail().equals("")) {
                    Global.changeActivity(SplashActivity.this, new LoginActivity());
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    avi.stopRippleAnimation();
                    finish();
                } else {
                    Global.changeActivity(SplashActivity.this, new DashboardActivity());
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    avi.stopRippleAnimation();
                    finish();
                }
            }
        }, 3000);
    }
}
