package com.sinch.sdk.domains.conversation.templates.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2DtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.internal.ListTemplatesResponseInternal;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class TemplatesV2ListResponseDtoTest extends TemplatesBaseTest {

  public static ListTemplatesResponseInternal expectedDto =
      ListTemplatesResponseInternal.builder()
          .setTemplates(Arrays.asList(TemplateV2DtoTest.expectedDto))
          .build();

  @GivenTextResource("/domains/conversation/templates/v2/response/TemplatesV2ListResponseDto.json")
  String json;

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, ListTemplatesResponseInternal.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
