package edu.upi.cs.yudiwbs.uts_mobprog_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/*
tidak perlu ada yang diubah
 */
public class OpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbPegawai.db";
    public static final String TABLE_CREATE =
            "CREATE TABLE PEGAWAI (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAMA TEXT)";

    public OpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PEGAWAI");
    }
}
