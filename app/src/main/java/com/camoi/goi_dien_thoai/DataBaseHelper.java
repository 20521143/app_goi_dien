package com.camoi.goi_dien_thoai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CONTACT_TABLE = "CONTACT_TABLE";
    public static final String COLUMN_CONTACT_ID = "CONTACT_ID";
    public static final String COLUMN_CONTACT_NAME = "CONTACT_NAME";
    public static final String COLUMN_CONTACT_PHONE = "CONTACT_PHONE";
    public static final String CALL_TABLE = "CALL_TABLE";
    public static final String COLUMN_CALL_ID = "CALL_ID";
    public static final String COLUMN_DATE_TIME = "DATE_TIME";
    public static final String COLUMN_DURATION = "DURATION";
    public static final String COLUMN_IS_MISSED = "IS_MISSED";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "call.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CONTACT_TABLE + " (" + COLUMN_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CONTACT_NAME + " TEXT, " + COLUMN_CONTACT_PHONE + " CHAR(13))";
        String createTableStatement1 = "CREATE TABLE " + CALL_TABLE + " (" + COLUMN_CALL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE_TIME + " DATETIME, " + COLUMN_DURATION + " INTEGER, " + COLUMN_IS_MISSED + " BOOLEAN, FOREIGN KEY(" + COLUMN_CONTACT_ID + ") REFERENCES CONTACT_TABLE(" + COLUMN_CONTACT_ID + " ))";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
