package org.project.foodrecipeserver.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  private ObjectMapperFactory() {}

  public static ObjectMapper getInstance() {
    return objectMapper;
  }
}