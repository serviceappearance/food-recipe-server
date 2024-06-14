package org.project.foodrecipeserver.dataLoad;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.foodrecipeserver.entity.Recipe;
import org.project.foodrecipeserver.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataFetcher {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RecipeRepository recipeRepository;

  @Value("${my.api.key}")
  private String apiKey;

  public void fetchAndSaveRecipeData() {
    ResponseEntity<String> response = restTemplate.exchange(
        "http://openapi.foodsafetykorea.go.kr/api/" + apiKey + "/COOKRCP01/json/1/100",
        HttpMethod.GET,
        null,
        String.class);
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(response.getBody());
      JsonNode rowNode = rootNode.path("COOKRCP01").path("row");

      for (JsonNode recipeNode : rowNode) {
        String name = recipeNode.path("RCP_NM").asText();
        long recipeId = Long.parseLong(recipeNode.path("RCP_SEQ").asText());
        String imageUrl = recipeNode.path("MANUAL_IMG01").asText();
        String partsDetails = recipeNode.path("RCP_PARTS_DTLS").asText();
        String cookingInstructions = recipeNode.path("MANUAL01").asText();

        Recipe recipe = new Recipe(0,recipeId, name, imageUrl, partsDetails, cookingInstructions);
        recipeRepository.save(recipe);
      }
      System.out.println("레시피 데이터를 저장했습니다.");
    } catch (Exception e) {
      System.err.println("레시피 데이터를 저장하는 도중 오류가 발생했습니다: " + e.getMessage());
    }
  }
}
