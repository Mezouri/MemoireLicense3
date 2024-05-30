package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gastronomix.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText etName, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);

        Button btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = etName.getText().toString();
                String newPhone = etPhone.getText().toString();

                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                intent.putExtra("COLUMN_NAME", newName);
                intent.putExtra("COLUMN_PHONE", newPhone);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}