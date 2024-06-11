package org.project.foodrecipeserver.controller;

import lombok.RequiredArgsConstructor;
import org.project.foodrecipeserver.entity.UserRecipe;
import org.project.foodrecipeserver.service.UserRecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-recipe")
@RequiredArgsConstructor
public class UserRecipeController {
  private final UserRecipeService userRecipeService;

  @GetMapping
  public List<UserRecipe> getAllUserRecipe() {
    return userRecipeService.getAllUserRecipes();
  }

  @GetMapping("/{recipeId}")
  public UserRecipe getUserRecipe(@PathVariable("recipeId") int recipeId) {
    return userRecipeService.getUserRecipeById(recipeId);
  }

  @PostMapping
  public UserRecipe addUserRecipe(@RequestBody UserRecipe userRecipe) {
    int userRecipeId = userRecipeService.addUserRecipe(userRecipe);
    UserRecipe userRecipeById = userRecipeService.getUserRecipeById(userRecipeId);
    return userRecipeById;
  }

  @DeleteMapping("/{recipeId}")
  public void deleteUserRecipe(@PathVariable("recipeId") int recipeId) {
    userRecipeService.deleteUserRecipe(recipeId);
  }

}
