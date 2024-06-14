package org.project.foodrecipeserver.service;

import org.project.foodrecipeserver.dto.CustomRecipeRequestDto;
import org.project.foodrecipeserver.dto.CustomRecipeResponseDto;
import org.project.foodrecipeserver.dto.UserRecipeResponseDto;
import org.project.foodrecipeserver.entity.CustomRecipe;
import org.project.foodrecipeserver.repository.CustomRecipeRepository;
import org.project.foodrecipeserver.repository.UserRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomRecipeService {

  @Autowired
  private CustomRecipeRepository customRecipeRepository;

  // 레시피 페이지에서 수정버튼을 눌렀을 때 화면 내용
  public CustomRecipeResponseDto getCustomRecipeById(int id) {
    CustomRecipe customRecipeById = customRecipeRepository.findById(id).get();
    return new CustomRecipeResponseDto(
        customRecipeById.getId(),
        customRecipeById.getRecipeTitle(),
        customRecipeById.getRecipeImageLink(),
        customRecipeById.getRecipeIngredients(),
        customRecipeById.getRecipeSteps()
    );
  }

  // 수정완료 버튼을 눌렀을 때 동작
  public int addCustomRecipe(CustomRecipe customRecipe) {
    int id = customRecipeRepository.save(customRecipe).getId();
    return id;
  }

}
