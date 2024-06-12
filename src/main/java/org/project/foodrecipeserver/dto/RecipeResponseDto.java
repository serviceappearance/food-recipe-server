package org.project.foodrecipeserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.foodrecipeserver.converter.StringListConverter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponseDto {
  @JsonProperty("recipe_id")
  private long recipeId;
  @JsonProperty("RCP_NM")
  private String RCP_NM;
  @JsonProperty("ATT_FILE_NO_MAIN")
  private String ATT_FILE_NO_MAIN;
  private List<String> ingredients;
  private List<String> steps;
}
