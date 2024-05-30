package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gastronomix.Adaptor.CategoryAdaptor;
import com.example.gastronomix.Adaptor.PopularAdaptor;
import com.example.gastronomix.Domain.CategoryDomain;
import com.example.gastronomix.Domain.FoodDomain;
import com.example.gastronomix.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList , recyclerViewPopularList;
    private TextView tvWelcomeMessage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
        tvWelcomeMessage = findViewById(R.id.textView5);

        String userName = getIntent().getStringExtra("COLUMN_NAME");
        tvWelcomeMessage.setText("HI " + userName);

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton);
        LinearLayout homebtn=findViewById(R.id.homebtn);
        LinearLayout profilebtn=findViewById(R.id.homebtn1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recv1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Breakfast","breakfas"));
        category.add(new CategoryDomain("Dinner","dinner"));
        category.add(new CategoryDomain("Lunch","lunch"));
        category.add(new CategoryDomain("Drinks","Drinks"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);

     }
     private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recv2);
         recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
         foodList.add(new FoodDomain("Coffee","cof"," Description : Black coffee"," Calories : 30 kcal",Double.parseDouble("100")));
         foodList.add(new FoodDomain("Breakfast","breakfas"," Description : Eggs , Wholemeal bread "," Calories : 230 kcal",Double.parseDouble("150")));
         foodList.add(new FoodDomain("Dinner","chicken_meal"," Description : Chicken breast , Potatoes , Tomatoes , Salade "," Calories : 400 kcal" ,Double.parseDouble("350")));
         foodList.add(new FoodDomain("Orange juice","orange"," Description : Orange , lemon"," Calories : 130 kcal",Double.parseDouble("250")));
         foodList.add(new FoodDomain("Lunch","fish_meal"," Description : Fish , Cheese , Spinsch , Cucumber , Olive"," Calories : 360 kcal", Double.parseDouble("400")));
         adapter2=new PopularAdaptor(foodList);
         recyclerViewPopularList.setAdapter(adapter2);
    }
}