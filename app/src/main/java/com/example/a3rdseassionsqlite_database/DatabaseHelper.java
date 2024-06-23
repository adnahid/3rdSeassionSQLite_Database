package com.example.a3rdseassionsqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String dbName = "my_database";
    public static final int dbVersion = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table my_table(id INTEGER primary key autoincrement, name TEXT, mobile TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop table if exists my_table");

    }

    public void insertData(String name,String mobile){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        sqLiteDatabase.insert("my_table",null,contentValues);

    }


    public Cursor getAllData (){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table",null);
        return cursor;

    }


    public Cursor searchInID (int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table where id like '"+id+"' ",null);
        return cursor;

    }


    public Cursor searchInString (String name){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from my_table where name like '%"+name+"%' ",null);
        return cursor;

    }






}
