package org.project.foodrecipeserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecipeRequestDto {
  @NotBlank(message = "서버에서 recipe id 값을 받지 못했습니다.")
  private long recipeId;
}
