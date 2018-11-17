package com.example.anunay.internetbooklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    DatabaseReference dr;
    int count=0;
    //ArrayList<BookListModel> blm= new ArrayList<>();
    //BookListModel blmo=new BookListModel();
    BookListModel bm[]=new BookListModel[21];
    //BookListModel bp=new BookListModel("hello","dear");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=(RecyclerView)findViewById(R.id.rv1);
        rv.setLayoutManager(new LinearLayoutManager(this));
        dr=FirebaseDatabase.getInstance().getReference().child("books");
        String k=dr.push().getKey();
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    bm[count]=new BookListModel();
                    bm[count].setBookname(child.child("bookName").getValue(String.class));
                    bm[count].setBookauthor(child.child("bookAuthor").getValue(String.class));
                    //blmo.setBookname(child.child("bookName").getValue(String.class));
                    //blmo.setBookauthor(child.child("bookAuthor").getValue(String.class));
                    //blm.add(blmo);
                    count++;
                }
                BooksAdapter adapter = new BooksAdapter(bm);
                rv.setAdapter(adapter);
                //BooksAdapter adapter = new BooksAdapter(blm);
                //rv.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //String k=dr.push().getKey();
        //dr.child(k).setValue(bp);
    }
}
