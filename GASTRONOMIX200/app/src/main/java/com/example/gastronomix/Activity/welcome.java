package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gastronomix.R;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public void start(View view) {
        startActivity(new Intent(welcome.this, signup.class));
    }

    public void signin(View view) {
        startActivity(new Intent(welcome.this, signin.class));
    }
}