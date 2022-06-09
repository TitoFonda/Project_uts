package com.example.project_uts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "db_uts_mobile_programming";
    public static String TABLE_NAME = "table_saran";

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersio) {

    }


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(id integer primary key autoincrement," +
                "nama VARCHAR(30)," +
                "email VARCHAR(30)," +
                "komentar TEXT," +
                "pertanyaan TEXT);");
    }
}