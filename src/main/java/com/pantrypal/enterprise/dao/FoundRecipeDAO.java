package com.pantrypal.enterprise.dao;

import com.pantrypal.enterprise.dto.FoundRecipe;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Repository
public class FoundRecipeDAO implements IFoundRecipeDAO {
    @Override
    public FoundRecipe fetchRecipes(String recipeName) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IFoundRecipeRetrofitDAO foundRecipeRetrofitDAO = retrofitInstance.create(IFoundRecipeRetrofitDAO.class);
        Call<FoundRecipe> allRecipes = foundRecipeRetrofitDAO.getRecipes(recipeName);
        Response<FoundRecipe> execute = allRecipes.execute();
        return execute.body();
    }
}
