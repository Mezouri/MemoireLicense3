package com.example.gastronomix.Interface;

import com.example.gastronomix.Domain.FoodDomain;

import java.util.ArrayList;

public interface UpdateCategoryRec {
    public void callBack(int position, ArrayList<FoodDomain> foodDomains);
}
