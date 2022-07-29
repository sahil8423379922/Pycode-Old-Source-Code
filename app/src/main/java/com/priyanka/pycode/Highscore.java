package com.priyanka.pycode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Highscore extends SQLiteOpenHelper {

    private static final String dbname = "highscore.db";
    private static final String tablename = "score";
    private static final int version = 1;
    public static final String col_1 = "ID";
    public static final String col_2 = "highscore";


    public Highscore(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + tablename + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,highscore INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablename);

        onCreate(db);

    }

    public boolean insertdata(Integer score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, score);
        Long sucess = db.insert(tablename, null, contentValues);

        if (sucess == -1) {
            return false;

        } else {
            return true;
        }

    }

    public Cursor getAlldata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + tablename + " where ID = 1 ", null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;



    }

    public boolean updataData(String ID,Integer score)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,ID);
        contentValues.put(col_2, score);
        db.update(tablename,contentValues,"ID = ?",new String[]{ID});
        return true;

    }
}
