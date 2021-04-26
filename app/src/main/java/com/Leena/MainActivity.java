package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static String GkeyId;

    public static int Guserid;
    public static String GfirstName;
    public static String GlastName;
    public static String GphoneNumber;
    public static String GemailAdress;

    DatabaseReference databaseReference;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> keyId = new ArrayList<String>();
    ListView userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");


        userList = (ListView) findViewById(R.id.userlist);
        getDataFromFireBase();
    }
    class customAdabterActivity extends BaseAdapter {

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public customAdabterActivity() {
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_user_layout, null);
            TextView firstName = (TextView) view.findViewById(R.id.firstName);
            TextView lastName = (TextView) view.findViewById(R.id.lastName);
            TextView emailAddress = (TextView) view.findViewById(R.id.emailAddress);
            TextView phoneNumber = (TextView) view.findViewById(R.id.phoneNumber);


            firstName.setText("First Name: " +users.get(position).getFirstName());
            lastName.setText("Last Name: " + users.get(position).getLastName());
            emailAddress.setText("Email Address: " +users.get(position).getEmailAddress());
            phoneNumber.setText("Phone Number: " + users.get(position).getPhoneNumber());


            return view;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        getDataFromFireBase();

    }

    public void getDataFromFireBase()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                users.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User newuser = postSnapshot.getValue(User.class);
                    keyId.add(postSnapshot.getKey().toString());
                    users.add(newuser);
                }
                customAdabterActivity theCustomAdabter = new customAdabterActivity();
                userList.setAdapter(theCustomAdabter);

                userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        GfirstName = users.get(position).getFirstName();

                        GlastName =  users.get(position).getLastName();

                        Guserid = users.get(position).getUserId();

                        GphoneNumber = users.get(position).getPhoneNumber();

                        GemailAdress = users.get(position).getEmailAddress();
                        GkeyId = keyId.get(position);


                        Intent goEdit = new Intent(MainActivity.this,editUser.class);
                        startActivity(goEdit);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}