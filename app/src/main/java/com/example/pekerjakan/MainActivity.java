package com.example.pekerjakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    TextView titleKerja, upahKerja;
    Button simpanButton;
    EditText inputtitleKerja, inputupahKerja;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference mTitleRef = myRef.child("titleKerja");
    DatabaseReference mUpahRef = myRef.child("upahKerja");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI Elements
        titleKerja = (TextView) findViewById(R.id.titleKerja);
        upahKerja = (TextView) findViewById(R.id.upahKerja);
        simpanButton = (Button) findViewById(R.id.simpanButton);
        inputtitleKerja = (EditText) findViewById(R.id.inputTitleKerja);
        inputupahKerja = (EditText) findViewById(R.id.inputUpahKerja);

    }

    protected void onStart(){
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

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = inputtitleKerja.getText().toString();
                String upah = inputupahKerja.getText().toString();
                mTitleRef.setValue(title);
                mUpahRef.setValue(upah);
            }
        });



    }
}
