package org.project.foodrecipeserver.controller;

import lombok.RequiredArgsConstructor;
import org.project.foodrecipeserver.dto.UserRecipeRequestDto;
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

  @GetMapping
  public List<UserRecipeResponseDto> getAllUserRecipe() {
    return userRecipeService.getAllUserRecipes();
  }

  @GetMapping("/{id}")
  public UserRecipeResponseDto getUserRecipe(@PathVariable("id") int id) {
    return userRecipeService.getUserRecipeById(id);
  }

  @PostMapping
  public void addUserRecipe(@RequestBody UserRecipeRequestDto userRecipeRequestDto) {
    userRecipeService.addUserRecipe(userRecipeRequestDto.getId());
  }

  @DeleteMapping
  public void deleteUserRecipe(@RequestBody UserRecipeRequestDto userRecipeRequestDto) {
    userRecipeService.deleteUserRecipe((int) userRecipeRequestDto.getId());
  }

}
