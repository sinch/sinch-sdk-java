package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class PhoneNumberInfoDtoTest extends BaseTest {

  public static PhoneNumberInfo phoneNumberInfoDto =
      PhoneNumberInfo.builder().setPhoneNumber("phone_number value").setType("type value").build();

  @GivenTextResource("/domains/conversation/v1/messages/PhoneNumberInfoDto.json")
  String jsonPhoneNumberInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(phoneNumberInfoDto);

    JSONAssert.assertEquals(jsonPhoneNumberInfoDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonPhoneNumberInfoDto, phoneNumberInfoDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(phoneNumberInfoDto);
  }
}
