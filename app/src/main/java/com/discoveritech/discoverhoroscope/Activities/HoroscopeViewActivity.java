package com.discoveritech.discoverhoroscope.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codesgood.views.JustifiedTextView;
import com.discoveritech.discoverhoroscope.GeneralClasses.Global;
import com.discoveritech.discoverhoroscope.GeneralClasses.PreferencesHandler;
import com.discoveritech.discoverhoroscope.PostWebAPIData;
import com.discoveritech.discoverhoroscope.R;


public class HoroscopeViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView insta, fb, twitter;
    private TextView website, horoscope_name, date, horoscope_duration;
    private TextView txt_lower, txt_upper;
    private ImageView btn_back;
    PreferencesHandler preferencesHandler;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope_view);
        try {
            Global.mKProgressHUD.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
    }


    private void init() {
        preferencesHandler = new PreferencesHandler(HoroscopeViewActivity.this);

        date = findViewById(R.id.date_fragment);
        date.setText(SplashActivity.currentDateTimeString);

        insta = findViewById(R.id.img_insta);
        insta.setOnClickListener(this);

        fb = findViewById(R.id.img_fb);
        fb.setOnClickListener(this);

        twitter = findViewById(R.id.img_twiter);
        twitter.setOnClickListener(this);

        website = findViewById(R.id.lbl_website);
        website.setOnClickListener(this);

        txt_upper = findViewById(R.id.lbl_uper_txt);

        horoscope_name = findViewById(R.id.lbl_horoscope_name);
        horoscope_duration = findViewById(R.id.horoscope_duration);
        btn_back = findViewById(R.id.btn_back_horoscope_view);
        btn_back.setOnClickListener(this);

        horoscope_name.setText(DashboardActivity.selected_horoscope);
        horoscope_duration.setText(PostWebAPIData.date_range);
        txt_upper.setText(Html.fromHtml("<font color=#ffcc00>Current Date: </font>" + PostWebAPIData.current_date + "<br><br><font color=#ffcc00>Description:</font> " + PostWebAPIData.description + "<br><br><font color=#ffcc00>Compatibility:</font> " + PostWebAPIData.compatibility + "<br><font color=#ffcc00>Mood:</font> " + PostWebAPIData.mood + "<br><font color=#ffcc00>Colour:</font> " + PostWebAPIData.color + "<br><font color=#ffcc00>Lucky Number:</font> " + PostWebAPIData.lucky_number + "<br><font color=#ffcc00>Lucky Time:</font> " + PostWebAPIData.lucky_time));

//        if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.aries))) {
//            horoscope_name.setText(R.string.aries);
//            horoscope_duration.setText(R.string.duration_aries);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.aries_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.aries_two);
//                }
//            } else {
//            }
//
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.taurus))) {
//            horoscope_name.setText(R.string.taurus);
//            horoscope_duration.setText(R.string.duration_taurus);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.taurus_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.taurus_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.gemini))) {
//            horoscope_name.setText(R.string.gemini);
//            horoscope_duration.setText(R.string.duration_gimini);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.gemini_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.gemini_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.cancer))) {
//            horoscope_name.setText(R.string.cancer);
//            horoscope_duration.setText(R.string.duration_cancer);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.cancer_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.cancer_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.leo))) {
//            horoscope_name.setText(R.string.leo);
//            horoscope_duration.setText(R.string.duration_leo);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.leo_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.leo_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.virgo))) {
//            horoscope_name.setText(R.string.virgo);
//            horoscope_duration.setText(R.string.duration_virgo);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.virgo_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.virgo_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.libra))) {
//            horoscope_name.setText(R.string.libra);
//            horoscope_duration.setText(R.string.duration_libra);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.libra_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.libra_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.scorpio))) {
//            horoscope_name.setText(R.string.scorpio);
//            horoscope_duration.setText(R.string.duration_scorpio);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.scorpio_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.scorpio_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.saggitarius))) {
//            horoscope_name.setText(R.string.saggitarius);
//            horoscope_duration.setText(R.string.duration_sagittarius);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.sagittarius_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.sagittarius_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.capricorn))) {
//            horoscope_name.setText(R.string.capricorn);
//            horoscope_duration.setText(R.string.duration_capricorn);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.capricorn_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.capricorn_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.aquarius))) {
//            horoscope_name.setText(R.string.aquarius);
//            horoscope_duration.setText(R.string.duration_aquarius);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.aquarius_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.aquarius_two);
//                }
//            } else {
//            }
//        } else if (DashboardActivity.selected_horoscope.equals(String.valueOf(R.string.pisces))) {
//            horoscope_name.setText(R.string.pisces);
//            horoscope_duration.setText(R.string.duration_pisces);
//            if (SplashActivity.apiData.equals("disable")) {
//                if (preferencesHandler.getCurrentDay().equals("1")) {
//                    txt_upper.setText(R.string.pisces_one);
//                } else if (preferencesHandler.getCurrentDay().equals("2")) {
//                    txt_upper.setText(R.string.pisces_two);
//                }
//            } else {
//            }
//        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_horoscope_view:
                Global.changeActivity(HoroscopeViewActivity.this, new DashboardActivity());
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            case R.id.img_fb:
                Global.RedirectedDialog(HoroscopeViewActivity.this, "https://www.facebook.com/discoveritechh/", "You will be redirected to our Facebook profile.");
                break;
            case R.id.img_insta:
                Global.RedirectedDialog(HoroscopeViewActivity.this, "https://www.instagram.com/discoveritech/", "You will be redirected to our Instagram profile.");
                break;
            case R.id.img_twiter:
                Global.RedirectedDialog(HoroscopeViewActivity.this, "https://twitter.com/discoveritech", "You will be redirected to our Twitter profile.");
                break;
            case R.id.lbl_website:
                Global.RedirectedDialog(HoroscopeViewActivity.this, "https://discoveritech.org/", "You will be redirected to the DiscoverITECH website.");
                break;
        }
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        Global.changeActivity(HoroscopeViewActivity.this, new DashboardActivity());
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }
}