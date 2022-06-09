package com.example.project_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private DbHelper dbHelper;
    SQLiteDatabase db;
    public DbConnection(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getReadableDatabase();
    }

    public void createTable(){
        dbHelper.createTable(db);
    }

    public void insertData(String nama, String email, String komentar, String pertanyaan){
        db.execSQL(String.format("INSERT INTO %s " +
                "(nama, email, komentar, pertanyaan)" +
                "VALUES" +
                "('%s', '%s', '%s', '%s')", DbHelper.TABLE_NAME, nama, email, komentar, pertanyaan));
    }

    public void updateData(int id, String nama, String email, String komentar, String pertanyaan){
        db.execSQL(String.format("UPDATE %s SET nama = '%s', email = '%s', komentar = '%s', pertanyaan = '%s' WHERE id = '%d'", DbHelper.TABLE_NAME, nama, email, komentar, pertanyaan, id ));
    }

    public Data getData(int id){
        Cursor cur = db.rawQuery(String.format("SELECT * FROM %s WHERE id='%s'", DbHelper.TABLE_NAME, id), null);
        cur.moveToFirst();
        int rId = cur.getInt(0);
        String nama = cur.getString(1);
        String email = cur.getString(2);
        String komentar = cur.getString(3);
        String pertanyaan = cur.getString(4);
        Data data = new Data(rId, nama, email, komentar, pertanyaan);
        cur.close();

        return data;
    }

    public List<Data> getDatas(){
        Cursor cur = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME, null);
        List<Data> data = new ArrayList<>();
        while(cur.moveToNext()){
            int id;
            String nama, email, komentar, pertanyaan;
            id = cur.getInt(0);
            nama = cur.getString(1);
            email = cur.getString(2);
            komentar = cur.getString(3);
            pertanyaan = cur.getString(4);

            data.add(new Data(id, nama, email, komentar, pertanyaan));
        }
        cur.close();

        return data;
    }

    public void deleteData(int id){
        db.execSQL("DELETE FROM " + dbHelper.TABLE_NAME + " WHERE id = '" + id + "'");
    }

    protected void finalize(){
        db.close();
    }
}