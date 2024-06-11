package org.project.foodrecipeserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.project.foodrecipeserver.converter.StringListConverter;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
  @Id
  private int id;
  @Column(nullable = false, unique = true)
  private String recipeTitle;
  @Column(nullable = false)
  private String recipeImageLink;
  @Column(name = "ingredients", nullable = false)
  @Convert(converter = StringListConverter.class)
  private List<String> recipeIngredients;
  @Column(name = "steps", nullable = false,length = 400)
  @Convert(converter = StringListConverter.class)
  private List<String> recipeSteps;

  public void setId(int id) {
    this.id = id;
  }

  public void setRecipeSteps(List<String> recipeSteps) {
    this.recipeSteps = recipeSteps;
  }

  public void setRecipeIngredients(List<String> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }

  public void setRecipeImageLink(String recipeImageLink) {
    this.recipeImageLink = recipeImageLink;
  }

  public void setRecipeTitle(String recipeTitle) {
    this.recipeTitle = recipeTitle;
  }

}

