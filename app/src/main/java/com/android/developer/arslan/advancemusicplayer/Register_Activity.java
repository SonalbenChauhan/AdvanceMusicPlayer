package com.android.developer.arslan.advancemusicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Activity extends MainActivity {

    //variable declaration
    EditText firstName, lastName, userId, password;
    Button register;
    boolean addRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        //referring XML layout using Java objects
        firstName = (EditText)findViewById(R.id.txtFirstName);
        lastName = (EditText)findViewById(R.id.txtLastName);
        userId = (EditText)findViewById(R.id.txtUserIdLogIn);
        password = (EditText)findViewById(R.id.txtPasswordLogIn);
        register = (Button)findViewById(R.id.btnReg);





        //on click listener to register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting up SharedPreferences
                SharedPreferences preferences = getSharedPreferences("DETAILS", MODE_PRIVATE);
                String fName = firstName.getText().toString();
                String lName = lastName.getText().toString();
                String uId = userId.getText().toString();
                String uPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(uId + uPassword + "data", fName + "\n" + uId);
                editor.commit();


                //saving user details in database
                addRecord = databaseHandler.AddRecordTo_userDetails(fName, lName, uId, uPassword);
                if(addRecord == true)
                {
                    Toast.makeText(getApplicationContext(), "User Resgistered!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                }

                Intent logInScreen = new Intent(Register_Activity.this, MainActivity.class);
                startActivity(logInScreen);
            }
        });


    }
}
