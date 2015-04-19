package com.omatt.alarmdemo.db;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import com.omatt.alarmdemo.R;

/**
 * Created by Omatt on 4/19/2015.
 */
public class Reminder extends Application {

    public static DbHelper dbHelper;
    public static SQLiteDatabase db;
    public static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();

        PreferenceManager.setDefaultValues(this, R.xml.settings, false);
        sp = PreferenceManager.getDefaultSharedPreferences(this);

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public static String getRingtone() {
        return sp.getString(Reminder.RINGTONE_PREF, DEFAULT_NOTIFICATION_URI.toString());
    }

}
