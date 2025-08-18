package com.sinch.sdk.domains.conversation.templates.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslationDtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.internal.ListTranslationsResponseInternal;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TranslationsV2ListResponseDtoTest extends TemplatesBaseTest {

  public static ListTranslationsResponseInternal expectedDto =
      ListTranslationsResponseInternal.builder()
          .setTranslations(Arrays.asList(TemplateTranslationDtoTest.expectedDto))
          .build();

  @GivenTextResource(
      "/domains/conversation/templates/v2/response/TranslationsV2ListResponseDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, ListTranslationsResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
