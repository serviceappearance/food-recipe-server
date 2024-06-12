package org.project.foodrecipeserver.controller;

import lombok.RequiredArgsConstructor;
import org.project.foodrecipeserver.dto.UserRecipeResponseDto;
import org.project.foodrecipeserver.entity.UserRecipe;
import org.project.foodrecipeserver.service.UserRecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-recipe")
@RequiredArgsConstructor
public class UserRecipeController {
  private final UserRecipeService userRecipeService;

  public List<UserRecipe> getAllUserRecipe() {
    return userRecipeService.getAllUserRecipes();
  }

  @GetMapping
  public List<UserRecipeResponseDto> getAllUserRecipeDto() {
    return userRecipeService.getAllUserRecipeDto();
  }


  @GetMapping("/{recipeId}")
  public UserRecipeResponseDto getUserRecipe(@PathVariable("recipeId") int recipeId) {
    return userRecipeService.getUserRecipeById(recipeId);
  }

  @PostMapping
  public UserRecipeResponseDto addUserRecipe(@RequestBody UserRecipe userRecipe) {
    int userRecipeId = userRecipeService.addUserRecipe(userRecipe);
    UserRecipeResponseDto userRecipeById = userRecipeService.getUserRecipeById(userRecipeId);
    return userRecipeById;
  }

  @DeleteMapping("/{recipeId}")
  public void deleteUserRecipe(@PathVariable("recipeId") int recipeId) {
    userRecipeService.deleteUserRecipe(recipeId);
  }

}
