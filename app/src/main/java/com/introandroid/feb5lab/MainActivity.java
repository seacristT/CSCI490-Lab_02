package com.introandroid.feb5lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int MY_BACKGROUND_CODE = 1;
    public int RESPONSE_CODE = 1;
    private int REQUEST_CODE = 1;
    private ConstraintLayout constraintLayout;

    private Button setBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.mainLayout);
        setBackground = findViewById(R.id.setBackground);

        final Intent myIntent = new Intent (this, backgroundActivity.class);

        setBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(myIntent, MY_BACKGROUND_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == RESPONSE_CODE)
            {
                int imgID = data.getExtras().getInt("imgID");

                constraintLayout.setBackground(getDrawable(imgID));
            }
        }
    }
}
