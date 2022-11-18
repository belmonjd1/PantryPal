package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.FoundRecipe;

import java.io.IOException;
import java.util.List;

public interface IFoundRecipeDAO {

    FoundRecipe fetchRecipes(String recipeName) throws IOException;
}