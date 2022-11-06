package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public class RecipeDAOStub implements IRecipeDAO {

    HashMap<Integer, Recipe> allRecipes = new HashMap<>();
    @Override
    public Recipe save(Recipe recipe) throws Exception {
        Integer recipeID = Integer.parseInt(String.valueOf(recipe.getRecipeId()));
        allRecipes.put(recipeID, recipe);
        return recipe;
    }

    @Override
    public List<Recipe> fetchAll() {
        List<Recipe> returnRecipes = new ArrayList(allRecipes.values());
        return returnRecipes;
    }

    @Override
    public Recipe fetch(int id) {
        return allRecipes.get(id);
    }

    @Override
    public void delete(int id) {
        allSpecimens.remove(id);

    }
}
