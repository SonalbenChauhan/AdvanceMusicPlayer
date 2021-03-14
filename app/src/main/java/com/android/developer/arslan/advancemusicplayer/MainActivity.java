package com.android.developer.arslan.advancemusicplayer;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //variable declaration
    EditText userIdLogIn, passLogIn;
    Button reg, logIn, admin;
    DatabaseHandler databaseHandler;
    SharedPreferences preferences;
    Intent intent1;
    Cursor data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            @Override
            public void onClick(View v) {
                 String userId = userIdLogIn.getText().toString();
                String pass = passLogIn.getText().toString();

                //Creating SharedPreferences for saving login details
                SharedPreferences preferences = getSharedPreferences("DETAILS", MODE_PRIVATE);
                String userDetails = preferences.getString(userId + pass + "data", "User name or password is incorrect!");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                //intent for going to next activity
                Intent playerScreen = new Intent(MainActivity.this, Tunes.class);
                startActivity(playerScreen);
            }
        });

        //writing the On click listener for handling register button clicks
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();

            }
        });

        //writing the On click listener for handling admin button clicks
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdminPage();
            }
        });
    }

    public void LogIn(){
        /*String pass = "a";
        String inputUserId = userIdLogIn.getText().toString();
        String inputPass = passLogIn.getText().toString();

        Cursor cursor = databaseHandler.showRecordsById_userDetails(inputUserId);
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(), "Wrong User Id or Password", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()) {
                pass = cursor.getString(4);
            }
            if(inputPass.equals(pass)){
                openMusicPlayer();
            }
        }*/

    }

    //function for opening Admin page
    public void openAdminPage(){
        Intent intent = new Intent(this, AdminLogIn.class);
        startActivity(intent);
    }

    //function for opening player
    public void openMusicPlayer(){
        Intent intent = new Intent(this, Tunes.class);
        startActivity(intent);
    }

    //function for opening registration page
    public void openRegistration(){
        Intent intent = new Intent(this, Register_Activity.class);
        startActivity(intent);
    }

    //Alert box creation
    public void ShowRecords(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
