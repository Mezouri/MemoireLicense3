package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gastronomix.DataBase.DBHelper;
import com.example.gastronomix.R;

public class signin extends AppCompatActivity {
    private EditText etPhone, etPassword;
    private DBHelper dbHelper;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

            etPhone = findViewById(R.id.phone);
            etPassword = findViewById(R.id.editTextTextPassword2);
        Button btnSignIn = findViewById(R.id.button6);

            dbHelper = new DBHelper(this);

            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone = etPhone.getText().toString();
                    String password = etPassword.getText().toString();

                    if (phone.isEmpty() || password.isEmpty()) {
                        Toast.makeText(signin.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    } else if (!isValidPhone(phone)) {
                        Toast.makeText(signin.this, "phone number must contain exactly 10 digits", Toast.LENGTH_SHORT).show();
                    } else {
                        if (checkUser(phone, password)) {
                            Toast.makeText(signin.this, "successful login", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(signin.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(signin.this, "Failed login", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        private boolean isValidPhone(String phone) {
            return phone.matches("\\d{10}");
        }

        private boolean checkUser(String phone, String password) {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String[] columns = { "id" };
            String selection = "phone=? AND password=?";
            String[] selectionArgs = { phone, password };
            Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
            int cursorCount = cursor.getCount();
            cursor.close();
            db.close();
            return cursorCount > 0;
        }


    }
