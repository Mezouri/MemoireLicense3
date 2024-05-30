package com.example.gastronomix.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gastronomix.DataBase.ManagementCart;
import com.example.gastronomix.Domain.FoodDomain;
import com.example.gastronomix.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView title,price,description,number,calori;
    private ImageView plusBtn,minusBtn,picFood;
    private FoodDomain object;
    int nbr=1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }

    @SuppressLint("SetTextI18n")
    private void getBundle() {
        object= (FoodDomain) getIntent().getSerializableExtra("object");
        @SuppressLint("DiscouragedApi") int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        title.setText(object.getTitle());
        price.setText(object.getPrice()+"DA");
        description.setText(object.getDescription());
        calori.setText(object.getCalori());
        number.setText(String.valueOf(nbr));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbr=nbr+1;
                number.setText(String.valueOf(nbr));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nbr>1){
                    nbr=nbr-1;
                    number.setText(String.valueOf(nbr));
                }
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(nbr);
                managementCart.insertFood(object);
            }
        });

    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addcartbotn);
        title=findViewById(R.id.titletxt);
        price=findViewById(R.id.prixe);
        description=findViewById(R.id.description);
        calori=findViewById(R.id.calories);
        number=findViewById(R.id.txtView10);
        plusBtn=findViewById(R.id.plus);
        minusBtn=findViewById(R.id.minus);
        picFood=findViewById(R.id.imgfood);
    }
}