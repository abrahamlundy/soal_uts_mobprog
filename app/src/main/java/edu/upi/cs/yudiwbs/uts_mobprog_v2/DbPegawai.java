package edu.upi.cs.yudiwbs.uts_mobprog_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
/*
   perlu dilengkapi
 */
public class DbPegawai {


    private  SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public DbPegawai(Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    //HATI-HATI nama tabelnya PEGAWAI, bukan MAHASISWA

    public void updatePegawai(String namaAsal, String namaTujuan) {
        //lengkapi lihat modul android db halaman terakhir

        ContentValues cv = new ContentValues();
        cv.put("nama",namaTujuan);
        db.update("PEGAWAI",cv,"nama=?",new String[]{namaAsal} );
    }

    public void deleteAll() {
        db.delete("PEGAWAI",null,null);
    }


    public void deletePegawai(String nama) {
        db.delete("PEGAWAI","nama=?",new String[]{nama});
    }

    public long insertPegawai(String nama) {
        // //Instansiasi content value
        ContentValues newValues = new ContentValues();
        newValues.put("NAMA", nama);
        //        newValues.put("ALAMAT", ALAMAT);
        return  db.insert("PEGAWAI", null, newValues);
        //return -1;
    }

    public ArrayList<Pegawai> getAllPegawai() {
        Cursor cur = null;
        ArrayList<Pegawai> out = new ArrayList<>();
        cur = db.rawQuery("SELECT NAMA FROM PEGAWAI Limit 20", null);
        if (cur.moveToFirst()) {
            do {
                Pegawai t = new Pegawai();
                t.nama = cur.getString(0);
                //t.ALAMAT = cur.getString(1);
                out.add(t);
            } while (cur.moveToNext());
        }
        cur.close();
        return out;
    }


}
