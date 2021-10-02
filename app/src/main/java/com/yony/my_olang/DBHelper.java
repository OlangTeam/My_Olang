package com.yony.my_olang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists board ("
                + "idx integer primary key autoincrement,"
                + "title char,"
                + "content text,"
                + "date date,"
                + "hit int,"
                + "user_idx int,"
                + "boardcol char);";
        db.execSQL(sql);
        db.execSQL("CREATE TABLE reply(idx INT primary key autoincrement, con_num INT, user_idx INT, content TEXT, date DATE, thumbs INT)");
        db.execSQL("CREATE TABLE rereply(idx INT primary key autoincrement, con_num INT, reply_num INT, user_idx INT, content TEXT, date DATE, thumbs INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists mytable";

        db.execSQL(sql);
        onCreate(db);
    }
}