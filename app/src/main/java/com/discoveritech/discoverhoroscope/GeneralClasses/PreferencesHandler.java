package com.discoveritech.discoverhoroscope.GeneralClasses;


import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHandler {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private static final String CURRENT_DATE = "Feb 28, 2020";
    private static final String CURRENT_DAY = "1";
    private static final String APP_FIRST_TIME = "app_first_time";
    private static final String UEMAIL = "";
    private static final String UPWD = "upwd";
    private static final String ISAUTOCHECK = "isautocheck";
    public PreferencesHandler() {

    }

    public PreferencesHandler(Context context) {
        pref = context.getSharedPreferences("my_horoscope", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public String getCurrentDate() {
        return pref.getString(CURRENT_DATE, "Feb 28, 2020");
    }

    public void setCurrentDate(String currentDate) {
        editor.putString(CURRENT_DATE, currentDate);
        editor.apply();
        editor.commit();
    }

    public String getCurrentDay() {
        return pref.getString(CURRENT_DAY, "1");
    }

    public void setCurrentDay(String currentDay) {
        editor.putString(CURRENT_DAY, currentDay);
        editor.apply();
        editor.commit();
    }
    public String getAppFirstTime() {
        return pref.getString(APP_FIRST_TIME, "true");
    }

    public void setAppFirstTime(String appFirstTime) {
        editor.putString(APP_FIRST_TIME, appFirstTime);
        editor.apply();
        editor.commit();
    }

    public String getUemail() {
        return pref.getString(UEMAIL, "");
    }

    public void setUemail(String uemail) {
        editor.putString(UEMAIL, uemail);
        editor.apply();
        editor.commit();
    }

    public String getUpwd() {
        return pref.getString(UPWD, "");
    }

    public void setUpwd(String upwd) {
        editor.putString(UPWD, upwd);
        editor.apply();
        editor.commit();
    }

    public String getIsautocheck() {
        return pref.getString(ISAUTOCHECK, "false");
    }

    public void setIsautocheck(String isautocheck) {
        editor.putString(ISAUTOCHECK, isautocheck);
        editor.apply();
        editor.commit();
    }
}
