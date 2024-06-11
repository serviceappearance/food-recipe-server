package org.project.foodrecipeserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserRecipe {
  @Id
  @GeneratedValue
  private int id;
  private String recipeTitle;
  private String recipeImageLink;
  private String recipeIngredients;
  private String recipeSteps;
}
