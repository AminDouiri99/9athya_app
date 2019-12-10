package com.example.a9athya;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.a9athya.kathyaContract.*;
import androidx.annotation.Nullable;

public class kathyaDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="kathyalist.db";
    public static final int DATABASE_VERSION=1;
    public kathyaDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE ="CREATE TABLE "+
                kathyaEntry.TABLE_NAME +"("+kathyaEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                kathyaEntry.COL_NAME + " TEXT NOT NULL, "+
                kathyaEntry.COL_AMOUNT + " INTEGER NOT NULL, "+
                kathyaEntry.COL_TIMESTAMP+" TIMESTAMP DEFAULT CURRENT_TIMESTAMP"+
                ");";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+kathyaEntry.COL_NAME);
        onCreate(db);
    }
}
