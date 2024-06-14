package org.project.foodrecipeserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomRecipeResponseDto {
  private int Id;
  @JsonProperty("RCP_NM")
  private String recipeTitle;
  @JsonProperty("ATT_FILE_NO_MAIN")
  private String recipeImageLink;
  private String recipeIngredients;
  private String recipeSteps;
}
