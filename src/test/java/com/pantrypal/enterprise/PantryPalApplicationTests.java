package com.pantrypal.enterprise;

import com.pantrypal.enterprise.dao.IRecipeDAO;
import com.pantrypal.enterprise.dto.Recipe;
import com.pantrypal.enterprise.service.IRecipeService;
import com.pantrypal.enterprise.service.RecipeServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PantryPalApplicationTests {

    private IRecipeService recipeService;
    private Recipe recipe = new Recipe();

    @MockBean
    private IRecipeDAO recipeDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchRecipeById_returnsPizzaForId420() throws Exception {
        givenRecipeDataAreAvailable();
        whenRecipe420AddedIsPizza();
        whenSearchRecipeWithId420();
        thenReturnOnePizzaRecipeForId420();
    }

    private void whenRecipe420AddedIsPizza() {
        Recipe pizza = new Recipe();
        pizza.setRecipeID("420");
        pizza.setDescription("Pizza");
        Mockito.when(recipeDAO.fetch(id: 420)).thenReturn(pizza);
    }

    private void thenReturn(Recipe pizza) {

    }

    private void givenRecipeDataAreAvailable() throws Exception {
        Mockito.when(recipeDAO.save(recipe)).thenReturn(recipe);
        recipeService = new RecipeServiceStub(recipeDAO);
    }

    private void whenSearchRecipeWithId420() { recipe = recipeService.fetchById(420); }

    private void thenReturnOnePizzaRecipeForId420() {
        String name = recipe.getName();
        assertEquals("Pizza", name);
    }

    @Test
    void saveRecipe_validateReturnRecipeWithNameAndId() throws Exception {
        givenRecipeDataAreAvailable();
        whenUserCreatesANewRecipeAndSaves();
        thenCreateNewRecipeRecordAndReturnIt();
    }

    private void whenUserCreatesANewRecipeAndSaves() {
        recipe.setName("Chicken Wings");
        recipe.setRecipeId(27);
    }

    private void thenCreateNewRecipeRecordAndReturnIt() throws Exception {
        Recipe createdRecipe = recipeService.save(recipe);
        assertEquals(recipe, createdRecipe);
        verify(recipeDAO, atLeastOnce()).save(recipe);
    }
}
