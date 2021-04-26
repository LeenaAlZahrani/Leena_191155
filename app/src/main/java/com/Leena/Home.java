package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button gofirebase=(Button)findViewById(R.id.fireBaseApp);
        Button gosql=(Button)findViewById(R.id.SQLLiteApp);
        Button goweather=(Button)findViewById(R.id.WeatherApp);


        gofirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,Home_Firebase.class));
            }
        });

        gosql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,HomeSqlite.class));
            }
        });
        goweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,WeatherController.class));
            }
        });
    }


}