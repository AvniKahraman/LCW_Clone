// DBHelper.java
package com.example.lcw_clone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DBHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Veritabanına yeni bir veri ekleme
    public void addReklam(String reklam_url) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_REKLAM_URL, reklam_url);

        database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    // Veritabanından verileri çekme
    public List<Models> getModelsList() {
        List<Models> modelsList = new ArrayList<>();
        String[] columns = {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_REKLAM_URL};

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                String reklam_url = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_REKLAM_URL));

                Models model = new Models();
                model.setReklamUrl(reklam_url);

                modelsList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return modelsList;
    }
}
