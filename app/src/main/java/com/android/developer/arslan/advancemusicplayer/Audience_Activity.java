package com.android.developer.arslan.advancemusicplayer;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Audience_Activity extends AppCompatActivity {
    //variable declaration
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audience_);

// object creation of DatabaseHandler class
        databaseHandler = new DatabaseHandler(this);

        //Calling function for all records
        Cursor record = databaseHandler.showRecords();

        if (record.getCount() == 0) {
            DisplayData("Error", "No Data Found.");
            return;
        }
        // adding the data result to string buffer
        StringBuffer buffer = new StringBuffer();
        while (record.moveToNext()) {
            buffer.append("ID: " + record.getInt(0) + "\n");
            buffer.append("First Name: " + record.getString(1) + "\n");
            buffer.append("Last Name: " + record.getString(2) + "\n");
            buffer.append("Email: " + record.getString(3) + "\n");
            buffer.append("Gender: " + record.getString(4) + "\n\n\n");

        }
        // invoking DisplayData function
        DisplayData("User Details:", buffer.toString());
    }
    //Alert box creation
    public void DisplayData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
