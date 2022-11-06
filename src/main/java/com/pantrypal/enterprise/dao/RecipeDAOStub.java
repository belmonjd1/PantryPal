package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RecipeDAOStub implements IRecipeDAO {

    List<Recipe> allRecipes = new ArrayList<Recipe>();
    @Override
    public Recipe save(Recipe recipe) {
        allRecipes.add(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> fetchAll() {
        return allRecipes;
    }
}
