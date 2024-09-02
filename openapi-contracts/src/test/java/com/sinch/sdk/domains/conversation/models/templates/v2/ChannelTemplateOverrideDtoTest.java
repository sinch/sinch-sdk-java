package com.sinch.sdk.domains.conversation.models.templates.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceDtoTest;
import com.sinch.sdk.domains.conversation.templates.models.v2.ChannelTemplateOverride;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChannelTemplateOverrideDtoTest extends TemplatesBaseTest {

  public static ChannelTemplateOverride expectedDto =
      ChannelTemplateOverride.builder()
          .setParameterMappings(Collections.singletonMap("a key", "a value"))
          .setTemplateReference(TemplateReferenceDtoTest.templateReferenceDto)
          .build();

  @GivenTextResource("/domains/conversation/templates/v2/ChannelTemplateOverrideDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(json, ChannelTemplateOverride.class);

    TestHelpers.recursiveEquals(deserialized, expectedDto);
  }
}
