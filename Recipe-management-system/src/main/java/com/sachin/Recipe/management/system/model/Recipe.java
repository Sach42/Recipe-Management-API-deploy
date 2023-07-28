package com.sachin.Recipe.management.system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @NotBlank(message = "Recipe name is required")
    private String recipeName;

    @NotBlank(message = "Ingredients are required")
    private String recipeIngredients;

    @NotBlank(message = "Instructions are required")
    private String recipeInstructions;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
