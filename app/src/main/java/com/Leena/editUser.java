package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class editUser extends AppCompatActivity {



    Button editbt,deletbt,addFavoritebt;
    EditText firstName,lastName,phoneNumber,emailAddress;
    DatabaseReference databaseReference;
    SavedUser suser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);


        editbt = (Button) findViewById(R.id.editButton);
        deletbt = (Button) findViewById(R.id.deletButton);
        addFavoritebt = (Button) findViewById(R.id.addFavorite);

        firstName = (EditText) findViewById(R.id.editfirstName);
        lastName = (EditText) findViewById(R.id.editlastName);
        phoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        emailAddress = (EditText) findViewById(R.id.editemailAddress);


        firstName.setText(MainActivity.GfirstName);
        lastName.setText(MainActivity.GlastName);
        phoneNumber.setText(MainActivity.GphoneNumber);
        emailAddress.setText(MainActivity.GemailAdress);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");


        suser = new SavedUser(this);

        addFavoritebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                suser.addFavoriteUser((new SavedUser(firstName.getText().toString(),lastName.getText().toString(),phoneNumber.getText().toString(),emailAddress.getText().toString(),editUser.this)));

                Toast.makeText(getBaseContext(), "user added to Sqlite successfully", Toast.LENGTH_SHORT).show();

finish();
            }
        });

        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser(MainActivity.GkeyId,firstName.getText().toString(),lastName.getText().toString(),phoneNumber.getText().toString(),emailAddress.getText().toString());
                Toast.makeText(getBaseContext(), "user updated successfully", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        deletbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletUset(MainActivity.GkeyId);

                Toast.makeText(getBaseContext(), "user deleted successfully", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }

    public void deletUset(String key2delet)
    {

        databaseReference.child(key2delet).removeValue();


    }
    public void updateUser( String key2update, String firstName,String lastName , String phone , String email){


        databaseReference.child(key2update).child("firstName").setValue(firstName);
        databaseReference.child(key2update).child("lastName").setValue(lastName);
        databaseReference.child(key2update).child("phoneNumber").setValue(phone);
        databaseReference.child(key2update).child("emailAddress").setValue(email);



    }




}