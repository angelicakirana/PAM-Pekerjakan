package com.example.pekerjakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ConfirmPage extends AppCompatActivity {

    public static final String TITLE_PEKERJAAN = "titlePekerjaan";
    public static final String UPAH_PEKERJAAN = "upahPekerjaan";
    public static final String KONTAK_HANDLE = "kontakHandle";

    TextView titleKerja, upahKerja, kontakHandle;
    Button uploadButton;
    CollectionReference mdocRef = FirebaseFirestore.getInstance().collection("loker");


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

                Intent myIntent = new Intent(ConfirmPage.this,   recylerview_carikerja.class);


                startActivity(myIntent);


            }
        });


    }
}
