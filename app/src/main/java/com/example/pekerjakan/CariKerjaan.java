package com.example.pekerjakan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class CariKerjaan extends AppCompatActivity {
    public static final String TITLE_PEKERJAAN = "titlePekerjaan";
    public static final String UPAH_PEKERJAAN = "upahPekerjaan";
    public static final String KONTAK_HANDLE = "kontakHandle";

    TextView titleKerja, upahKerja, kontakHandle;
    Button uploadButton;
    CollectionReference mdocRef = FirebaseFirestore.getInstance().collection("loker");


//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference();
//    DatabaseReference mTitleRef = myRef.child("Loker/titleKerja");
//    DatabaseReference mUpahRef = myRef.child("Loker/upahKerja");
//    DatabaseReference mKontakRef = myRef.child("Loker/kontakHandle");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_kerjaan);


        titleKerja = (TextView) findViewById(R.id.titleKerjaan);
        upahKerja = (TextView) findViewById(R.id.upahKerjaan);
        kontakHandle = (TextView) findViewById(R.id.kontakHandle);
        uploadButton = (Button) findViewById(R.id.uploadButton);

        String title = getIntent().getStringExtra("title");
        String upah = getIntent().getStringExtra("upah");
        String kontak = getIntent().getStringExtra("kontak");


        titleKerja.setText(title);
        upahKerja.setText(upah);
        kontakHandle.setText(kontak);

       uploadButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Map<String, Object> dataToSave = new HashMap<String, Object>();

               String title = getIntent().getStringExtra("title");
               String upah = getIntent().getStringExtra("upah");
               String kontak = getIntent().getStringExtra("kontak");

               dataToSave.put(TITLE_PEKERJAAN, title);
               dataToSave.put(UPAH_PEKERJAAN, upah);
               dataToSave.put(KONTAK_HANDLE, kontak);
               mdocRef.add(dataToSave);

               Context context = getApplicationContext();
               CharSequence text = "Upload berhasil!";
               int duration = Toast.LENGTH_SHORT;

               Toast toast = Toast.makeText(context, text, duration);
               toast.show();

               Intent myIntent = new Intent(CariKerjaan.this,   recylerview_carikerja.class);


               startActivity(myIntent);


           }
       });


    }



//    protected void onStart() {
//        super.onStart();

//        mdocRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                String title = documentSnapshot.getString("titlePekerjaan");
//                String upah = documentSnapshot.getString("upahPekerjaan");
//                String kontak = documentSnapshot.getString("kontakHandle");
//
//                titleKerja.setText(title);
//                upahKerja.setText(upah);
//                kontakHandle.setText(kontak);
//            }
//        });


//        mTitleRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue().toString();
//                titleKerja.setText(text);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        mUpahRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                upahKerja.setText(text);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        mKontakRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                kontakHandle.setText(text);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
    }
