package org.project.foodrecipeserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomRecipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private long recipeId;
  @Column(nullable = false, unique = true)
  private String recipeTitle;
  @Column(nullable = false)
  private String recipeImageLink;
  @Column(name = "ingredients", nullable = false, length = 400)
  private String recipeIngredients;
  @Column(name = "steps", nullable = false,length = 400)
  private String recipeSteps;
}
