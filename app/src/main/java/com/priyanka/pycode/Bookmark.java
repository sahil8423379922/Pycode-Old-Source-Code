package com.priyanka.pycode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bookmark extends SQLiteOpenHelper {
    private static final String dbname = "bookmark.db";
    private static final String tablename = "bookmark";
    private static final int version = 1;
    public static final String col_1 = "ID";
    public static final String col_2 = "url";
    public Bookmark(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tablename + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , url TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + tablename);
        onCreate(db);

    }

    public boolean insertdata(String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,url);
        Long sucess = db.insert(tablename, null, contentValues);

        if (sucess == -1) {
            return false;

        } else {
            return true;
        }

    }

    public Cursor getAlldata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + tablename , null);

        /*if (cursor != null) {
            cursor.moveToFirst();
        }*/
        return cursor;



    }

    public void delete()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ tablename);
    }
}
