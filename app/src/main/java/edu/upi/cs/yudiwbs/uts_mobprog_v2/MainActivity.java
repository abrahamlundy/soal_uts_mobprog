package edu.upi.cs.yudiwbs.uts_mobprog_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
/*
perlu dilengkapi
 */
public class MainActivity extends AppCompatActivity {

    DbPegawai dbPeg;
    ArrayList<Pegawai> alPegawaiRV = new ArrayList();
    ArrayList<Pegawai> alPegawaiDB;

    RecyclerView rvPegawai;
    RecyclerView.LayoutManager lm;
    AdapterPegawai adapter;

    public void refreshIsiRV() {
        //refresh isi recyle view berdasarkan isi db
        alPegawaiDB = dbPeg.getAllPegawai();
        alPegawaiRV.clear(); //kosongkan rec view
        for (Pegawai peg:alPegawaiDB) {
            alPegawaiRV.add(peg);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbPeg = new DbPegawai(getApplicationContext());
        dbPeg.open();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        rvPegawai= findViewById(R.id.rvPegawai);
        rvPegawai.setHasFixedSize(true);
        adapter = new AdapterPegawai(alPegawaiRV);
        lm= new LinearLayoutManager(this);
        
        rvPegawai.setAdapter(adapter);
        rvPegawai.setLayoutManager(lm);
        refreshIsiRV();

        // lengkapi inisialisasi recycle view.
        // adapter, class pegawai, layout dsb sudah disediakan jadi tidak perlu dibuat



        //jika sudah selesai dilengkapi panggil ini:
        //refreshIsiRV();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.mNimNama:
                Toast.makeText(getApplicationContext(),"Lundy Van Kevin, 1407229", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mTambahDB:
                //jangan diubah
                Toast.makeText(getApplicationContext(), "Tambah", Toast.LENGTH_LONG).show();
                dbPeg.insertPegawai("Ahmad");
                dbPeg.insertPegawai("Elfan");
                dbPeg.insertPegawai("Badu");
                refreshIsiRV();
                return true;

            case R.id.mTambahManual:
                //lengkapi agar menambahkan
                //"Manual Ahmad"
                //"Manual Badu"
                //"Manual Elfan"
                alPegawaiRV.add(new Pegawai("Ahmad"));
                alPegawaiRV.add(new Pegawai("Badu"));
                alPegawaiRV.add(new Pegawai("Elfan"));
                adapter.notifyDataSetChanged();
                return true;

            case R.id.mUpdate:
                //jangan diubah
                Toast.makeText(getApplicationContext(), "Update Badu jadi Budi", Toast.LENGTH_LONG).show();
                dbPeg.updatePegawai("Badu","Budi");
                refreshIsiRV();
                return true;

            case R.id.mHapus:
                //jangan diubah
                Toast.makeText(getApplicationContext(), "Hapus Ahmad", Toast.LENGTH_LONG).show();
                dbPeg.deletePegawai("Ahmad");
                refreshIsiRV();
                return true;

            case R.id.mHapusSemua:
               dbPeg.deleteAll();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onDestroy() {
        dbPeg.close();
        super.onDestroy();
    }

}
