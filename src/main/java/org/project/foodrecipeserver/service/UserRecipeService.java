package org.project.foodrecipeserver.service;

import org.project.foodrecipeserver.entity.UserRecipe;
import org.project.foodrecipeserver.repository.UserRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRecipeService {

  private UserRecipeRepository userRecipeRepository;

  @Autowired
  public UserRecipeService(UserRecipeRepository userRecipeRepository) {
    this.userRecipeRepository = userRecipeRepository;
  }

  public List<UserRecipe> getAllUserRecipes() {
    return userRecipeRepository.findAll();
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
