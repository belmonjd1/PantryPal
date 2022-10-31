package com.pantrypal.enterprise.service;

import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeServiceStub implements IRecipeService {
    @Override
    public Recipe fetchById(int id) {
        Recipe recipe = new Recipe();
        recipe.setName("Pizza");
        recipe.setRecipeId(420);
        return recipe;
    }
}
