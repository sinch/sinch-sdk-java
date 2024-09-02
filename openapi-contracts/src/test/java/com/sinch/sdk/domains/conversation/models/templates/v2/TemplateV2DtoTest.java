package com.sinch.sdk.domains.conversation.models.templates.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateV2DtoTest extends TemplatesBaseTest {

  public static TemplateV2 expectedDto =
      TemplateV2.builder()
          .setTranslations(Arrays.asList(TemplateTranslationDtoTest.expectedDto))
          .setDefaultTranslation("fr-FR")
          .setDescription("template description value")
          .setVersion(1)
          .setCreateTime(Instant.parse("2024-08-26T06:00:00Z"))
          .setUpdateTime(Instant.parse("2024-08-26T06:07:44Z"))
          .build();

  @GivenTextResource("/domains/conversation/templates/v2/TemplateV2Dto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, TemplateV2.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
