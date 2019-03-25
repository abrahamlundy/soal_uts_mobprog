package edu.upi.cs.yudiwbs.uts_mobprog_v2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

//tidak perlu ada yang diubah

public class AdapterPegawai extends RecyclerView.Adapter<ViewHolderPegawai> {

    ArrayList<Pegawai> alPegawai;

    @NonNull
    @Override
    public ViewHolderPegawai onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pegawai_row, viewGroup, false);
        return new ViewHolderPegawai(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPegawai vhPeg, int i) {
        Pegawai p = alPegawai.get(i);
        vhPeg.tvNama.setText(p.getNama());
    }

    @Override
    public int getItemCount() {
        return alPegawai.size();
    }


    public AdapterPegawai(ArrayList<Pegawai> alPegawai) {
        this.alPegawai = alPegawai;
    }


}
