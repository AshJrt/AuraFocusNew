package com.example.musha.aninterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users_table";
    public static final String COL_1 = "userid";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "username";
    public static final String COL_5 = "password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (userid INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
    }

    public boolean insertData(String name, String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, username);
        contentValues.put(COL_5, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean loginCheck(String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from  users_table where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    public Cursor getname(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select name from  users_table where username=? and password=?",new String[]{username,password});
        return cursor;
    }

    public boolean updateData(String id,String name, String email, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contantValues = new ContentValues();
        contantValues.put(COL_1,id);
        contantValues.put(COL_2,name);
        contantValues.put(COL_3,email);
        contantValues.put(COL_4,username);
        contantValues.put(COL_5,password);
        db.update(TABLE_NAME, contantValues, "userid = ?",new String[]{id});

        return true;

    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"userid = ?",new String[] {id});

    }
}