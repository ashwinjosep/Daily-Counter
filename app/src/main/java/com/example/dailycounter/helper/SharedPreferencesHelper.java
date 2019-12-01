package com.example.dailycounter.helper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.dailycounter_application;

public class SharedPreferencesHelper {

    private static final String PREF_NAME = "com.example.dailycounter.helper";
    private static final int PRIVATE_MODE = 0;

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    private Context context;

    public SharedPreferencesHelper(){
        this.context = dailycounter_application.getAppContext();
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //Write functions
    //function to put in String values
    public void putStringValue(String key, String value)
    {
        editor.putString(key, value);
        editor.apply();
    }

    //function to put in Integer values
    public void putIntegerValue(String key, int value)
    {
        editor.putInt(key, value);
        editor.apply();
    }

    //function to put in Boolean values
    public void putBooleanValue(String key, boolean value)
    {
        editor.putBoolean(key, value);
        editor.apply();
    }


    //READ functions
    //function to read String values
    public String getStringValue(String key)
    {
        return pref.getString(key, null);
    }

    //function to read Integer values
    public int getIntegerValue(String key)
    {
        return pref.getInt(key, 0);
    }

    //function to read Boolean values
    public Boolean getBooleanValue(String key)
    {
        return pref.getBoolean(key, false);
    }


}
