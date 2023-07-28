package com.sachin.Recipe.management.system.service;

import com.sachin.Recipe.management.system.model.Recipe;
import com.sachin.Recipe.management.system.repository.IRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
   @Autowired
   IRecipeRepo recipeRepo;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepo.findById(id).orElse(null);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Optional<Recipe> optionalRecipe = recipeRepo.findById(id);

        if (optionalRecipe.isPresent()) {
            Recipe existingRecipe = optionalRecipe.get();
            existingRecipe.setRecipeName(updatedRecipe.getRecipeName());
            existingRecipe.setRecipeIngredients(updatedRecipe.getRecipeIngredients());
            existingRecipe.setRecipeInstructions(updatedRecipe.getRecipeInstructions());
            return recipeRepo.save(existingRecipe);
        } else {
            return null;
        }
    }

    public boolean deleteRecipe(Long id) {
        if (recipeRepo.existsById(id)) {
            recipeRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
