package com.example.pekerjakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class recylerview_carikerja extends AppCompatActivity {

    String titlekerja[], upahkerja[];
    RecyclerView carikerja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_carikerja);

        carikerja = (RecyclerView) findViewById(R.id.carikerja_recycler);
        titlekerja = getResources().getStringArray(R.array.titleKerja);
        upahkerja = getResources().getStringArray(R.array.upahKerja);

        MyAdapter myAdapter = new MyAdapter(this, titlekerja, upahkerja);
        carikerja.setAdapter(myAdapter);
        carikerja.setLayoutManager(new LinearLayoutManager(this));
    }
}
