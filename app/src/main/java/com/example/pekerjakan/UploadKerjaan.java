package com.example.pekerjakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadKerjaan extends AppCompatActivity {

    Button simpanButton;
    EditText inputtitleKerja, inputupahKerja, inputKontak;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Loker");
    DatabaseReference mTitleRef = myRef.child("titleKerja");
    DatabaseReference mUpahRef = myRef.child("upahKerja");
    DatabaseReference mKontakRef = myRef.child("kontakHandle");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_kerjaan);

        //UI Elements
        simpanButton = (Button) findViewById(R.id.simpanButton);
        inputtitleKerja = (EditText) findViewById(R.id.inputTitleKerja);
        inputupahKerja = (EditText) findViewById(R.id.inputUpahKerja);
        inputKontak = (EditText) findViewById(R.id.inputKontak);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = inputtitleKerja.getText().toString();
                String upah = inputupahKerja.getText().toString();
                String kontak = inputKontak.getText().toString();
                mTitleRef.setValue(title);
                mUpahRef.setValue(upah);
                mKontakRef.setValue(kontak);

                Intent myIntent = new Intent(UploadKerjaan.this,   recylerview_carikerja.class);


                startActivity(myIntent);
            }
        });

    }

}
