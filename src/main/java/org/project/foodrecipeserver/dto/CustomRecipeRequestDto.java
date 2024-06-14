package org.project.foodrecipeserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.foodrecipeserver.converter.StringListConverter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomRecipeRequestDto {
  private int Id;
  @JsonProperty("RCP_NM")
  private String RCP_NM;
  @JsonProperty("ATT_FILE_NO_MAIN")
  private String ATT_FILE_NO_MAIN;
  @Convert(converter = StringListConverter.class)
  private List<String> ingredients;
  @Convert(converter = StringListConverter.class)
  private List<String> steps;
}
