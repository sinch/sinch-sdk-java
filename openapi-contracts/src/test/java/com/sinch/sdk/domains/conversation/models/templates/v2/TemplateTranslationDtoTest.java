package com.sinch.sdk.domains.conversation.models.templates.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.templates.TemplateVariableDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessageDtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TemplateTranslationDtoTest extends TemplatesBaseTest {

  public static TemplateTranslation expectedDto =
      TemplateTranslation.builder()
          .setMessage(TemplateMessageDtoTest.templateMessageDto)
          .setLanguageCode("fr-FR")
          .setVersion("1")
          .setChannelTemplateOverrides(
              Collections.singletonMap(
                  ConversationChannel.KAKAOTALK,
                  ChannelTemplateOverrideDtoTest.expectedWithVersionDto))
          .setVariables(Arrays.asList(TemplateVariableDtoTest.expectedDto))
          .setCreateTime(Instant.parse("2024-07-07T02:59:59Z"))
          .setUpdateTime(Instant.parse("2024-07-07T06:07:44Z"))
          .build();

  @GivenTextResource("/domains/conversation/templates/v2/TemplateTranslationDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, TemplateTranslation.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
