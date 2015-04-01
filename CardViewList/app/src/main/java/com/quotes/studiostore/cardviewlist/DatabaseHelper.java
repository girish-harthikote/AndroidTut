package com.quotes.studiostore.cardviewlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Girish.Harthikote on 2/24/2015.
 */
public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "quotes.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }

    public Cursor getQuotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTab1Quotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String[] selectionArgs = new String[]{"1","200"};
        String selection = "_id between ? and ?";
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTab2Quotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String[] selectionArgs = new String[]{"200","400"};
        String selection = "_id between ? and ?";
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTab3Quotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String[] selectionArgs = new String[]{"400","600"};
        String selection = "_id between ? and ?";
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTab4Quotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String[] selectionArgs = new String[]{"600","800"};
        String selection = "_id between ? and ?";
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTab5Quotes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "author", "quote"};
        String[] selectionArgs = new String[]{"800","1000"};
        String selection = "_id between ? and ?";
        String sqlTables = "quotesdbtable";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

}