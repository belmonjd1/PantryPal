package com.pantrypal.enterprise.service;

import com.pantrypal.enterprise.dao.IRecipeDAO;
import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceStub implements IRecipeService {

    @Autowired
    private IRecipeDAO recipeDAO;

    public RecipeServiceStub() {}

    public RecipeServiceStub(IRecipeDAO recipeDAO) { this.recipeDAO = recipeDAO; }

    @Override
    public Recipe fetchById(int id) {
        Recipe recipe = new Recipe();
        recipe.setName("Pizza");
        recipe.setRecipeId(420);
        return recipe;
    }

    @Override
    public Recipe save(Recipe recipe) throws Exception {
        return recipeDAO.save(recipe);
    }

    @Override
    public List<Recipe> fetchAll() {
        return recipeDAO.fetchAll();
    }
}
