package com.nterra.springboot3_advanced.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SettingsConverter implements AttributeConverter<Settings, JsonNode> {
  public static final ObjectMapper om = new ObjectMapper();

  @Override
  public JsonNode convertToDatabaseColumn(Settings attribute) {

      return om.valueToTree(attribute);
  }

  @Override
  public Settings convertToEntityAttribute(JsonNode dbData) {
    try {
      return om.treeToValue(dbData, Settings.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
