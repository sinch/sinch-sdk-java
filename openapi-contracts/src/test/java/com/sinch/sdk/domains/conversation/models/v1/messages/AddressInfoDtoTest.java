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
public class AddressInfoDtoTest extends BaseTest {

  public static AddressInfo addressInfoDto =
      AddressInfo.builder()
          .setCity("city value")
          .setCountry("country value")
          .setState("state va@lue")
          .setZip("zip value")
          .setCountryCode("country_code value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/AddressInfoDto.json")
  String jsonAddressInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(addressInfoDto);

    JSONAssert.assertEquals(jsonAddressInfoDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAddressInfoDto, addressInfoDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(addressInfoDto);
  }
}
