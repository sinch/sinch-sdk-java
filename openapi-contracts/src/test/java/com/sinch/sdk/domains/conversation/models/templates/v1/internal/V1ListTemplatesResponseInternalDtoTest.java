package com.sinch.sdk.domains.conversation.models.templates.v1.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.templates.v1.TemplateV1DtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v1.internal.V1ListTemplatesResponseInternal;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class V1ListTemplatesResponseInternalDtoTest extends TemplatesBaseTest {

  public static V1ListTemplatesResponseInternal expectedDto =
      V1ListTemplatesResponseInternal.builder()
          .setTemplates(Arrays.asList(TemplateV1DtoTest.expectedDto))
          .build();

  @GivenTextResource(
      "/domains/conversation/templates/v1/internal/V1ListTemplatesResponseInternalDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, V1ListTemplatesResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
