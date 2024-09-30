package com.sinch.sdk.domains.conversation.models.templates.v2.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.templates.v2.TemplateTranslationDtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.internal.V2ListTranslationsResponseInternal;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class V2ListTranslationsResponseInternalDtoTest extends TemplatesBaseTest {

  public static V2ListTranslationsResponseInternal expectedDto =
      V2ListTranslationsResponseInternal.builder()
          .setTranslations(Arrays.asList(TemplateTranslationDtoTest.expectedDto))
          .build();

  @GivenTextResource(
      "/domains/conversation/templates/v2/internal/V2ListTranslationsResponseInternalDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, V2ListTranslationsResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
