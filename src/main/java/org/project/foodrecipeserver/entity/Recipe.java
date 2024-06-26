package org.project.foodrecipeserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.project.foodrecipeserver.converter.StringListConverter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
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
