package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gastronomix.R;

public class CaloriesCalculateActivity extends AppCompatActivity {
    private AutoCompleteTextView activities;
    private EditText weightInput, heightInput, ageInput;
    private Button calculateButton;
    private TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_calculate);
        activities=findViewById(R.id.activ10);
        weightInput = findViewById(R.id.weight);
        heightInput = findViewById(R.id.height);
        ageInput = findViewById(R.id.ageText);
        calculateButton = findViewById(R.id.calculbtn);
        resultText = findViewById(R.id.resultat);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activities_items, android.R.layout.simple_dropdown_item_1line);
        activities.setAdapter(adapter);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });
    }
    public void continu(View view) {
        startActivity(new Intent(CaloriesCalculateActivity.this, MainActivity.class));
    }

    private void calculateCalories() {
        String weightStr =weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();
        String ageStr = ageInput.getText().toString();
        String activityLevel = activities.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty() || ageStr.isEmpty() || activityLevel.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);
        int age = Integer.parseInt(ageStr);
        double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        double Calories = 1;
        switch (activityLevel) {
            case "Lightly active":
                Calories = BMR*1.375;
                break;
            case "Moderately active":
                Calories = BMR * 1.55;
                break;
            case "Active":
                Calories = BMR * 1.725;
                break;
            case "Very active":
                Calories = BMR *1.9;
                break;
        }
        @SuppressLint("DefaultLocale") String calorieMessage = "Your daily calories needed are: " + String.format("%.2f", Calories) + " Kcal .";
        resultText.setText(calorieMessage);
    }

}

