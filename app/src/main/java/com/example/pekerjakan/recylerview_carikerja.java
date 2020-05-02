package com.example.pekerjakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class recylerview_carikerja extends AppCompatActivity {

//    String titlekerja[], upahkerja[];
    Button backButton;
    private FirebaseFirestore firebaseFirestore;
    FirestoreRecyclerAdapter adapter;
    RecyclerView carikerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_carikerja);

        backButton=(Button) findViewById(R.id.backButton);
        firebaseFirestore = FirebaseFirestore.getInstance();
        carikerja = (RecyclerView) findViewById(R.id.carikerja_recycler);
        //ubah untuk populate data shown dari firebase realtime database
//        titlekerja = getResources().getStringArray(R.array.titleKerja);
//        upahkerja = getResources().getStringArray(R.array.upahKerja);


        //Query
        Query query = firebaseFirestore.collection("loker");

        //RecyclerOptions
        FirestoreRecyclerOptions<LokerModel> options = new FirestoreRecyclerOptions.Builder<LokerModel>()
                .setQuery(query, LokerModel.class)
                .build();
         adapter = new FirestoreRecyclerAdapter<LokerModel, LokerViewHolder>(options) {
            @NonNull
            @Override
            public LokerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow, parent, false);
                return  new LokerViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull LokerViewHolder holder, int position, @NonNull LokerModel model) {
                holder.list_title.setText(model.getTitlePekerjaan());
                holder.list_upah.setText(model.getUpahPekerjaan());
                holder.list_kontak.setText(model.getKontakHandle());
            }
        };


        carikerja.setLayoutManager(new LinearLayoutManager(this));
        carikerja.setAdapter(adapter);


//        MyAdapter myAdapter = new MyAdapter(this, titlekerja, upahkerja);
//        carikerja.setAdapter(myAdapter);
//        carikerja.setLayoutManager(new LinearLayoutManager(this));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(recylerview_carikerja.this,   MainActivity.class);
                startActivity(myIntent);
            }
        });
    }


    private class LokerViewHolder extends RecyclerView.ViewHolder{
        TextView list_title, list_upah, list_kontak;

        public LokerViewHolder(@NonNull View itemView) {
            super(itemView);

            list_title=itemView.findViewById(R.id.titleKerja);
            list_upah=itemView.findViewById(R.id.upahKerja);
            list_kontak=itemView.findViewById(R.id.kontakHandle);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}
