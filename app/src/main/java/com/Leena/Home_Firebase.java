package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Firebase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__firebase);


        Button getACT=(Button)findViewById(R.id.fetchuserr);
        Button fetchACT=(Button)findViewById(R.id.getuserr);
        Button insertACT=(Button)findViewById(R.id.insertuser);

        insertACT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Firebase.this,addToFireBase.class));
            }
        });

        fetchACT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Firebase.this,fetchUserFromFirebase.class));
            }
        });

        getACT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Firebase.this,MainActivity.class));
            }
        });
    }


}