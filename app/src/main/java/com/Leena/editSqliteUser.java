package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class editSqliteUser extends AppCompatActivity {


    Button editbt,deletbt;
    EditText firstName,lastName,phoneNumber,emailAddress;
    // get all books
    SavedUser favoriteUser;

    List<SavedUser> listuser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        favoriteUser = new SavedUser(this);


        listuser = favoriteUser.getAllfavoriteUsers(editSqliteUser.this);
        setContentView(R.layout.activity_edit_sqlite_user);

        editbt = (Button) findViewById(R.id.editButton);
        deletbt = (Button) findViewById(R.id.deletButton);

        firstName = (EditText) findViewById(R.id.editfirstName);
        lastName = (EditText) findViewById(R.id.editlastName);
        phoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        emailAddress = (EditText) findViewById(R.id.editemailAddress);

        firstName.setText(ViewٍSavedUserSQlite.SQLfirstName);
        lastName.setText(ViewٍSavedUserSQlite.SQLlastName);
        phoneNumber.setText(ViewٍSavedUserSQlite.SQLphoneNumber);
        emailAddress.setText(ViewٍSavedUserSQlite.SQLemailAdress);


        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "user updated successfully in SQLite", Toast.LENGTH_SHORT).show();
                favoriteUser.updateUser((new SavedUser(firstName.getText().toString(),lastName.getText().toString(),phoneNumber.getText().toString(),emailAddress.getText().toString(),editSqliteUser.this)),ViewٍSavedUserSQlite.SQLuserid);

                finish();

            }
        });

        deletbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getBaseContext(), "user deleted successfully in SQLite", Toast.LENGTH_SHORT).show();


                // delete one book
                favoriteUser.deleteBook(listuser.get(ViewٍSavedUserSQlite.SQLUserposition));
                finish();
            }
        });

    }


}