package com.pantrypal.enterprise;

import com.pantrypal.enterprise.dto.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PantryPalController {

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/recipe")
    public ResponseEntity fetchAllRecipes() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity fetchRecipeById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/recipe", consumes="application/json", produces="application/json")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipe;
    }

    @DeleteMapping("/recipe/{id}/")
    public ResponseEntity deleteRecipe(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
