package com.sachin.Recipe.management.system.repository;

import com.sachin.Recipe.management.system.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepo extends JpaRepository<Recipe, Long> {
}
