package com.example.lcw_clone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lcw_database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "LCW_db_reklam";

    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_REKLAM_URL = "reklam_link";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_REKLAM_URL + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This method is not needed for now. You can remove it or add upgrade code here.
    }

    // Veri çekmek için bir metot
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null);
    }

    // DatabaseHelper sınıfında
    public List<String> getImageUrls() {
        List<String> imageUrlList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_REKLAM_URL + " FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_REKLAM_URL));
                imageUrlList.add(imageUrl);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return imageUrlList;
    }

    // DatabaseHelper sınıfı
    @SuppressLint("Range")
    public List<Models> getModelsList() {
        List<Models> modelsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Models model = new Models();
                model.setBigBoy(cursor.getString(cursor.getColumnIndex(COLUMN_REKLAM_URL)));
                modelsList.add(model);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return modelsList;
    }

}
