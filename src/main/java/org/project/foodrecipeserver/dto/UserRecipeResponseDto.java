package org.project.foodrecipeserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecipeResponseDto {
  private int id;
  @JsonProperty("RCP_NM")
  private String RCP_NM;
  @JsonProperty("ATT_FILE_NO_MAIN")
  private String ATT_FILE_NO_MAIN;
  private List<String> ingredients;
  private List<String> steps;
}