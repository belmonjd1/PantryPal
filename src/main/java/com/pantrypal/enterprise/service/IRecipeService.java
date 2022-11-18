package com.pantrypal.enterprise.service;

import com.pantrypal.enterprise.dto.FoundRecipe;
import com.pantrypal.enterprise.dto.Recipe;

import java.io.IOException;
import java.util.List;
public interface IRecipeService {
    Recipe fetchById(int id);

    void delete(int id) throws Exception;

    Recipe save(Recipe recipe) throws Exception;

    default List<Recipe> fetchAll() {
        return null;
    }

    FoundRecipe fetchRecipes(String recipeName) throws IOException;
}
