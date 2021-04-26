package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fetchUserFromFirebase extends AppCompatActivity {


    LinearLayout linerallValue;
    TextView fristname,lastname,phoneNumber,emailaddress;
    EditText useridText;
    Button getFeatchbt;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fetch_user_from_firebase);

        linerallValue = (LinearLayout) findViewById(R.id.allValues);

        linerallValue.setVisibility(View.INVISIBLE);

        useridText = (EditText) findViewById(R.id.useridSearch);
        getFeatchbt = (Button) findViewById(R.id.Featchbt);
        fristname = (TextView) findViewById(R.id.ffirstname);
        lastname = (TextView) findViewById(R.id.flastname);
        phoneNumber = (TextView) findViewById(R.id.fphonenumber);
        emailaddress = (TextView) findViewById(R.id.femail);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");



    }

    public void getuserAction(View view)
    {
        String userid = useridText.getText().toString().trim();

        if (!TextUtils.isEmpty(userid))
        {
            Toast.makeText(fetchUserFromFirebase.this, "Please Wait",
                    Toast.LENGTH_LONG).show();


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        //getting artist
                        User newuser = postSnapshot.getValue(User.class);
                        //adding artist to the list

                        Log.i("getUser",newuser.getUserId()+"");

                        String userIdForCompare = String.valueOf(newuser.getUserId());
                        if(userid.equals(userIdForCompare))
                        {
                            linerallValue.setVisibility(View.VISIBLE);

                            fristname.setText("First name: "+newuser.getFirstName());
                            lastname.setText("Last name: "+newuser.getLastName());
                            phoneNumber.setText("Phone Number: "+newuser.getPhoneNumber());
                            emailaddress.setText("Email Address: "+newuser.getEmailAddress());
                            break;
                        }

                    }




                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }




    }
}