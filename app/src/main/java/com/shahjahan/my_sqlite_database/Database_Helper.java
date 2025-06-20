package com.shahjahan.my_sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database";
    public static final int DB_VERSION = 1;


    public Database_Helper( Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table making formula  >>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //Fast table
        db.execSQL("CREATE TABLE my_table (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, mobile TEXT)");

        


       // if akadik table hoi
        //2nd table
        //db.execSQL("create table my_table_two (id INTAGER primary key autoincrement  , name_two TEXT, mobile_two TEXT)");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Fast table update>>>>>>>>>>>>>>>>>>
        db.execSQL(" DROP TABLE IF EXISTS my_table ");


        // if akadik table hoi
        //2nd table update>>>>>>>>>>>>>>>>>>
       // db.execSQL(" drop table if exists my_table_two ");
    }



public void insartData(String name,String mobile){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues conval = new ContentValues();
        conval.put("name",name);
        conval.put("mobile",mobile);
        database.insert("my_table",null,conval);



}








}
