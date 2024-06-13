package org.project.foodrecipeserver.repository;

import org.project.foodrecipeserver.dto.UserRecipeResponseDto;
import org.project.foodrecipeserver.entity.UserRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRecipeRepository extends JpaRepository<UserRecipe,Integer> {
}
