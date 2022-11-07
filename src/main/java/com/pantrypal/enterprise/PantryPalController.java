package com.pantrypal.enterprise;



import com.pantrypal.enterprise.dto.Recipe;
import com.pantrypal.enterprise.service.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PantryPalController {

    @Autowired
    IRecipeService recipeService;

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(24);
        recipe.setName("Grilled Cheese");
        recipe.setDescription("Cooking steps");
        model.addAttribute(recipe);
        return "start";
    }

    @RequestMapping("/saveRecipe")
    public String saveRecipe(Recipe recipe) {
        try {
            recipeService.save(recipe);
        } catch (Exception e) {
            e.printStackTrace();
            return "start";
        }
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
        try {
            newRecipe = recipeService.save(recipe);
        } catch (Exception e) {
            // TODO add logging
        }
        return newRecipe;
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

    @GetMapping("/recipes")
    public ResponseEntity searchRecipes(@RequestParam(value="searchTerm", required=false, defaultValue="None") String searchTerm) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
