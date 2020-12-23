package com.discoveritech.discoverhoroscope.GeneralClasses;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.discoveritech.discoverhoroscope.R;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.widget.Toast.LENGTH_SHORT;

public class Global {
    public static KProgressHUD mKProgressHUD;
    public static String controllerName = "";
    public static boolean isBackFunctionally = false;
    public static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static boolean useFontFotViews = true;
    public static String appFontNameLIGHT = "open-sans.light.ttf";
    public static String appFontNameREGULAR = "open-sans.regular.ttf";
    public static String appFontNameSemiBold = "open-sans.semibold.ttf";
    public static int toggle_key = 1;
    public static String device_back_tag = "";
    public String Base_URL = "https://discoveritech.org/";

    public static void SetView(Context mContext, android.widget.Button selectedView, boolean isBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void SetView(Context mContext, android.widget.TextView selectedView, boolean isBold, boolean isSemiBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            } else if (isSemiBold) {
                fontName = Global.appFontNameSemiBold;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void SetView(Context mContext, android.widget.EditText selectedView, boolean isBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void ReleaseMemoryOnDestory() {
        try {
            System.gc();
        } catch (Exception ee) {
        }

        try {
            Runtime.getRuntime().gc();
        } catch (Exception ee) {
        }
    }

    public static void HideKeyBoard(Context mContext, android.view.View clickedView) {
        try {
            android.view.inputmethod.InputMethodManager inputManager = (android.view.inputmethod.InputMethodManager)
                    mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(clickedView.getWindowToken(),
                    android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }


    public static int roundValue(float f) {
        int c = (int) ((f) + 0.5f);
        float n = f + 0.5f;
        return (n - c) % 2 == 0 ? (int) f : c;
    }


    public static void changeActivity(Context context, Activity activity) {

        Intent in = new Intent();
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        in.setClass(context, activity.getClass());
        context.startActivity(in);

    }

    public static void savedatatostorage(Context context, String data, String file_name) {
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(context.openFileOutput(file_name, Context.MODE_PRIVATE));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            out.write(data);
            out.write('\n');
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public static void OpenKeybord(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }


    public static void FragmentBackButtonClick(Activity mActivity) {
        Log.d("back_frag", Global.device_back_tag);
        mActivity.getFragmentManager().popBackStack(Global.device_back_tag,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void RedirectedDialog(final Context mContext, final String url, final String message) {
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
                        try {
                            Intent browserIntentsupport = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            mContext.startActivity(browserIntentsupport);
                            dialog.dismiss();
                        } catch (ActivityNotFoundException exception) {
                            Toast.makeText(mContext, "Web Browser not installed", LENGTH_SHORT).show();
                        }
                    }
                });
        dialog.show();
    }

    public static boolean CheckInternetConnectivity(Context con) {
        android.net.ConnectivityManager cm = (android.net.ConnectivityManager)
                con.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null
                && (cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected())) {
            return true;
        } else {
            NetworkError(con);
            return false;
        }
    }

    private static void NetworkError(Context mContext) {
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(mContext, R.style.MyDialogStyle);
        dialog.setTitle(" ");
        dialog.setCancelable(false);
        dialog.setMessage(R.string.lbl_network_error);
//        keyValue(mContext, "network_error")
//        keyValue(mContext, "ok")
        dialog.setPositiveButton(R.string.lbl_ok,
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }
}
