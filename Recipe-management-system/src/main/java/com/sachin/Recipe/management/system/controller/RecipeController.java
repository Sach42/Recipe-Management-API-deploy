package com.sachin.Recipe.management.system.controller;

import com.sachin.Recipe.management.system.model.Comment;
import com.sachin.Recipe.management.system.model.Recipe;
import com.sachin.Recipe.management.system.service.CommentService;
import com.sachin.Recipe.management.system.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    CommentService commentService;

    // Endpoints to handle CRUD operations for recipes

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(id, recipe);
        if (updatedRecipe != null) {
            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        if (recipeService.deleteRecipe(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoints to handle comments

    @PostMapping("/comments")
    public ResponseEntity<Comment> addCommentToRecipe(@RequestBody Comment comment) {
        Comment addedComment = commentService.addComment(comment);
        if (addedComment != null) {
            return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comments/{recipeId}")
    public ResponseEntity<List<Comment>> getCommentsForRecipe(@PathVariable Long recipeId) {
        List<Comment> comments = commentService.getCommentsForRecipe(recipeId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
