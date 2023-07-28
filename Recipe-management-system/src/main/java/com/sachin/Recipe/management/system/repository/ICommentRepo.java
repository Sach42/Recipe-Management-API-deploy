package com.sachin.Recipe.management.system.repository;

import com.sachin.Recipe.management.system.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipeRecipeId(Long recipeId);
}
