package com.discoveritech.discoverhoroscope.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.discoveritech.discoverhoroscope.GeneralClasses.Global;
import com.discoveritech.discoverhoroscope.GeneralClasses.PreferencesHandler;
import com.discoveritech.discoverhoroscope.PostWebAPIData;
import com.discoveritech.discoverhoroscope.R;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btn_aries, btn_taurus, btn_gemini, btn_cancer, btn_leo, btn_virgo, btn_libra, btn_scorpio, btn_sagittarius, btn_capricorn, btn_aquarius, btn_pisces;
    private TextView date;
    public static String selected_horoscope = "";
    Handler buttonHandler;
    Runnable buttonRunnable;
    PostWebAPIData postWebAPIData;
    private Dialog mDialog;
    Toolbar toolbar;
    PreferencesHandler preferencesHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        postWebAPIData = new PostWebAPIData();
        init();
    }

    public void init() {
        preferencesHandler = new PreferencesHandler(DashboardActivity.this);
        mDialog = new Dialog(DashboardActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_aries = (ImageButton) findViewById(R.id.btn_aries);
        PushDownAnim.setPushDownAnimTo(btn_aries);
        btn_aries.setOnClickListener(this);

        btn_taurus = (ImageButton) findViewById(R.id.btn_taurus);
        PushDownAnim.setPushDownAnimTo(btn_taurus);
        btn_taurus.setOnClickListener(this);

        btn_gemini = (ImageButton) findViewById(R.id.btn_gemini);
        PushDownAnim.setPushDownAnimTo(btn_gemini);
        btn_gemini.setOnClickListener(this);

        btn_cancer = (ImageButton) findViewById(R.id.btn_cancer);
        PushDownAnim.setPushDownAnimTo(btn_cancer);
        btn_cancer.setOnClickListener(this);

        btn_leo = (ImageButton) findViewById(R.id.btn_leo);
        PushDownAnim.setPushDownAnimTo(btn_leo);
        btn_leo.setOnClickListener(this);

        btn_virgo = (ImageButton) findViewById(R.id.btn_virgo);
        PushDownAnim.setPushDownAnimTo(btn_virgo);
        btn_virgo.setOnClickListener(this);

        btn_libra = (ImageButton) findViewById(R.id.btn_libra);
        PushDownAnim.setPushDownAnimTo(btn_libra);
        btn_libra.setOnClickListener(this);

        btn_scorpio = (ImageButton) findViewById(R.id.btn_scorpip);
        PushDownAnim.setPushDownAnimTo(btn_scorpio);
        btn_scorpio.setOnClickListener(this);

        btn_sagittarius = (ImageButton) findViewById(R.id.btn_sagittarius);
        PushDownAnim.setPushDownAnimTo(btn_sagittarius);
        btn_sagittarius.setOnClickListener(this);

        btn_capricorn = (ImageButton) findViewById(R.id.btn_capricorn);
        PushDownAnim.setPushDownAnimTo(btn_capricorn);
        btn_capricorn.setOnClickListener(this);

        btn_aquarius = (ImageButton) findViewById(R.id.btn_aquarious);
        PushDownAnim.setPushDownAnimTo(btn_aquarius);
        btn_aquarius.setOnClickListener(this);

        btn_pisces = (ImageButton) findViewById(R.id.btn_pisces);
        PushDownAnim.setPushDownAnimTo(btn_pisces);
        btn_pisces.setOnClickListener(this);

        date = findViewById(R.id.date_dashboard);
        date.setText(SplashActivity.currentDateTimeString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_aries:
                ShowPopup(v, "aries");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                //selected_horoscope = String.valueOf(R.string.aries);
                break;
            case R.id.btn_taurus:
                ShowPopup(v, "taurus");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_gemini:
                ShowPopup(v, "gemini");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_cancer:
                ShowPopup(v, "cancer");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_leo:
                ShowPopup(v, "leo");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_virgo:
                ShowPopup(v, "virgo");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_libra:
                ShowPopup(v, "libra");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_scorpip:
                ShowPopup(v, "scorpio");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_sagittarius:
                ShowPopup(v, "sagittarius");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_capricorn:
                ShowPopup(v, "capricorn");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_aquarious:
                ShowPopup(v, "aquarius");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
            case R.id.btn_pisces:
                ShowPopup(v, "pisces");
                buttonHandler = new Handler();
                buttonRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (PostWebAPIData.message.equals("success")) {
                            PostWebAPIData.message = "";
                            Global.changeActivity(DashboardActivity.this, new HoroscopeViewActivity());
                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                            finish();
                        } else if (PostWebAPIData.message.equals("unsuccess")) {
                            Global.mKProgressHUD.dismiss();
                        } else if (!PostWebAPIData.message.equals("")) {
                            Global.mKProgressHUD.dismiss();
                        } else {
                            buttonHandler.postDelayed(buttonRunnable, 200);
                        }
                    }
                };
                buttonHandler.post(buttonRunnable);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        CloseDialog(DashboardActivity.this, "Do you really want to exit this application?");
    }

    public void CloseDialog(final Context mContext, final String message) {
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(mContext, R.style.MyDialogStyle);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setNegativeButton("No",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        dialog.setPositiveButton("Yes",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAffinity();
                        System.exit(0);
                    }
                });
        dialog.show();
    }

    public void ShowPopup(View v, String star) {
        selected_horoscope = star.toUpperCase();
        LinearLayout today, yesterday, tomorrow;
        mDialog.setContentView(R.layout.customlayout);
        today = mDialog.findViewById(R.id.today);
        PushDownAnim.setPushDownAnimTo(today);
        yesterday = mDialog.findViewById(R.id.yesterday);
        PushDownAnim.setPushDownAnimTo(yesterday);
        tomorrow = mDialog.findViewById(R.id.tomorrow);
        PushDownAnim.setPushDownAnimTo(tomorrow);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postWebAPIData.getHoroscope(star, "today");
                Global.mKProgressHUD = KProgressHUD.create(DashboardActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
                Global.mKProgressHUD.show();
                mDialog.dismiss();
            }
        });
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postWebAPIData.getHoroscope(star, "yesterday");
                Global.mKProgressHUD = KProgressHUD.create(DashboardActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
                Global.mKProgressHUD.show();
                mDialog.dismiss();
            }
        });
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postWebAPIData.getHoroscope(star, "tomorrow");
                Global.mKProgressHUD = KProgressHUD.create(DashboardActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
                Global.mKProgressHUD.show();
                mDialog.dismiss();
            }
        });
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // show menu when menu button is pressed
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // display a message when a button was pressed
        String message = "";
        if (item.getItemId() == R.id.logout) {
            preferencesHandler.setUemail("");
            preferencesHandler.setUpwd("");
            Global.changeActivity(DashboardActivity.this, new LoginActivity());
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        } else if (item.getItemId() == R.id.profile) {
            Toast.makeText(DashboardActivity.this, "Will be available soon", Toast.LENGTH_SHORT).show();
//            Global.changeActivity(DashboardActivity.this, new UserProfile());
//            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//            finish();
        } else {
            message = "Why would you select that!?";
        }
        return true;
    }

}
