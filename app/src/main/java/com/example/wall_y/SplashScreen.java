package com.example.wall_y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button inainte = findViewById(R.id.continua);
        inainte.setOnClickListener(
                v -> startActivity(new Intent(SplashScreen.this, MainActivity.class))
        );
    }
}