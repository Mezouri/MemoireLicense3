package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gastronomix.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvPhone = findViewById(R.id.tv_phone);

        String userName = getIntent().getStringExtra("USER_NAME");
        String userPhone = getIntent().getStringExtra("USER_PHONE");

        tvName.setText("Nom: " + userName);
        tvPhone.setText("Téléphone: " + userPhone);
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton);
        LinearLayout homebtn=findViewById(R.id.homebtn);
        LinearLayout profilebtn=findViewById(R.id.homebtn1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,CartListActivity.class));
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });
    }
    public void edit(View view) {
        startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
    }
}