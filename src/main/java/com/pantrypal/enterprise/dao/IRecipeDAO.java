package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.Recipe;

import java.util.List;

public interface IRecipeDAO {
    Recipe save(Recipe recipe) throws Exception;

    List<Recipe> fetchAll();
}
