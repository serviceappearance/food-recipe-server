package org.project.foodrecipeserver.repository;

import org.project.foodrecipeserver.entity.UserRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecipeRepository extends JpaRepository<UserRecipe,Integer> {
}
