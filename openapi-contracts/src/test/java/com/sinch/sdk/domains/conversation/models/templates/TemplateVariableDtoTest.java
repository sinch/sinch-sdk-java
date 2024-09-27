package com.sinch.sdk.domains.conversation.models.templates;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateVariableDtoTest extends TemplatesBaseTest {

  public static TemplateVariable expectedDto =
      TemplateVariable.builder().setKey("key value").setPreviewValue("preview value").build();

  @GivenTextResource("/domains/conversation/templates/TemplateVariableDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, TemplateVariable.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
