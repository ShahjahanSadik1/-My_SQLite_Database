package com.shahjahan.my_sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper_two extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database_name";
    public static final int VERSION = 2;


    public Database_Helper_two( Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Table making formula  >>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //Fast table

        db.execSQL("CREATE TABLE my_table (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Dr_name TEXT," +
                "Dr_degree TEXT," +
                "Dr_category TEXT," +
                "Dr_chamber TEXT)");

        // if akadik table hoi
        //2nd table
        //db.execSQL("create table my_table_two (id INTAGER primary key autoincrement  , name_two TEXT, mobile_two TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Fast table update>>>>>>>>>>>>>>>>>>

        db.execSQL("DROP TABLE IF EXISTS my_table");

        // if akadik table hoi
        //2nd table update>>>>>>>>>>>>>>>>>>
        // db.execSQL(" drop table if exists my_table_two ");
    }



     public void insart_data(String Dr_name,String Dr_degree,String Dr_category,String Dr_chamber) {
        SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cursor = new ContentValues();
         cursor.put("Dr_name",Dr_name);
         cursor.put("Dr_degree",Dr_degree);
         cursor.put("Dr_category",Dr_category);
         cursor.put("Dr_chamber",Dr_chamber);
         db.insert("my_table",null,cursor)  ;
     }

     public Cursor All_data(){
        SQLiteDatabase db = this.getReadableDatabase();
         Cursor cursor = db.rawQuery("Select * from my_table",null)    ;
         return cursor;
     }



    public Cursor SearchDataBy_id(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from my_table where id like '"+id+"' ",null)    ;
        return cursor;
    }

    public Cursor SearchDataBy_name(String Dr_name){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from my_table where Dr_name like '%"+Dr_name+"%'",null)    ;
        return cursor;
    }









}//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
