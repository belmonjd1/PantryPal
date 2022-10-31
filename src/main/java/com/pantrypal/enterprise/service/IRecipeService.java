package com.pantrypal.enterprise.service;

import com.pantrypal.enterprise.dto.Recipe;

public interface IRecipeService {
    Recipe fetchById(int id);

    Recipe save(Recipe recipe) throws Exception;
}