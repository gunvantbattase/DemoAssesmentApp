package com.example.demo.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.databinding.DialogProgressBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;



public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static ProgressDialog progressDialog;
    public PreferenceManager prefManager;
    public static long MAX_CLICK_INTERVAL = 1000;
    protected long lastClickedTime = 0;
    public DisplayMetrics metrices;
    private static BottomSheetDialog dialog = null;
    //protected final BetterActivityResult<Intent, ActivityResult> activityLauncher = BetterActivityResult.registerActivityForResult(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        prefManager = PreferenceManager.getInstance(getApplicationContext());
        metrices = getResources().getDisplayMetrics();
    }


    public static String getDate(String timestamp)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = format.format(new Date(Long.parseLong(timestamp)));

        return date;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /*public void showFancyToast(final String type, final String message) {
        try {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    switch (type) {
                        case Constants.SUCCESS:
                            Toasty.success(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
                            break;
                        case Constants.INFO:
                            Toasty.info(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
                            break;
                        case Constants.WARNING:
                            Toasty.warning(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
                            break;
                        case Constants.NORMAL:
                            Toasty.normal(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            break;
                        case Constants.ERROR:
                            Toasty.error(getApplicationContext(), message, Toast.LENGTH_LONG, true).show();
                            break;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    /*public void NoInternetConnection(Context context) {
        Dialog dialogWindow = new Dialog(context);
        dialogWindow.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(R.layout.dia_no_internet);
        dialog.setCancelable(false);

        ImageView imgNoIntImage = dialog.findViewById(R.id.imgNoIntImage);
        Button btnNext = dialog.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    dialog.hide();
                } else {

                    try {
                        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    showFancyToast(Constants.ERROR,getResources().getString(R.string.no_internet));
                }
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }*/
    public static boolean isValidEmailId(String email){
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
    public boolean isNullOrEmpty(String string){
        if(string == null || string.equals("")){
            return true;
        }
        return false;
    }
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo;
        try {
            netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        /*
         * Logic to Prevent the Launch Twice if User makes
         * the Tap(Click) very Fast.
         */
        if (SystemClock.elapsedRealtime() - lastClickedTime < MAX_CLICK_INTERVAL) {
            return;
        }
        lastClickedTime = SystemClock.elapsedRealtime();
        /*
         * Logic for hide keyboard on click
         */
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        };
    }
    /*public void NoInternetConnection(Context context) {
        Dialog dialogWindow = new Dialog(context);
        dialogWindow.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(R.layout.dia_no_internet);
        dialog.setCancelable(false);

        ImageView imgNoIntImage = dialog.findViewById(R.id.imgNoIntImage);
        Button btnNext = dialog.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline(context)) {
                    dialog.hide();
                } else {

                    try {
                        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    showFancyToast(Constants.ERROR,getResources().getString(R.string.no_internet));
                }
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }*/
    public void setLocal(Activity activity, String langCode)
    {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }


    public void showProgressDialog(Context context) {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                dismissProgressDialog();
            }
            progressDialog = new ProgressDialog(context, R.style.Theme_GoPaddiApp);
            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            progressDialog.setCancelable(false);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void showProgressDialog() {
             Dialog progressDialog;
            DialogProgressBinding dpb = DialogProgressBinding.inflate(LayoutInflater.from(this));
            progressDialog = new Dialog(this, androidx.appcompat.R.style.Theme_AppCompat_Dialog);
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }
            progressDialog.setCancelable(false);
            progressDialog.setContentView(dpb.getRoot());
            progressDialog.show();
        }

        public void hideProgressDialog() {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }


}
