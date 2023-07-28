package com.sachin.Recipe.management.system.controller;

import com.sachin.Recipe.management.system.model.Comment;
import com.sachin.Recipe.management.system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    // Endpoint to add a new comment to a recipe
    @PostMapping
    public ResponseEntity<Comment> addCommentToRecipe(@RequestBody Comment comment) {
        Comment addedComment = commentService.addComment(comment);
        return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
    }

    // Endpoint to get all comments for a specific recipe
    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Comment>> getCommentsForRecipe(@PathVariable Long recipeId) {
        List<Comment> comments = commentService.getCommentsForRecipe(recipeId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Endpoint to update a comment
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment updatedCommentResult = commentService.updateComment(commentId, updatedComment);
        if (updatedCommentResult != null) {
            return new ResponseEntity<>(updatedCommentResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        if (commentService.deleteComment(commentId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

