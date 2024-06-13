package org.project.foodrecipeserver.dataLoad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.foodrecipeserver.dto.RecipeResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeApiResponse {
  @JsonProperty("COOKRCP01")
  private RecipeData recipeData;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class RecipeData {
    @JsonProperty("row")
    private List<RecipeResponseDto> recipes;
  }
}
