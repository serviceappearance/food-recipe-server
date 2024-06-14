package org.project.foodrecipeserver.service;

import org.project.foodrecipeserver.dto.UserRecipeResponseDto;
import org.project.foodrecipeserver.entity.CustomRecipe;
import org.project.foodrecipeserver.entity.Recipe;
import org.project.foodrecipeserver.entity.UserRecipe;
import org.project.foodrecipeserver.repository.CustomRecipeRepository;
import org.project.foodrecipeserver.repository.RecipeRepository;
import org.project.foodrecipeserver.repository.UserRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserRecipeService {

  private final UserRecipeRepository userRecipeRepository;
  private final RecipeRepository recipeRepository;
  private final CustomRecipeRepository customRecipeRepository;

  @Autowired
  public UserRecipeService(UserRecipeRepository userRecipeRepository, RecipeRepository recipeRepository, CustomRecipeRepository customRecipeRepository) {
    this.userRecipeRepository = userRecipeRepository;
    this.recipeRepository = recipeRepository;
    this.customRecipeRepository = customRecipeRepository;
  }

  public List<UserRecipeResponseDto> getAllUserRecipes() {
    List<UserRecipe> all = userRecipeRepository.findAll();
    List<UserRecipeResponseDto> userRecipeResponseDtos = new ArrayList<>();
    for (UserRecipe userRecipe : all) {
      UserRecipeResponseDto userRecipeResponseDto = new UserRecipeResponseDto(
          userRecipe.getId(),
          userRecipe.getRecipe().getRecipeId(),
          userRecipe.getRecipe().getRecipeTitle(),
          userRecipe.getRecipe().getRecipeImageLink(),
          userRecipe.getRecipe().getRecipeIngredients(),
          userRecipe.getRecipe().getRecipeSteps()
      );
      userRecipeResponseDtos.add(userRecipeResponseDto);
    }
    return userRecipeResponseDtos;
  }


  public UserRecipeResponseDto getUserRecipeById(int id) {
    UserRecipe userRecipeById = userRecipeRepository.findById(id).get();
    return new UserRecipeResponseDto(
        userRecipeById.getId(),
        userRecipeById.getRecipe().getRecipeId(),
        userRecipeById.getRecipe().getRecipeTitle(),
        userRecipeById.getRecipe().getRecipeImageLink(),
        userRecipeById.getRecipe().getRecipeIngredients(),
        userRecipeById.getRecipe().getRecipeSteps()
    );
  }

  public int addUserRecipe(long recipeId) {
    Recipe recipe = recipeRepository.findByRecipeId(recipeId);
    UserRecipe userRecipe = new UserRecipe();
    CustomRecipe customRecipe = new CustomRecipe(
        0,
        recipe.getRecipeTitle(),
        recipe.getRecipeImageLink(),
        recipe.getRecipeIngredients(),
        recipe.getRecipeSteps()
    );
    userRecipe.setRecipe(recipe);
    int userRecipeId = userRecipeRepository.save(userRecipe).getId();
    customRecipeRepository.save(customRecipe);
    return userRecipeId;
  }

  public void deleteUserRecipe(int id) {
    userRecipeRepository.deleteById(id);
  }

}
