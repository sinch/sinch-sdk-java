package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class NameInfoDtoTest extends BaseTest {

  public static NameInfo nameInfoDto =
      NameInfo.builder()
          .setFullName("full_name value")
          .setFirstName("first_name value")
          .setLastName("last_name value")
          .setMiddleName("middle_name value")
          .setPrefix("prefix value")
          .setSuffix("suffix value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/NameInfoDto.json")
  String jsonNameInfoDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(nameInfoDto);

    JSONAssert.assertEquals(jsonNameInfoDto, serializedString, true);
  }
}
