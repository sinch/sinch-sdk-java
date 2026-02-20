package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesBaseTest;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateV2DtoTest extends TemplatesBaseTest {

  @GivenTextResource("/domains/conversation/templates/v2/request/TemplateV2RequestDto.json")
  String requestJSON;

  @GivenTextResource("/domains/conversation/templates/v2/TemplateV2Dto.json")
  String responseSON;

  public static TemplateV2 expectedDto =
      TemplateV2.builder()
          .setId("template ID")
          .setTranslations(Arrays.asList(TemplateTranslationDtoTest.expectedDto))
          .setDefaultTranslation("fr-FR")
          .setDescription("template description value")
          .setVersion(1)
          .setCreateTime(Instant.parse("2024-08-26T06:00:00Z"))
          .setUpdateTime(Instant.parse("2024-08-26T06:07:44Z"))
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(requestJSON, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(responseSON, TemplateV2.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
