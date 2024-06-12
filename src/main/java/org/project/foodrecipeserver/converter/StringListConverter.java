package org.project.foodrecipeserver.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

  private static final ObjectMapper mapper = ObjectMapperFactory.getInstance();

  @Override
  public String convertToDatabaseColumn(List<String> dataList) {
    try {
      return mapper.writeValueAsString(dataList);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<String> convertToEntityAttribute(String data) {
    try {
      return mapper.readValue(data, List.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}