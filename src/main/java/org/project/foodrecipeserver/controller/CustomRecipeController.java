package org.project.foodrecipeserver.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.foodrecipeserver.dto.CustomRecipeRequestDto;
import org.project.foodrecipeserver.dto.CustomRecipeResponseDto;
import org.project.foodrecipeserver.entity.CustomRecipe;
import org.project.foodrecipeserver.service.CustomRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/custom-recipe")
@RequiredArgsConstructor
public class CustomRecipeController {

  @Autowired
  private CustomRecipeService customRecipeService;

  @GetMapping("/{custom-recipe-id}")
  public CustomRecipeResponseDto getCustomRecipe(@PathVariable("custom-recipe-id") int customRecipeId){
    return customRecipeService.getCustomRecipeById(customRecipeId);
  }

  @PostMapping
  public void addCustomRecipe(@Valid @RequestBody CustomRecipe customRecipe){
    customRecipeService.addCustomRecipe(customRecipe);
  }

}
