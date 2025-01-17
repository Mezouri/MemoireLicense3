package com.example.gastronomix.DataBase;

import android.content.Context;
import android.widget.Toast;

import com.example.gastronomix.Domain.FoodDomain;
import com.example.gastronomix.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private final Context context;
    private final TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i=0;i<listFood.size();i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if (existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }
        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("cartList");
    }
    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }
    public void minusNumberFood(ArrayList<FoodDomain> listfood , int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listfood.get(position).getNumberInCart()==1){
            listfood.remove(position);
        }else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }
    public Double getTotalPrice(){
        ArrayList<FoodDomain> listfood=getListCart();
        double price=0;
        for (int i=0;i<listfood.size();i++){
            price=price+(listfood.get(i).getPrice() * listfood.get(i).getNumberInCart());
        }
        return price;
    }

}
