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

  public static ChannelTemplateOverride expectedWithVersionDto =
      ChannelTemplateOverride.builder()
          .setParameterMappings(Collections.singletonMap("a key", "a value"))
          .setTemplateReference(TemplateReferenceDtoTest.templateReferenceWithVersionDto)
          .build();

  public static ChannelTemplateOverride expectedWithoutVersionDto =
      ChannelTemplateOverride.builder()
          .setParameterMappings(Collections.singletonMap("a key", "a value"))
          .setTemplateReference(TemplateReferenceDtoTest.templateReferenceWithoutVersionDto)
          .build();

  @GivenTextResource(
      "/domains/conversation/templates/v2/ChannelTemplateOverrideWithVersionDto.json")
  String jsonWithVersion;

  @GivenTextResource(
      "/domains/conversation/templates/v2/ChannelTemplateOverrideWithoutVersionDto.json")
  String jsonWithoutVersion;

  @Test
  void serializeWithVersion() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedWithVersionDto);

    JSONAssert.assertEquals(jsonWithVersion, serializedString, true);
  }

  @Test
  void deserializeWithVersion() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonWithVersion, ChannelTemplateOverride.class);

    TestHelpers.recursiveEquals(deserialized, expectedWithVersionDto);
  }

  @Test
  void serializeWithoutVersion() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedWithoutVersionDto);

    JSONAssert.assertEquals(jsonWithoutVersion, serializedString, true);
  }

  @Test
  void deserializeWithoutVersion() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonWithoutVersion, ChannelTemplateOverride.class);

    TestHelpers.recursiveEquals(deserialized, expectedWithoutVersionDto);
  }
}
