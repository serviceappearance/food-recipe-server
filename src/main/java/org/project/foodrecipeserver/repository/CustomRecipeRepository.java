package org.project.foodrecipeserver.repository;

import org.project.foodrecipeserver.entity.CustomRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRecipeRepository extends JpaRepository<CustomRecipe, Integer> {
}
