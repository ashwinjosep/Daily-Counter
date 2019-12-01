package com.example;

import android.app.Application;
import android.content.Context;

public class dailycounter_application extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        dailycounter_application.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return dailycounter_application.context;
    }
}
