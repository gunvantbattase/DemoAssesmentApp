package com.example.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.demo.R;


public class PreferenceManager {

    private static PreferenceManager mInstance;
    private Context mContext;
    private static final String PREFS_NAME = "goPaadi";
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;

    private PreferenceManager(Context context) {
        mContext = context;
    }

    public static PreferenceManager getInstance(Context context){
        if(mInstance==null){
            mInstance = new PreferenceManager(context);
        }
        return mInstance;
    }


    public void setStringPreferences(String key, String value){
        SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getString(R.string.app_name),
                Context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
    }

    public void connectDB()
    {
        SharedPreferences preferences = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }
    public void closeDB()
    {
        editor.commit();
    }

    public String getStringPreference(String key){
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }

    public void setIntPreferences(String key, int value){
        SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getString(R.string.app_name),
                Context.MODE_PRIVATE).edit();
        editor.putInt(key,value);
        editor.apply();
    }
    public int getIntPreference(String key){
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE);
        return preferences.getInt(key,0);
    }

    public void setBooleanPreferences(String key, boolean value){
        SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getString(R.string.app_name),
                Context.MODE_PRIVATE).edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean getBooleanPreference(String key){
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }

    public void clearPreferences() {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getString(R.string.app_name), Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
    }

}

