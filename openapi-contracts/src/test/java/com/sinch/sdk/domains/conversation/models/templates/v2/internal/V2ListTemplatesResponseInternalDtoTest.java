package com.sinch.sdk.domains.conversation.models.templates.v2.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.templates.v2.TemplateV2DtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.internal.V2ListTemplatesResponseInternal;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class V2ListTemplatesResponseInternalDtoTest extends TemplatesBaseTest {

  public static V2ListTemplatesResponseInternal expectedDto =
      V2ListTemplatesResponseInternal.builder()
          .setTemplates(Arrays.asList(TemplateV2DtoTest.expectedResponseDto))
          .build();

  @GivenTextResource(
      "/domains/conversation/templates/v2/internal/V2ListTemplatesResponseInternalDto.json")
  String json;

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, V2ListTemplatesResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
