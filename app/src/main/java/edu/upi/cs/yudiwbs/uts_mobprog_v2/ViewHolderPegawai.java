package edu.upi.cs.yudiwbs.uts_mobprog_v2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/*
    tidak perlu ada yang diubah

 */

public class ViewHolderPegawai extends RecyclerView.ViewHolder {
    public TextView tvNama;

    public ViewHolderPegawai(@NonNull View itemView) {
        super(itemView);
        tvNama = itemView.findViewById(R.id.tvNama);
    }
}
