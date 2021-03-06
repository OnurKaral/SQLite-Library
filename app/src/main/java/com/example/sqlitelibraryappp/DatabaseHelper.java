package com.example.sqlitelibraryappp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;




public class DatabaseHelper  extends SQLiteOpenHelper {

    private  Context context;
    private static  final  String DATABASE_NAME = "library.db";
    private static  final  int DATABASE_VERSION = 1;
    private static  final  String TABLE_NAME = "my_library";
    private static  final  String COLUMN_ID = "_id";
    private static  final  String COLUMN_TITLE = "book_title";
    private static  final  String COLUMN_AUTHOR = "book_author";
    private static  final  String COLUMN_PAGES = "book_pages";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_PAGES + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF  EXISTS " +  TABLE_NAME);
        onCreate(db);
    }


    void addBook(String title,String author,int pages ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_PAGES, pages);
        values.put(COLUMN_AUTHOR, author);
        long result = db.insert(TABLE_NAME,null, values);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }




    }

    Cursor readData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
