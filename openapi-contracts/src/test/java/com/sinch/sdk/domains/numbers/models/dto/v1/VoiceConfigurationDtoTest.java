package com.sinch.sdk.domains.numbers.models.dto.v1;

import static org.junit.jupiter.api.Assertions.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class VoiceConfigurationDtoTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/VoiceConfigurationDtoAppIdNull.json")
  String voiceConfigurationDtoAppIdNull;

  @GivenTextResource("/domains/numbers/v1/VoiceConfigurationDtoAppIdUndefined.json")
  String voiceConfigurationDtoAppIdUndefined;

  @GivenTextResource("/domains/numbers/v1/VoiceConfigurationDtoAppIdValue.json")
  String voiceConfigurationDtoAppIdValue;

  @Test
  void serializeAppIdNull() throws JsonProcessingException, JSONException {
    VoiceConfigurationDto dto = new VoiceConfigurationDto().appId(null);

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(voiceConfigurationDtoAppIdNull, serializedString, true);
  }

  @Test
  void serializeAppIdUndefined() throws JsonProcessingException, JSONException {
    VoiceConfigurationDto dto = new VoiceConfigurationDto();

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(voiceConfigurationDtoAppIdUndefined, serializedString, true);
  }

  @Test
  void serializeAppIdValue() throws JsonProcessingException, JSONException {
    VoiceConfigurationDto dto = new VoiceConfigurationDto().appId("my app id");

    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(voiceConfigurationDtoAppIdValue, serializedString, true);
  }
}
