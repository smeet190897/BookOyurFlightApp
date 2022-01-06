package com.superprojects.bookyourflightapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.superprojects.bookyourflightapp.Models.BookingsModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context,DBNAME , null, DBVERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table bookings" +
                        "(id integer primary key autoincrement," +
                        "username text," +
                        "flightname text,"+
                        "description text,"+
                        "price text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists bookings");
        onCreate(sqLiteDatabase);
    }

    public boolean insertBooking(String username,String flightname,String description,String price) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("flightname", flightname);
        values.put("description", description);
        values.put("price", price);
        long id = database.insert("bookings", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<BookingsModel> getBookings() {
        ArrayList<BookingsModel> bookings = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select username,flightname,description,price from bookings", null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                BookingsModel model = new BookingsModel();
                model.setUsername(cursor.getString(0));
                model.setFlightname(cursor.getString(1));
                model.setDescription(cursor.getString(2));
                model.setPrice(cursor.getString(3));
                bookings.add(model);
            }
        }

        cursor.close();
        database.close();
        return bookings;
    }

}
