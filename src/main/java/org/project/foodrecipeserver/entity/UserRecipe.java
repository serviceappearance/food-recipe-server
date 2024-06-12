package org.project.foodrecipeserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.foodrecipeserver.converter.StringListConverter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRecipe {
  @Id
  @GeneratedValue
  private int id;
  private int recipeId;
  @Column(nullable = false, unique = true)
  private String recipeTitle;
  @Column(nullable = false)
  private String recipeImageLink;
  @Column(name = "ingredients", nullable = false,length = 1000)
  @Convert(converter = StringListConverter.class)
  private List<String> recipeIngredients;
  @Column(name = "steps", nullable = false,length = 1000)
  @Convert(converter = StringListConverter.class)
  private List<String> recipeSteps;
}
