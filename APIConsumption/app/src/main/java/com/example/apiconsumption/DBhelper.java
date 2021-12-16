package com.example.apiconsumption;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBhelper extends SQLiteOpenHelper {

    public final static String DBNAME = "studentsDB";
    public final static int VERSION = 1;
    public DBhelper(Context context)
    {
        super(context,DBNAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE students (Name TEXT, Phone TEXT,Email TEXT,City TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean InsertData(String name,String phone,String email,String city)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Phone",phone);
        contentValues.put("Email",email);
        contentValues.put("City",city);
        System.out.println(contentValues.get("Name"));
        db.insert("students",null,contentValues);
        return true;

    }
    public Cursor showAll()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from students";
        Cursor cursor = db.rawQuery(query,null);
        System.out.println(cursor.getCount());
        return cursor;

    }
    public void deleteRecord(String name)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE from students WHERE Name='"+name+"'";
        db.execSQL(query);
        db.close();
    }
    public Cursor search(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from students WHERE Name='"+name+"'";
        Cursor cursor = db.rawQuery(query,null);
        System.out.println(cursor.getCount());
        return cursor;
    }
    public void updateRecord(String oldname,String name,String phone, String street,String email,String city)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "UPDATE students SET Name='"+name+"',Phone='"+phone+"', Email = '"+email+"' , City='"+city+"' WHERE Name='"+oldname+"'";
        db.execSQL(query);
    }
}
