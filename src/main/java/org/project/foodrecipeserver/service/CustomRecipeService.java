package org.project.foodrecipeserver.service;

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
  @Autowired
  private UserRecipeRepository userRecipeRepository;
  @Autowired
  private UserRecipeService userRecipeService;

  // 레시피 페이지에서 수정버튼을 눌렀을 때 화면 내용
  public CustomRecipeResponseDto getCustomRecipeById(int id) {
    UserRecipeResponseDto userRecipeById = userRecipeService.getUserRecipeById(id);
    return new CustomRecipeResponseDto(
        (int) userRecipeById.getRecipeId(),
        userRecipeById.getRCP_NM(),
        userRecipeById.getATT_FILE_NO_MAIN(),
        userRecipeById.getIngredients(),
        userRecipeById.getSteps()
    );
  }

  // 수정완료 버튼을 눌렀을 때 동작
  public int addOrUpdateCustomRecipe(CustomRecipe customRecipe) {
    int id = customRecipeRepository.save(customRecipe).getId();
    return id;
  }

}
