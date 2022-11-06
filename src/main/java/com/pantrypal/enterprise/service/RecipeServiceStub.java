package com.pantrypal.enterprise.service;

import com.pantrypal.enterprise.dao.IRecipeDAO;
import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceStub implements IRecipeService {

    @Autowired
    private IRecipeDAO recipeDAO;

    public RecipeServiceStub() {}

    public RecipeServiceStub(IRecipeDAO recipeDAO) { this.recipeDAO = recipeDAO; }

    @Override
    public Recipe fetchById(int id) {
        Recipe foundRecipe = recipeDAO.fetch(id);
        return recipe;
    }

    @Override
    public void delete(int id) throws Exception {
        recipeDAO.delete(id);
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
