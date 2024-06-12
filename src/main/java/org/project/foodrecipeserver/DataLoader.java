package org.project.foodrecipeserver;

import org.project.foodrecipeserver.repository.RecipeRepository;
import org.project.foodrecipeserver.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private RecipeRepository recipeRepository;
  @Autowired
  private RecipeService recipeService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    recipeService.fetchAndSaveRecipeData();
  }
}
