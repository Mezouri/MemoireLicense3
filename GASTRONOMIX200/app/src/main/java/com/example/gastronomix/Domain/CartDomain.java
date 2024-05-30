package com.example.gastronomix.Domain;

public class CartDomain {
    private int id;
    private String mealName;
    private double mealPrice;
    private int quantity;

    public CartDomain(String mealName, double mealPrice, int quantity) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMealName() { return mealName; }
    public void setMealName(String mealName) { this.mealName = mealName; }
    public double getMealPrice() { return mealPrice; }
    public void setMealPrice(double mealPrice) { this.mealPrice = mealPrice; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

