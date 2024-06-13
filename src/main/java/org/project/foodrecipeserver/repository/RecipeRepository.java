package org.project.foodrecipeserver.repository;

import org.project.foodrecipeserver.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  Recipe findByRecipeId(Long id);
}
