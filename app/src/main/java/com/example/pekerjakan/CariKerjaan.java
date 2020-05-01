package com.example.pekerjakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CariKerjaan extends AppCompatActivity {

    TextView titleKerja, upahKerja, kontakHandle;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Loker");
    DatabaseReference mTitleRef = myRef.child("titleKerja");
    DatabaseReference mUpahRef = myRef.child("upahKerja");
    DatabaseReference mKontakRef = myRef.child("kontakHandle");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_kerjaan);

        titleKerja = (TextView) findViewById(R.id.titleKerjaan);
        upahKerja = (TextView) findViewById(R.id.upahKerjaan);
        kontakHandle = (TextView) findViewById(R.id.kontakHandle);

    }

    protected void onStart() {
        super.onStart();
        mTitleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                titleKerja.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mUpahRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                upahKerja.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mKontakRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                kontakHandle.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}