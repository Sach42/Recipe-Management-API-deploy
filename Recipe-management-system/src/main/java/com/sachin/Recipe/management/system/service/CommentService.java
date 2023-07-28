package com.sachin.Recipe.management.system.service;

import com.sachin.Recipe.management.system.model.Comment;
import com.sachin.Recipe.management.system.model.Recipe;
import com.sachin.Recipe.management.system.repository.ICommentRepo;
import com.sachin.Recipe.management.system.repository.IRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final ICommentRepo commentRepository;
    private final IRecipeRepo recipeRepository;

    @Autowired
    public CommentService(ICommentRepo commentRepository, IRecipeRepo recipeRepository) {
        this.commentRepository = commentRepository;
        this.recipeRepository = recipeRepository;
    }

    public Comment addComment(Comment comment) {
        Recipe recipe = recipeRepository.findById(comment.getRecipe().getRecipeId()).orElse(null);
        if (recipe != null) {
            comment.setRecipe(recipe);
            return commentRepository.save(comment);
        } else {
            return null;
        }
    }

    public List<Comment> getCommentsForRecipe(Long recipeId) {
        return commentRepository.findByRecipeRecipeId(recipeId);
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (((Optional<?>) optionalComment).isPresent()) {
            Comment existingComment = optionalComment.get();
            existingComment.setCommentContent(updatedComment.getCommentContent());
            return commentRepository.save(existingComment);
        } else {
            return null;
        }
    }

    public boolean deleteComment(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
            return true;
        } else {
            return false;
        }
    }
}
