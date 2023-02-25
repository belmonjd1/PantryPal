package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.FoundRecipe;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IFoundRecipeRetrofitDAO {

    @GET("/api/json/v1/1/search.php")
    Call<FoundRecipe> getRecipes(@Query("s") String recipeName);
}
