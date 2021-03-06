package com.example.pekerjakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class UploadKerjaan extends AppCompatActivity {

    Button simpanButton, backButton;
    EditText inputtitleKerja, inputupahKerja, inputKontak;

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("Loker");
//    DatabaseReference mTitleRef = myRef.child("titleKerja");
//    DatabaseReference mUpahRef = myRef.child("upahKerja");
//    DatabaseReference mKontakRef = myRef.child("kontakHandle");

//    CollectionReference mdocRef = FirebaseFirestore.getInstance().collection("loker");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_kerjaan);

        //UI Elements
        simpanButton = (Button) findViewById(R.id.simpanButton);
        backButton = (Button) findViewById(R.id.backButton);
        inputtitleKerja = (EditText) findViewById(R.id.inputTitleKerja);
        inputupahKerja = (EditText) findViewById(R.id.inputUpahKerja);
        inputKontak = (EditText) findViewById(R.id.inputKontak);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(UploadKerjaan.this,   MainActivity.class);
                startActivity(myIntent);
            }
        });

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = inputtitleKerja.getText().toString();
                String upah = inputupahKerja.getText().toString();
                String kontak = inputKontak.getText().toString();


                if(title.isEmpty() || upah.isEmpty() || kontak.isEmpty()){
                    Context context = getApplicationContext();
                    CharSequence text = "Seluruh field harus diisi!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    Intent myIntent = new Intent(UploadKerjaan.this, ConfirmPage.class);
                    myIntent.putExtra("title", title);
                    myIntent.putExtra("upah", upah);
                    myIntent.putExtra("kontak", kontak);

                    startActivity(myIntent);
                }
            }
        });

    }

}
