package com.pantrypal.enterprise;



import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PantryPalController {

    @Autowired
    iRecipeService recipeService;
    private Model model;

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        this.model = model;
        Recipe recipe = new Recipe();
        recipe.setDescription("Recipes on a budget");
        recipe.setRecipeId(Integer.parseInt("1000"));
        recipe.setRecipeId(84);
        model.addAttribute(recipe);
        return "start";
    }

    @GetMapping("/recipe")
    @ResponseBody
    public List<Recipe> fetchAllRecipes() {
        return recipeService.fetchAll();
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity fetchRecipeById(@PathVariable("id") String id) {
        Recipe foundRecipe = recipeService.fetchById(Integer.parseInt(id));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundRecipe, headers, HttpStatus.OK);
    }

    @PostMapping(value="/recipe", consumes="application/json", produces="application/json")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = null;
        {
        }
        try {
            recipeService.save(recipe);
        } catch (Exception e) {
            // TODO add logging
        }
        return recipe;
    }

    @DeleteMapping("/recipe/{id}/")
    public ResponseEntity deleteRecipe(@PathVariable("id") String id) {
        try {
            recipeService.delete(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
