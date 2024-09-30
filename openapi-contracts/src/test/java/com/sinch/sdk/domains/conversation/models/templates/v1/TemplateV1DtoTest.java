package com.sinch.sdk.domains.conversation.models.templates.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateChannel;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateV1DtoTest extends TemplatesBaseTest {

  public static TemplateV1 expectedDto =
      TemplateV1.builder()
          .setChannel(TemplateChannel.RCS)
          .setCreateTime(Instant.parse("2024-08-26T06:00:00Z"))
          .setDefaultTranslation("fr-FR")
          .setDescription("template description value")
          .setId("id value")
          .setTranslations(Arrays.asList(TemplateTranslationDtoTest.expectedDto))
          .setUpdateTime(Instant.parse("2024-08-26T06:07:44Z"))
          .build();

  @GivenTextResource("/domains/conversation/templates/v1/TemplateV1Dto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, TemplateV1.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
