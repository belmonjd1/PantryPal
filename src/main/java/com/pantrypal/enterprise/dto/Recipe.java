package com.pantrypal.enterprise.dto;

import lombok.Data;
import java.util.ArrayList;

public @Data class Recipe {
    private int recipeId;
    private ArrayList<String> ingredientList;
    private String description;
}
