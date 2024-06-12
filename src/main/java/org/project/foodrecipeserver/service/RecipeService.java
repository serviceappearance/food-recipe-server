package org.project.foodrecipeserver.service;

import org.project.foodrecipeserver.dto.RecipeResponseDto;
import org.project.foodrecipeserver.entity.Recipe;
import org.project.foodrecipeserver.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RecipeRepository recipeRepository;

  public void fetchAndSaveRecipeData() {
    ResponseEntity<RecipeResponseDto> response = restTemplate.exchange(
        "http://openapi.foodsafetykorea.go.kr/api/f066be87d43a408e99bd/COOKRCP01/json/1/100",
        HttpMethod.GET,
        null,
        RecipeResponseDto.class);

    RecipeResponseDto recipeResponseDto = response.getBody();

    Recipe recipe = new Recipe();
    recipe.setRecipeId(recipeResponseDto.getRecipeId());
    recipe.setRecipeTitle(recipeResponseDto.getRCP_NM());
    recipe.setRecipeImageLink(recipeResponseDto.getATT_FILE_NO_MAIN());
    recipe.setRecipeIngredients(recipeResponseDto.getIngredients());
    recipe.setRecipeSteps(recipeResponseDto.getSteps());

    recipeRepository.save(recipe);
  }
}
