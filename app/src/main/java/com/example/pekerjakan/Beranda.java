package com.example.pekerjakan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class Beranda extends AppCompatActivity {

        Button mUploadButton, mCariButton, mlogOutButton;
        TextView nameView;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mUploadButton = (Button) findViewById(R.id.uploadButton);
            mCariButton = (Button) findViewById(R.id.cariButton);
            mlogOutButton = (Button) findViewById(R.id.logOutButton);
            nameView = (TextView) findViewById(R.id.nameView);

            GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
            if(signInAccount!=null){
                nameView.setText(signInAccount.getDisplayName());
            }

            mlogOutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

            mUploadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent myIntent = new Intent(Beranda.this,   UploadKerjaan.class);


                    startActivity(myIntent);
                }
            });

            mCariButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent myIntent = new Intent(Beranda.this,   recylerview_carikerja.class);


                    startActivity(myIntent);
                }
            });

        }


    }
