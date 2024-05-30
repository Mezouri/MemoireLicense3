package com.example.gastronomix.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gastronomix.Adaptor.CartListAdaptor;
import com.example.gastronomix.DataBase.ManagementCart;
import com.example.gastronomix.Domain.FoodDomain;
import com.example.gastronomix.Interface.ChangeNumberItemsListener;
import com.example.gastronomix.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private ManagementCart managementCart;
    TextView totalitem,tax,delivry,total,empty;
    private RecyclerView recyclerViewList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        managementCart=new ManagementCart(this);
        initView();
        initList();
        CalculataCart();
        bottomNavigation();

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton);
        LinearLayout homebtn=findViewById(R.id.homebtn);
        LinearLayout profilebtn=findViewById(R.id.homebtn1);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,ProfileActivity.class));
            }
        });
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recview226);
        totalitem=findViewById(R.id.pricetx);
        tax=findViewById(R.id.textView161);
        delivry=findViewById(R.id.textView16000);
        total=findViewById(R.id.textView1640);
        empty=findViewById(R.id.emptytxt);
        ScrollView scrollView = findViewById(R.id.scrollView3);

    }
   private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> cartList=managementCart.getListCart();
        adapter=new CartListAdaptor(cartList,this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculataCart();
            }
        });

    }
    @SuppressLint("SetTextI18n")
    public void CalculataCart(){
        double percentTax=0.02;
        double delivryb=100;
        double totalPrice = managementCart.getTotalPrice();
        double taxs=Math.round(totalPrice * percentTax * 100) / 100.0;
        double totale= (double) (Math.round(managementCart.getTotalPrice() + taxs + delivryb) * 100) /100;
        double itemtotal= (double) Math.round(managementCart.getTotalPrice() * 100) /100;
        totalitem.setText(itemtotal+"DA");
        tax.setText(taxs+"DA");
        total.setText(totale+"DA");
        delivry.setText(delivryb+"DA");

    }

}