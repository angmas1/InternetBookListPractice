package com.example.anunay.internetbooklist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Anunay on 19-02-2018.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    BookListModel bm[];
    //ArrayList<BookListModel> bm = new ArrayList<>();

    public BooksAdapter(BookListModel blm[]) {
        bm = blm;
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_books,parent,false);
        BooksViewHolder bvh=new BooksViewHolder(view);
        return bvh;
    }

    @Override
    public void onBindViewHolder(final BooksViewHolder holder, final int position) {
        holder.tvb.setText(bm[position].getBookname());
        holder.tva.setText(bm[position].getBookauthor());
        holder.tvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),bm[position].getBookname(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bm.length;
    }
}
