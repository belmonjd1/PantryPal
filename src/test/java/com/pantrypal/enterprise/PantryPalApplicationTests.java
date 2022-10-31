package com.pantrypal.enterprise;

import com.pantrypal.enterprise.dto.Recipe;
import com.pantrypal.enterprise.service.IRecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PantryPalApplicationTests {

    @Autowired
    private IRecipeService recipeService;
    private Recipe recipe;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchRecipeById_returnsPizzaForId420() {
        givenRecipeDataAreAvailable();
        whenSearchRecipeWithId420();
        thenReturnOnePizzaRecipeForId420();
    }

    private void givenRecipeDataAreAvailable() {
    }

    private void whenSearchRecipeWithId420() {
        recipe = recipeService.fetchById(420);
    }

    private void thenReturnOnePizzaRecipeForId420() {
        String name = recipe.getName();
        assertEquals("Pizza", name);
    }

}
