package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.Recipe;

public interface IRecipeDAO {
    Recipe save(Recipe recipe) throws Exception;
}
