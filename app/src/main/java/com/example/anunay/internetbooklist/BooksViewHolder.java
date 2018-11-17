package com.example.anunay.internetbooklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anunay on 19-02-2018.
 */

public class BooksViewHolder extends RecyclerView.ViewHolder {
    TextView tvb;
    TextView tva;
    public BooksViewHolder(View itemview)
    {
        super(itemview);
        tvb=itemview.findViewById(R.id.tvb);
        tva=itemview.findViewById(R.id.tva);
    }
}
