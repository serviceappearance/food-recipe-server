package org.project.foodrecipeserver.service;

import org.project.foodrecipeserver.dto.UserRecipeResponseDto;
import org.project.foodrecipeserver.entity.UserRecipe;
import org.project.foodrecipeserver.repository.UserRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRecipeService {

  private final UserRecipeRepository userRecipeRepository;

  @Autowired
  public UserRecipeService(UserRecipeRepository userRecipeRepository) {
    this.userRecipeRepository = userRecipeRepository;
  }

  public List<UserRecipe> getAllUserRecipes() {
    return userRecipeRepository.findAll();
  }

  public List<UserRecipeResponseDto> getAllUserRecipeDto() {
    return userRecipeRepository.findAll().stream()
        .map(recipe -> new UserRecipeResponseDto(
            recipe.getId(),
            recipe.getRecipeTitle(),
            recipe.getRecipeImageLink(),
            recipe.getRecipeIngredients(),
            recipe.getRecipeSteps()
        ))
        .collect(Collectors.toList());
  }


  public UserRecipe getUserRecipeById(int id) {
    return userRecipeRepository.findById(id).get();
  }

  public int addUserRecipe(UserRecipe userRecipe) {
    return userRecipeRepository.save(userRecipe).getId();
  }

  public void deleteUserRecipe(int id) {
    userRecipeRepository.deleteById(id);
  }

}
