package com.pantrypal.enterprise.dto;

import lombok.Data;
import java.util.ArrayList;

public @Data class Ingredient {
    private int ingredientId;
    private ArrayList<String> recipeList;
    private ArrayList<String> allergens;
    private String description;
    private double price;
}
