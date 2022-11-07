package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class RecipeDAOStub implements IRecipeDAO {

    HashMap<Integer, Recipe> allRecipes = new HashMap<>();

    @Override
    public Recipe save(Recipe recipe) {
        Integer recipeID = Integer.parseInt(String.valueOf(recipe.getRecipeId()));
        allRecipes.put(recipeID, recipe);
        return recipe;
    }

    @Override
    public List<Recipe> fetchAll() { return new ArrayList(allRecipes.values()); }

    @Override
    public Recipe fetch(int id) {
        return allRecipes.get(id);
    }

    @Override
    public void delete(int id) {
        allRecipes.remove(id);
    }

}
