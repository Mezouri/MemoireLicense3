package com.example.gastronomix.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private String calori;
    private double price;
    private int numberInCart;

    public FoodDomain(String title, String pic, String description, String calori , double price, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.calori=calori;
        this.price = price;
        this.numberInCart = numberInCart;
    }

    public FoodDomain(String title, String pic, String description,String calori, double price ) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.calori=calori;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCalori() {
        return calori;
    }

    public void setCalori(String calori) {
        this.calori = calori;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }


}
