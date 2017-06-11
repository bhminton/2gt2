package com.example.bryan.a2gt2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bryan on 6/10/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GOODTHINGS.db";
    public static final String TABLE_GOODTHINGS= "goodthings";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_EVENTS = "GoodEvents";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_GOODTHINGS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT " +
                    COLUMN_EVENTS + " TEXT " +
                    ");";
            db.execSQL(query);
        }



    @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOODTHINGS);
            onCreate(db);
        }



    public void addRecord(String event, String date){
            ContentValues values = new ContentValues();
            values.put(COLUMN_DATE,date);
            values.put(COLUMN_EVENTS,event);
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_GOODTHINGS,null,values);
            db.close();

        }


    }

