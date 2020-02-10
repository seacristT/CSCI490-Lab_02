package com.introandroid.feb5lab;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import  android.widget.ImageButton;
import android.widget.Toast;

public class backgroundActivity extends AppCompatActivity {


    private ImageView moon;
    private ImageView water;
    private  int imgID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);


        moon = findViewById(R.id.moon);
        water = findViewById(R.id.water);

        moon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "You selected the moon", Toast.LENGTH_SHORT).show();
                imgID = R.drawable.supermoon;
                finish();
            }
        });
        water.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected the waterfall", Toast.LENGTH_SHORT).show();
                imgID = R.drawable.waterfall;
                finish();

            }
        }));
    }

    @Override
    public void finish ()
    {
        Intent myIntent = new Intent ();
        myIntent.putExtra("imageID", imgID);

        setResult (RESULT_OK, myIntent);
        super.finish();
    }
}
