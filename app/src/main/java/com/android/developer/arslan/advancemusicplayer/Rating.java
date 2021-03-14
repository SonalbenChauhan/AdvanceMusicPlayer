package com.android.developer.arslan.advancemusicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    //variable declaration
    RatingBar rating;
    Button submitRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        //referring XML layout using Java objects
        rating = (RatingBar)findViewById(R.id.ratingBar);
        submitRate = (Button)findViewById(R.id.btnSubmit);

        //submit button on click listener
        submitRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rate = String.valueOf(rating.getRating());
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
