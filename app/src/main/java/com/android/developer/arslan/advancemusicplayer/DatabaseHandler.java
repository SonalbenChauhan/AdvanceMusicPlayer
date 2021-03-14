package com.android.developer.arslan.advancemusicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    //DatabaseHandler Constructor
    public DatabaseHandler(@Nullable Context context)
    {
        super(context, "Music", null,1);
    }


    //Function for creating the tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS userDetails(User_Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName VARCHAR, LastName VARCHAR, userId VARCHAR," +
                " Password VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS rating(User_Id INTEGER PRIMARY KEY AUTOINCREMENT, userId VARCHAR," +
                " rate VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Function to add new record in the table userDetails
    public boolean AddRecordTo_userDetails (String FirstName, String LastName, String userId, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FirstName", FirstName);
        contentValues.put("LastName", LastName);
        contentValues.put("userId", userId);
        contentValues.put("Password", Password);
        db.insert("userDetails", null, contentValues);
        return true;
    }

    //function for showing all records in userDetails
    public Cursor showRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor records = db.rawQuery("SELECT * FROM " + "userDetails", null);
        return records;
    }

    //function to insert record in rating table
    public boolean AddRecordTo_rating (String userId, String rate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", userId);
        contentValues.put("rate", rate);
        db.insert("userDetails", null, contentValues);
        return true;
    }

    //function to show records by user id
    public Cursor showRecordsById_userDetails(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor records = db.rawQuery("SELECT Password FROM " + "userDetails" +" WHERE userId ="+ id, null);
        return records;
    }
}
