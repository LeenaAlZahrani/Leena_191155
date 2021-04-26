package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeSqlite extends AppCompatActivity {

    DatabaseReference dbRef;
    SavedUser savedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sqlite);

        dbRef = FirebaseDatabase.getInstance().getReference("users");
        savedUser = new SavedUser(this);

        Button sqlfetch =(Button)findViewById(R.id.ftchsql);
        Button sqlALL=(Button)findViewById(R.id.sqlalll);


        sqlfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeSqlite.this,fetchUserFromSqlite.class));
            }
        });

        sqlALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeSqlite.this,ViewٍSavedUserSQlite.class));
            }
        });
    }
    public void addValuesFromFireTosqlaction(View view) {
        view.setEnabled(false);

        getDataFromFireBaseAndInserttoSqlite();
        Toast.makeText(getBaseContext(), "Please wait", Toast.LENGTH_SHORT).show();

    }
    public void getDataFromFireBaseAndInserttoSqlite()
    {
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User newuser = postSnapshot.getValue(User.class);
                    savedUser.addFavoriteUser((new SavedUser(newuser.getFirstName(),newuser.getLastName(),newuser.getPhoneNumber(),newuser.getEmailAddress(),HomeSqlite.this)));
                }Toast.makeText(getBaseContext(), "Users are added to Sqlite ", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}