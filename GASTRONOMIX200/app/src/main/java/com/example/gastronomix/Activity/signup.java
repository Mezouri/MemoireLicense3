package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gastronomix.DataBase.DBHelper;
import com.example.gastronomix.R;

public class signup extends AppCompatActivity {
    private EditText Name, Phone, Password;
    private Button btnSignUp;
    private DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Name=findViewById(R.id.editTextText);
        Phone=findViewById(R.id.phone_number);
        Password=findViewById(R.id.editTextTextPassword2);
        btnSignUp=findViewById(R.id.buttondone);
        dbHelper = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().toUpperCase();
                String phone = Phone.getText().toString();
                String password = Password.getText().toString();

                if (name.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signup.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                }else if (!isValidPhone(phone)) {
                    Toast.makeText(signup.this, "phone number must contain exactly 10 digits", Toast.LENGTH_SHORT).show();
                }else if (!isValidPassword(password)) {
                    Toast.makeText(signup.this, "Password between 8 and 12 characters", Toast.LENGTH_SHORT).show();
                } else {
                    long result = dbHelper.addUser(name, phone, password);
                    if (result != -1) {
                        Toast.makeText(signup.this, "successful registration", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signup.this, CaloriesCalculateActivity.class);
                        intent.putExtra("COLUMN_NAME", name);
                        intent.putExtra("COLUMN_PHONE", phone);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(signup.this, "Failed to register", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 12;
    }

}