package com.android.developer.arslan.advancemusicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogIn extends AppCompatActivity {

    //variable declaration
    EditText userIdLogIn, passLogIn;
    Button reg, logIn, admin;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);

        //referring XML layout using Java objects
        userIdLogIn = (EditText)findViewById(R.id.txtUserIdLogIn);
        passLogIn = (EditText)findViewById(R.id.txtPasswordLogIn);
        reg = (Button)findViewById(R.id.btnRegHome);
        logIn = (Button)findViewById(R.id.btnLogin);
        admin = (Button)findViewById(R.id.txtAdmin);

        // object creation of DatabaseHandler class
        databaseHandler = new DatabaseHandler(this);

        //writing the On click listener for handling login button clicks
        logIn.setOnClickListener(new View.OnClickListener() {
            //on Click event related with lonin button
            @Override

            public void onClick(View v) {
                String userId = userIdLogIn.getText().toString();
                String pass = passLogIn.getText().toString();

                //Declaring Shared Preferences
                SharedPreferences preferences = getSharedPreferences("DETAILS", MODE_PRIVATE);
                String userDetails = preferences.getString(userId + pass + "data", "User name or password is incorrect!");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                //Setting intent to go to next Activity
                Intent playerScreen = new Intent(AdminLogIn.this, Audience_Activity.class);
                startActivity(playerScreen);
            }
        });
    }
}
